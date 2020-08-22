/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navloganalyzer.models.raw_models;

/**
 *
 * @author DanijelSokac
 */
public class RawDataElementWithSingleNameAttributeSpecs extends RawElementSimpleSpecs{
    
    protected String attributeName;
    protected String attributeValue;
    
    public RawDataElementWithSingleNameAttributeSpecs(String attributeValue) {
        super("Data", false);
        this.attributeName = "Name";
        this.attributeValue = attributeValue;
    }

    @Override
    public String getPattern() {
        String pattern = String.format(selfContained ? "<%s.*%s=\"%s\".*\\/>" : "<%s.*%s=\"%s\".*>", key, attributeName, attributeValue);
        return pattern;
    }
    
    
    
}
