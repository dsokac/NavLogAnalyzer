package navloganalyzer.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import navloganalyzer.listeners.ProgressListener;
import navloganalyzer.models.raw_models.RawElementSimpleSpecs;
import navloganalyzer.models.raw_models.RawDataElementWithSingleNameAttributeSpecs;

public abstract class XmlUtils {
    public static String removeRows(String content, ProgressListener listener) {
        ArrayList<RawElementSimpleSpecs> elements = new ArrayList<>();
        elements.add(new RawElementSimpleSpecs("Provider", true));
        elements.add(new RawElementSimpleSpecs("Version", false));
        elements.add(new RawElementSimpleSpecs("Level", false));
        elements.add(new RawElementSimpleSpecs("Task", false));
        elements.add(new RawElementSimpleSpecs("Opcode", false));
        elements.add(new RawElementSimpleSpecs("Keywords", false));
        elements.add(new RawElementSimpleSpecs("EventRecordID", false));
        elements.add(new RawElementSimpleSpecs("Channel", false));
        elements.add(new RawElementSimpleSpecs("Correlation", true));
        elements.add(new RawElementSimpleSpecs("Execution", true));
        elements.add(new RawElementSimpleSpecs("Security", true));
        elements.add(new RawDataElementWithSingleNameAttributeSpecs("TargetUserSid"));
        elements.add(new RawDataElementWithSingleNameAttributeSpecs("TargetLogonId"));
        elements.add(new RawDataElementWithSingleNameAttributeSpecs("SubjectUserSid"));
        elements.add(new RawDataElementWithSingleNameAttributeSpecs("SubjectLogonId"));
        elements.add(new RawDataElementWithSingleNameAttributeSpecs("LogonProcessName"));
        elements.add(new RawDataElementWithSingleNameAttributeSpecs("AuthenticationPackageName"));
        elements.add(new RawDataElementWithSingleNameAttributeSpecs("LogonGuid"));
        elements.add(new RawDataElementWithSingleNameAttributeSpecs("TransmittedServices"));
        elements.add(new RawDataElementWithSingleNameAttributeSpecs("LmPackageName"));
        elements.add(new RawDataElementWithSingleNameAttributeSpecs("KeyLength"));
        elements.add(new RawDataElementWithSingleNameAttributeSpecs("ProcessId"));
        elements.add(new RawDataElementWithSingleNameAttributeSpecs("ProcessName"));
        elements.add(new RawDataElementWithSingleNameAttributeSpecs("ImpersonationLevel"));
        
        content = removeElements(content, elements, listener);
        /*Pattern p = Pattern.compile("<Event(.*)>");
        Matcher matcher = p.matcher(content);
        String replaceable = matcher.group(1);
        content = content.replaceAll(replaceable, "");*/
        
        content = content.replaceAll("(?m)^[ \t]*\r?\n", "");
        listener.onProgressUpdate();
        System.out.println("navloganalyzer.utils.XmlUtils.removeRows()");
        //System.out.println("Result:");
        //System.out.println(content);        
        return content;
    }
    
    public static String removeElements(String content, ArrayList<RawElementSimpleSpecs> elements, ProgressListener  listener) {
        for(RawElementSimpleSpecs item : elements) {
            content = removeElement(content, item);
            listener.onProgressUpdate();
        }
        return content;
    }
    
    public static String removeElement(String content, RawElementSimpleSpecs element) {
        System.out.println("navloganalyzer.utils.XmlUtils.removeElement()");
        System.out.println("Pattern: " + element.getPattern());
        Pattern p = Pattern.compile(element.getPattern());
        Matcher matcher = p.matcher(content);
        String outcome = matcher.replaceAll("");
        return outcome;
    }
}
