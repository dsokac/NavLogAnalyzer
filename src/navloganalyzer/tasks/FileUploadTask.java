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
import navloganalyzer.listeners.FilesUploadListener;
import navloganalyzer.utils.FilesUtils;

/**
 *
 * @author DanijelSokac
 */
public class FileUploadTask extends SwingWorker<File[], Object>{

    private File[] chosenFiles = null;
    private File[] uploadedFiles = null;
    private FilesUploadListener listener;
    
    public FileUploadTask(File[] chosenFiles, FilesUploadListener listener) {
        this.chosenFiles = chosenFiles;
        this.listener = listener;
    }
    
    @Override
    protected File[] doInBackground() throws Exception {
        this.listener.onUploadStarted();
        this.uploadedFiles = new File[this.chosenFiles.length];
        int count = 0;
        for(File file : this.chosenFiles) {
            try {
                System.out.println(file.getAbsolutePath());
                File folderLocation = new File(FilesUtils.getUserWorkingDir(),AppConstants.Folders.RAW_FILES_ENTRY_LOCATION);
                File storedFile = FilesUtils.storeFile(folderLocation, file, StandardCharsets.UTF_8);
                this.uploadedFiles[count++] = storedFile;
                int progress = (int)((count/(double)this.chosenFiles.length)*100);
                this.listener.onProgressStatusChanged(progress);
            } catch (Exception ex) {
                Logger.getLogger(NavLogAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.uploadedFiles;
    }

    @Override
    protected void done() {
        this.listener.onUploadFinished();
    }
    
    
  
    
}
