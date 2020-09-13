package navloganalyzer.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import navloganalyzer.AppConstants;

public class StudentAttendanceItem {
    private transient static List<StudentAttendanceItem> resultList = new ArrayList<>();
    private transient static Map<String, StudentAttendanceItem> cacheMap = new HashMap<>();
    
    private String username;
    private Date logOn;
    private Date logOff;
    private transient SimpleDateFormat sdfDateTime;
    private transient SimpleDateFormat sdfTime;
    
    public StudentAttendanceItem(FilteredDataItem dataItem) {
        this.username = dataItem.getUsername();
        if(dataItem.getEventId() == AppConstants.WinEvent.LOG_ON) {
            this.logOn = dataItem.getCreatedAt();
        } else if(dataItem.getEventId() == AppConstants.WinEvent.LOG_OFF) {
            this.logOff = dataItem.getCreatedAt();
        }
        if(sdfDateTime == null || sdfTime == null) {
            setupFromatters();
        }
    }
    
    private void setupFromatters() {
        sdfDateTime = new SimpleDateFormat("dd.MM.YYYY. HH:mm");
        sdfTime = new SimpleDateFormat("HH:mm");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLogOn() {
        return logOn;
    }

    public void setLogOn(Date logOn) {
        this.logOn = logOn;
    }

    public Date getLogOff() {
        return logOff;
    }

    public void setLogOff(Date logOff) {
        this.logOff = logOff;
    }
    
    public boolean isLogOn() {
        return this.logOn != null;
    }
    
    public boolean isLogOff() {
        return this.logOff != null;
    }
    
    public String getLogOnTimeFormatted() {
        if(this.sdfDateTime == null) {
            setupFromatters();
        }
        return logOn == null ? "-" : this.sdfDateTime.format(logOn);
    }
    
    public String getLogOffTimeFormatted() {
        if(sdfDateTime == null) {
            setupFromatters();
        }
        return logOff == null ? "-" : this.sdfDateTime.format(logOff);
    }
    
    public String getDifferenceTimeFormatted() {
        if(this.sdfTime == null) {
            setupFromatters();
        }
        String outcome = "-";
        if(logOn != null && logOff != null) {
            long time = logOff.getTime() - logOn.getTime();
            Date diff = new Date(time);
            outcome = sdfTime.format(diff);
        }
        return outcome;
    }
    
    public  static List<StudentAttendanceItem> convert(List<FilteredDataItem> items) {
        List<StudentAttendanceItem> outcomeList = new ArrayList<>();
        for(FilteredDataItem item : items) {
            if(cacheMap.containsKey(item.getUsername())) {
                int index = outcomeList.indexOf(cacheMap.get(item.getUsername()));
                StudentAttendanceItem old = outcomeList.get(index);
                if(item.isLogOff() && (old.isLogOn() && !old.isLogOff() && old.getLogOn().before(item.getCreatedAt()) || old.isLogOff() && !old.isLogOn())) {
                    if(old.isLogOff() && !old.isLogOn() && item.isLogOff()) continue;
                    old.setLogOff(item.getCreatedAt());
                    cacheMap.replace(item.getUsername(), old);
                } else if(item.isLogOn() && old.isLogOff() && 
                        (
                           (!old.isLogOn() && old.getLogOff().after(item.getCreatedAt()) || old.isLogOn() && !old.isLogOff()) ||
                           (old.isLogOn() && old.getLogOn().after(item.getCreatedAt()) && old.getLogOff().after(item.getCreatedAt()))
                        )
                  ) {
                    old.setLogOn(item.getCreatedAt());
                    cacheMap.replace(item.getUsername(), old);
                } else {
                    StudentAttendanceItem newItem = new StudentAttendanceItem(item);
                    outcomeList.add(newItem);
                    cacheMap.put(item.getUsername(), newItem);
                }
            } else {
                StudentAttendanceItem newItem = new StudentAttendanceItem(item);
                outcomeList.add(newItem);
                cacheMap.put(item.getUsername(), newItem);
            }
        }
        return outcomeList;
    }
    
    public String[] getRow() {
        return new String[]{getUsername(), getLogOnTimeFormatted(), getLogOffTimeFormatted(), getDifferenceTimeFormatted()};
    }
}
