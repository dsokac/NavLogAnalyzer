package navloganalyzer.models;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Events")
public class Events {
    
    private List<XmlEvent> eventList;

    @XmlElement(name="Event")
    public List<XmlEvent> getEventList() {
        return eventList;
    }

    public void setEventList(List<XmlEvent> eventList) {
        this.eventList = eventList;
    }
}
