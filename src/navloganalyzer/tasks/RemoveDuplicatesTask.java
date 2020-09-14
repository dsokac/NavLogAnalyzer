package navloganalyzer.tasks;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import navloganalyzer.AppConstants;
import navloganalyzer.models.FilteredDataItem;
import navloganalyzer.utils.FilesUtils;

public class RemoveDuplicatesTask extends SwingWorker<List<FilteredDataItem>, Object>{

    private List<FilteredDataItem> filteredItems;
    private Listener listener;
    private int total;
    private int current = 0;
    private List<FilteredDataItem> processedItems = new ArrayList<>();
    private FilesUtils filesUtils = FilesUtils.getInstance();
    
    public RemoveDuplicatesTask(List<FilteredDataItem> filteredItems, Listener listener) {
        this.filteredItems = filteredItems;
        this.listener = listener;
    }
    
    @Override
    protected List<FilteredDataItem> doInBackground() throws Exception {
        System.out.println("navloganalyzer.tasks.RemoveDuplicatesTask.doInBackground()");
        this.listener.onTaskStarted("Removing duplicates...");
        total = filteredItems.size();
        for(FilteredDataItem item : filteredItems) {
            if(!doesItemExist(item)) {
                processedItems.add(item);
            }
            this.progressChange();
        }
        return processedItems;
    }
    
    private boolean doesItemExist(FilteredDataItem target) {
        boolean outcome = false;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY. HH:mm");
        for(FilteredDataItem item : processedItems) {
            String itemDate = sdf.format(item.getCreatedAt());
            String targetDate = sdf.format(target.getCreatedAt());
            if(
                    item.getUsername().equals(target.getUsername()) &&
                    item.getLogonType().equals(target.getLogonType()) &&
                    item.getEventId() == target.getEventId() &&
                    sdf.format(item.getCreatedAt()).equals(sdf.format(target.getCreatedAt()))
                    ) {
                outcome = true;
                break;
            }
        }
        return outcome;
    }
    
    private void progressChange() {
        current++;
        int precent = (int)((current / (float)total)*100);
        this.listener.onProgressStatusChanged(precent);
    }

    @Override
    protected void done() {
        System.out.println("navloganalyzer.tasks.RemoveDuplicatesTask.done()");
        this.listener.onTaskFinished(AppConstants.Tasks.REMOVE_DUPLICATES_TASK, processedItems);
        List<String> lines = new ArrayList<>();
        for(FilteredDataItem item : processedItems) {
            String output =  String.format("%s - %s - %d - %s", 
                                item.getUsername(), 
                                item.getCreatedAt(), 
                                item.getEventId(),
                                item.getLogonType()
                        );
            lines.add(output);
        }
        try {
            filesUtils.writeToFile(filesUtils.getUserWorkingDir(), "logAnalysis-noDuplicates.txt", lines, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(RemoveIrrelevantElementsTask.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RemoveDuplicatesTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public interface Listener {
        void onTaskStarted(String taskDescription);
        void onTaskFinished(String taskName, Object processedItems);
        void onProgressStatusChanged(int progress);
    }
    
}
