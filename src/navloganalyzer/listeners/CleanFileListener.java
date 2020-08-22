package navloganalyzer.listeners;

public interface CleanFileListener {
    void onCleanStarted();
    void onCleanFinished();
    void onProgressStatusChanged(int progress);
}
