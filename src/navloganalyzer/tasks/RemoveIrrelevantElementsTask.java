/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navloganalyzer.tasks;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import navloganalyzer.AppConstants;
import navloganalyzer.models.Events;
import navloganalyzer.models.FilteredDataItem;
import navloganalyzer.models.XmlEvent;
import navloganalyzer.utils.FilesUtils;

/**
 *
 * @author DanijelSokac
 */
public class RemoveIrrelevantElementsTask extends SwingWorker<List<FilteredDataItem>, Object>{

    private List<Events> eventsList = null;
    private Listener listener;
    private int total = 0;
    private int current = 0;
    private List<FilteredDataItem> processedItems = new ArrayList<>();
    
    public RemoveIrrelevantElementsTask(Listener listener, List<Events> eventsList) {
        this.eventsList = eventsList;
        this.listener = listener;
    }
    
    @Override
    protected List<FilteredDataItem> doInBackground() throws Exception {
        System.out.println("navloganalyzer.tasks.RemoveIrrelevantElementsTask.doInBackground()");
        this.listener.onTaskStarted("Removing irrelevant elements from memory...");
        for(Events events : eventsList) {
            total += events.getEventList().size();
        }
        List<Events> processedEventsList = new ArrayList<>();
        for(Events events : eventsList) {
            Events processedEvents = new Events();
            List<XmlEvent> eventList = new ArrayList<>();
            for(XmlEvent event : events.getEventList()) {
                this.updateProgressStatus();
                if(event != null && event.getEventData() != null && event.getEventData().getTargetUserName().startsWith("student")) {
                    eventList.add(event);
                }
            }
            processedEvents.setEventList(eventList);
            processedEventsList.add(processedEvents);
        }
        processedItems = FilteredDataItem.convertItems(processedEventsList);
        return processedItems;
    }
    
    @Override
    protected void done() {
        System.out.println("navloganalyzer.tasks.RemoveIrrelevantElementsTask.done()");    
        this.listener.onTaskFinished(AppConstants.Tasks.REMOVE_ELEMENTS_TASK, processedItems);
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
            FilesUtils.writeToFile(FilesUtils.getUserWorkingDir(), "logAnalysis.txt", lines, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(RemoveIrrelevantElementsTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateProgressStatus() {
        current++;
        int percent = (int)((current / (float)total) * 100);
        this.listener.onProgressStatusChanged(percent);
    }
    
    public interface Listener {
        void onTaskStarted(String taskDescription);
        void onTaskFinished(String taskName, Object filteredItems);
        void onProgressStatusChanged(int progress);
    }
    
}
