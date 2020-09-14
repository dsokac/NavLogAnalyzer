package navloganalyzer.tasks;

import java.io.File;
import java.nio.charset.Charset;
import javax.swing.SwingWorker;
import navloganalyzer.AppConstants;
import navloganalyzer.listeners.ProgressListener;
import navloganalyzer.utils.FilesUtils;
import navloganalyzer.utils.XmlUtils;

public class CleanXmlTask extends SwingWorker<Void, Object> implements ProgressListener{

    private Charset charset;
    private int numberOfFiles = -1;
    private int currentProgress = 0;
    private int totalProgress = -1;
    private Listener listener;
    private FilesUtils filesUtils = FilesUtils.getInstance();
    
    public CleanXmlTask(Charset charset, Listener listener) {
        this.charset = charset;
        this.listener = listener;
    }
    
    @Override
    protected Void doInBackground() throws Exception {
        System.out.println("navloganalyzer.tasks.CleanXmlTask.doInBackground()");
        listener.onTaskStarted("Cleaning files...");
        File rawFilesLocation = new File(filesUtils.getUserWorkingDir(), AppConstants.Folders.RAW_FILES_ENTRY_LOCATION);
        File cleanFilesLocation = new File(filesUtils.getUserWorkingDir(), AppConstants.Folders.CLEANED_FILES_LOCATION);
        
        if(!cleanFilesLocation.exists()) {
            cleanFilesLocation.mkdirs();
        }
        if(rawFilesLocation.exists()) {
            this.numberOfFiles = rawFilesLocation.listFiles().length;
            this.totalProgress = this.numberOfFiles * 25;
            for(File item : rawFilesLocation.listFiles()){
                if(item.isFile()) {
                    String fileName = item.getName();
                    String content = filesUtils.getFileContent(item, charset);
                    content = XmlUtils.removeRows(content, this);
                    filesUtils.storeFile(cleanFilesLocation, fileName, content, charset);
                }
            }
        }
        return null;
    }

    @Override
    protected void done() {
        System.out.println("navloganalyzer.tasks.CleanXmlTask.done()");
        listener.onTaskFinished(AppConstants.Tasks.CLEAN_FILES_TASK);
    }

    @Override
    public void onProgressUpdate() {
        currentProgress++;
        int percent = (int)((currentProgress / (float)totalProgress)*100);
        System.out.println(".onProgressUpdate()");
        System.out.println("currentProgress = " + currentProgress);
        System.out.println("totalProgress = " + totalProgress);
        System.out.println("Percent = " + percent);
        listener.onTaskProgressChanged(percent);
    }
    
    public interface Listener {
        void onTaskStarted(String taskDescription);
        void onTaskFinished(String taskName);
        void onTaskProgressChanged(int progress);
    }
    
}
