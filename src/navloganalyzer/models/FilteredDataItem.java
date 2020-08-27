package navloganalyzer.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import navloganalyzer.AppConstants;

public class FilteredDataItem {
    
    private String username;
    private int eventId;
    private String logonType;
    private Date createdAt;
    
    public FilteredDataItem(XmlEvent event) {
        this.username = event.getEventData().getTargetUserName();
        this.eventId = event.getSystemData().getEventId();
        this.logonType = event.getEventData().getLogonType();
        this.createdAt = event.getSystemData().getTimeCreated().getSystemTime();
    }
    
    public static List<FilteredDataItem> convertItems(List<Events> eventsList) {
        List<FilteredDataItem>  list = new ArrayList<>();
        for(Events events : eventsList) {
            for (XmlEvent event : events.getEventList()) {
                list.add(new FilteredDataItem(event));
            }
        }
        return list;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getLogonType() {
        return logonType;
    }

    public void setLogonType(String logonType) {
        this.logonType = logonType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public boolean isLogOn() {
        return this.eventId == AppConstants.WinEvent.LOG_ON;
    }
    
    public boolean isLogOff() {
        return this.eventId == AppConstants.WinEvent.LOG_OFF;
    }
    
}
