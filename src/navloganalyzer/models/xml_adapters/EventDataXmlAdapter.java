package navloganalyzer.models.xml_adapters;

import java.beans.PropertyDescriptor;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import navloganalyzer.models.EventData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EventDataXmlAdapter extends XmlAdapter<Object, EventData>{

    private DocumentBuilder documentBuilder;
    
    public EventDataXmlAdapter() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            documentBuilder = dbf.newDocumentBuilder();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public EventData unmarshal(Object v) throws Exception {
        EventData eventData = new EventData();
        Element element = (Element)v;
        if(element.getTagName().equals("EventData")) {
            NodeList dataNodes = element.getElementsByTagName("Data");
            for(int i = 0; i < dataNodes.getLength(); i++) {
                Node currentNode = dataNodes.item(i);
                if(currentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element currentElement = (Element)currentNode;
                    String nameValue = currentElement.getAttribute("Name");
                    char c[] = nameValue.toCharArray();
                    c[0] = Character.toLowerCase(c[0]);
                    nameValue = new String(c);

                    String value = currentElement.getTextContent();
                    PropertyDescriptor pd = new PropertyDescriptor(nameValue, EventData.class);
                    pd.getWriteMethod().invoke(eventData, value);
                }
            }
        } else {
            throw new Exception("Incorrect root element, required = EventData.");
        }
        return eventData;
    }

    @Override
    public Object marshal(EventData v) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
