package navloganalyzer.models.xml_adapters;

import java.util.List;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import navloganalyzer.models.XmlEvent;

public class EventsXmlAdapter extends XmlAdapter<Object, List<XmlEvent>>{

    @Override
    public List<XmlEvent> unmarshal(Object v) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object marshal(List<XmlEvent> v) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
