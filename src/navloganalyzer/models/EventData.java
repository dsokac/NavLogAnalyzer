package navloganalyzer.models;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import navloganalyzer.models.xml_adapters.EventDataXmlAdapter;

@XmlRootElement(name="EventData")
@XmlJavaTypeAdapter(EventDataXmlAdapter.class)
public class EventData {
    private String targetUserName;
    private String targetDomainName;
    private String logonType;
    private String subjectUserName;
    private String subjectDomainName;
    private String workstationName;
    private String ipAddress;
    private String ipPort;
    
    public EventData(){}

    public String getTargetUserName() {
        return targetUserName;
    }

    public void setTargetUserName(String targetUserName) {
        this.targetUserName = targetUserName;
    }

    public String getTargetDomainName() {
        return targetDomainName;
    }

    public void setTargetDomainName(String targetDomainName) {
        this.targetDomainName = targetDomainName;
    }

    public String getLogonType() {
        return logonType;
    }

    public void setLogonType(String logonType) {
        this.logonType = logonType;
    }

    public String getSubjectUserName() {
        return subjectUserName;
    }

    public void setSubjectUserName(String subjectUserName) {
        this.subjectUserName = subjectUserName;
    }

    public String getSubjectDomainName() {
        return subjectDomainName;
    }

    public void setSubjectDomainName(String subjectDomainName) {
        this.subjectDomainName = subjectDomainName;
    }

    public String getWorkstationName() {
        return workstationName;
    }

    public void setWorkstationName(String workstationName) {
        this.workstationName = workstationName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpPort() {
        return ipPort;
    }

    public void setIpPort(String ipPort) {
        this.ipPort = ipPort;
    }

    
    
    
}
