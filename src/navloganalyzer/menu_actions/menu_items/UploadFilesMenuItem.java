package navloganalyzer.menu_actions.menu_items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import navloganalyzer.NavLogAnalyzer;
import navloganalyzer.listeners.FilesUploadListener;
import navloganalyzer.tasks.FileUploadTask;
import navloganalyzer.utils.FilesUtils;
import navloganalyzer.utils.WindowUtils;

public class UploadFilesMenuItem extends AppAbstractMenuItem{
    
    public UploadFilesMenuItem() {
        setText("Upload files");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File[] chosen = WindowUtils.fetchChosenFiles(getMenu().getMenuBar().getFrame());
                if(chosen != null) {
                    FileUploadTask task = new FileUploadTask(chosen, (FilesUploadListener)getMenu().getMenuBar().getFrame());
                    task.execute();
                }
            }
        });
    }
    
}
