package navloganalyzer.models;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="System")
public class SystemData implements Serializable{
    
    private int eventId;  
    private TimeCreated timeCreated;
    private String computer;
    
    public SystemData() {}

    @Override
    public String toString() {
        return String.format("System[ eventId=%d, timeCreated=%s, computer=%s", eventId, timeCreated, computer);
    }

    @XmlElement(name="EventID") 
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
  
    @XmlElement(name="TimeCreated")
    public TimeCreated getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(TimeCreated timeCreated) {
        this.timeCreated = timeCreated;
    }

    @XmlElement(name="Computer") 
    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }
    
    
}
