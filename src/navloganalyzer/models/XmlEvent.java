package navloganalyzer.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import navloganalyzer.models.xml_adapters.EventDataXmlAdapter;

@XmlRootElement(name = "Event")
public class XmlEvent{
    private EventData eventData;
    private SystemData systemData;
        
    public XmlEvent() {}

    @XmlElement(name = "System")
    public SystemData getSystemData() {
        return systemData;
    }

    public void setSystemData(SystemData systemData) {
        this.systemData = systemData;
    }

    @XmlElement(name = "EventData")
    @XmlJavaTypeAdapter(EventDataXmlAdapter.class)
    public EventData getEventData() {
        return eventData;
    }

    public void setEventData(EventData eventData) {
        this.eventData = eventData;
    }
}
