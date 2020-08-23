/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navloganalyzer.tasks;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingWorker;
import navloganalyzer.AppConstants;
import navloganalyzer.models.Events;
import navloganalyzer.models.XmlEvent;

/**
 *
 * @author DanijelSokac
 */
public class RemoveIrrelevantElementsTask extends SwingWorker<List<Events>, Object>{

    private List<Events> eventsList = null;
    private Listener listener;
    private int total = 0;
    private int current = 0;
    
    public RemoveIrrelevantElementsTask(Listener listener, List<Events> eventsList) {
        this.eventsList = eventsList;
        this.listener = listener;
    }
    
    @Override
    protected List<Events> doInBackground() throws Exception {
        System.out.println("navloganalyzer.tasks.RemoveIrrelevantElementsTask.doInBackground()");
        this.listener.onTaskStarted(AppConstants.Tasks.REMOVE_ELEMENTS_TASK);
        List<Events> processedEventsList = new ArrayList<>();
        for(Events events : eventsList) {
            Events processedEvents = new Events();
            List<XmlEvent> eventList = new ArrayList<>();
            for(XmlEvent event : events.getEventList()) {
                if(event.getEventData() != null && event.getEventData().getTargetUserName().startsWith("student")) {
                    eventList.add(event);
                }
            }
            processedEvents.setEventList(eventList);
            processedEventsList.add(processedEvents);
        }
        
        return processedEventsList;
    }
    
    @Override
    protected void done() {
        System.out.println("navloganalyzer.tasks.RemoveIrrelevantElementsTask.done()");    
        this.listener.onTaskFinished(AppConstants.Tasks.REMOVE_ELEMENTS_TASK, eventsList);
    }
    
    public interface Listener {
        void onTaskStarted(String taskDescription);
        void onTaskFinished(String taskName, List<Events> eventsList);
        void onProgressStatusChanged(int progress);
    }
    
}
