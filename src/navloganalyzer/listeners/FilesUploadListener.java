package navloganalyzer.listeners;

public interface FilesUploadListener {
    void onUploadStarted();
    void onUploadFinished();
    void onProgressStatusChanged(int progress);
}
