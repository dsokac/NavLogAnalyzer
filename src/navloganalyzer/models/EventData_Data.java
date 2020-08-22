package navloganalyzer.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Data")
public class EventData_Data {
    private String targetUserName;
    private String targetDomainName;
    private int logonType;
    private String subjectUserName;
    private String subjectDomainName;
    private String workstationName;
    private String ipAddress;
    private String ipPort;
    
    public EventData_Data(){}

    @XmlAttribute(name = "TargetUserName")
    public String getTargetUserName() {
        return targetUserName;
    }

    public void setTargetUserName(String targetUserName) {
        this.targetUserName = targetUserName;
    }

    @XmlAttribute(name = "TargetDomainName")
    public String getTargetDomainName() {
        return targetDomainName;
    }

    public void setTargetDomainName(String targetDomainName) {
        this.targetDomainName = targetDomainName;
    }

    @XmlAttribute(name = "LogonType")
    public int getLogonType() {
        return logonType;
    }

    public void setLogonType(int logonType) {
        this.logonType = logonType;
    }

    @XmlAttribute(name = "SubjectUserName")
    public String getSubjectUserName() {
        return subjectUserName;
    }

    public void setSubjectUserName(String subjectUserName) {
        this.subjectUserName = subjectUserName;
    }

    @XmlAttribute(name = "SubjectDomainName")
    public String getSubjectDomainName() {
        return subjectDomainName;
    }

    public void setSubjectDomainName(String subjectDomainName) {
        this.subjectDomainName = subjectDomainName;
    }
    
    @XmlAttribute(name = "WorkstationName")
    public String getWorkstationName() {
        return workstationName;
    }

    public void setWorkstationName(String workstationName) {
        this.workstationName = workstationName;
    }

    @XmlAttribute(name = "IpAddress")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @XmlAttribute(name = "IpPort")
    public String getIpPort() {
        return ipPort;
    }

    public void setIpPort(String ipPort) {
        this.ipPort = ipPort;
    }
    
    
}
