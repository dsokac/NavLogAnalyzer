package navloganalyzer.models;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"systemTime"})
public class TimeCreated {
    private Date systemTime;

    public TimeCreated(){}
    
    public TimeCreated(Date systemTime) {
        this.systemTime = systemTime;
    }
    
    @XmlAttribute(name="SystemTime")
    public Date getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }
    
    
}
