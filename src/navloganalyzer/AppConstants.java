package navloganalyzer;

public abstract class AppConstants {
    public interface Folders {
        String RAW_FILES_ENTRY_LOCATION = "Raw Files";
        String CLEANED_FILES_LOCATION = "Cleaned Files";
    }
    
    public interface Tasks {
        String UPLOAD_TASK = "upload";
        String CLEAN_FILES_TASK = "clean files";
        String REMOVE_ELEMENTS_TASK = "remove irrelevent elements";
        String MAP_TO_JAVA_TASK = "map xml to java";
        String REMOVE_DUPLICATES_TASK = "remove duplicates task";
    }
}
