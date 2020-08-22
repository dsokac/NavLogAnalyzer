package navloganalyzer.models.raw_models;

public class RawElementSimpleSpecs {
    protected String key;
    protected boolean selfContained;
    
    public RawElementSimpleSpecs(String key, boolean selfContained) {
        this.key = key;
        this.selfContained = selfContained;
    }

    public String getKey() {
        return key;
    }

    public boolean isSelfContained() {
        return selfContained;
    }
    
    public String getPattern() {
        String pattern = String.format(selfContained ? "<%s.*\\/>" : "<%s.*>", key);
        return pattern;
    }
}
