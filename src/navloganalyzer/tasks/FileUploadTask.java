/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navloganalyzer.tasks;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import navloganalyzer.AppConstants;
import navloganalyzer.NavLogAnalyzer;
import navloganalyzer.utils.FilesUtils;

/**
 *
 * @author DanijelSokac
 */
public class FileUploadTask extends SwingWorker<File[], Object>{

    private File[] chosenFiles = null;
    private File[] uploadedFiles = null;
    private Listener listener;
    private FilesUtils filesUtils = FilesUtils.getInstance();
    
    public FileUploadTask(File[] chosenFiles, Listener listener) {
        this.chosenFiles = chosenFiles;
        this.listener = listener;
    }
    
    @Override
    protected File[] doInBackground() throws Exception {
        this.listener.onTaskStarted("Uploading files...");
        this.uploadedFiles = new File[this.chosenFiles.length];
        int count = 0;
        for(File file : this.chosenFiles) {
            try {
                System.out.println(file.getAbsolutePath());
                File folderLocation = new File(filesUtils.getUserWorkingDir(),AppConstants.Folders.RAW_FILES_ENTRY_LOCATION);
                File storedFile = filesUtils.storeFile(folderLocation, file, StandardCharsets.UTF_8);
                this.uploadedFiles[count++] = storedFile;
                int progress = (int)((count/(double)this.chosenFiles.length)*100);
                this.listener.onTaskProgressChanged(progress);
            } catch (Exception ex) {
                Logger.getLogger(NavLogAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.uploadedFiles;
    }

    @Override
    protected void done() {
        this.listener.onTaskFinished(AppConstants.Tasks.UPLOAD_TASK);
    }
    
    
    public interface Listener {
        void onTaskStarted(String taskDescription);
        void onTaskFinished(String taskName);
        void onTaskProgressChanged(int progress);
    }

}
