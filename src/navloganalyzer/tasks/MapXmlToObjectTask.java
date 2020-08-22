/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navloganalyzer.tasks;

import java.io.File;
import javax.swing.SwingWorker;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import navloganalyzer.AppConstants;
import navloganalyzer.models.Events;
import navloganalyzer.utils.FilesUtils;

public class MapXmlToObjectTask extends SwingWorker<Void, Object>{

    private Events events;
    
    @Override
    protected Void doInBackground() throws Exception {
        System.out.println("navloganalyzer.tasks.MapXmlToObjectTask.doInBackground()");
        File location = new File(FilesUtils.getUserWorkingDir(), AppConstants.Folders.CLEANED_FILES_LOCATION);
        System.out.println(location);
        if(location.exists()) {
            for(File item : location.listFiles()) {
                System.out.println("Item: " + item);
                if(item.isFile()) {  
                    JAXBContext jaxbContext;
                    XMLStreamReader xsr = null;
                    try
                    {
                        jaxbContext = JAXBContext.newInstance(Events.class);   
                        XMLInputFactory xif  = XMLInputFactory.newFactory();
                        xif.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false);
                        StreamSource source = new StreamSource(item);
                        xsr = xif.createXMLStreamReader(source);
                        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                        Events data = (Events) jaxbUnmarshaller.unmarshal(xsr);
                        System.out.println(data);
                    }
                    catch (JAXBException e) 
                    {
                        e.printStackTrace(System.err);
                        System.out.println("navloganalyzer.tasks.MapXmlToObjectTask.doInBackground() CATCH");
                    }
                    catch (Exception e) {
                        e.printStackTrace(System.err);
                        System.out.println("navloganalyzer.tasks.MapXmlToObjectTask.doInBackground() CATCH2");
                    } finally {
                        xsr.close();
                    }
                }
            }
        }
        return null;
    }
      
    
}
