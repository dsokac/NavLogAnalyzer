package navloganalyzer.tasks;

import java.io.File;
import java.nio.charset.Charset;
import javax.swing.SwingWorker;
import navloganalyzer.AppConstants;
import navloganalyzer.listeners.CleanFileListener;
import navloganalyzer.listeners.ProgressListener;
import navloganalyzer.utils.FilesUtils;
import navloganalyzer.utils.XmlUtils;

public class CleanXmlTask extends SwingWorker<Void, Object> implements ProgressListener{

    private Charset charset;
    private int numberOfFiles = -1;
    private int currentProgress = 0;
    private int totalProgress = -1;
    private CleanFileListener listener;
    
    public CleanXmlTask(Charset charset, CleanFileListener listener) {
        this.charset = charset;
        this.listener = listener;
    }
    
    @Override
    protected Void doInBackground() throws Exception {
        System.out.println("navloganalyzer.tasks.CleanXmlTask.doInBackground()");
        listener.onCleanStarted();
        File rawFilesLocation = new File(FilesUtils.getUserWorkingDir(), AppConstants.Folders.RAW_FILES_ENTRY_LOCATION);
        File cleanFilesLocation = new File(FilesUtils.getUserWorkingDir(), AppConstants.Folders.CLEANED_FILES_LOCATION);
        
        if(!cleanFilesLocation.exists()) {
            cleanFilesLocation.mkdirs();
        }
        if(rawFilesLocation.exists()) {
            this.numberOfFiles = rawFilesLocation.listFiles().length;
            this.totalProgress = this.numberOfFiles * 25;
            for(File item : rawFilesLocation.listFiles()){
                if(item.isFile()) {
                    String fileName = item.getName();
                    String content = FilesUtils.getFileContent(item, charset);
                    content = XmlUtils.removeRows(content, this);
                    FilesUtils.storeFile(cleanFilesLocation, fileName, content, charset);
                }
            }
        }
        return null;
    }

    @Override
    protected void done() {
        System.out.println("navloganalyzer.tasks.CleanXmlTask.done()");
        listener.onCleanFinished();
        MapXmlToObjectTask task = new MapXmlToObjectTask();
        task.execute();
    }

    @Override
    public void onProgressUpdate() {
        currentProgress++;
        int percent = (int)((currentProgress / (float)totalProgress)*100);
        System.out.println(".onProgressUpdate()");
        System.out.println("currentProgress = " + currentProgress);
        System.out.println("totalProgress = " + totalProgress);
        System.out.println("Percent = " + percent);
        listener.onProgressStatusChanged(percent);
    }
    
    
}
