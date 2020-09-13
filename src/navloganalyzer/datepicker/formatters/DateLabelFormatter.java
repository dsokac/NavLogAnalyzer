/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navloganalyzer.datepicker.formatters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFormattedTextField;

/**
 *
 * @author DanijelSokac
 */
public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter{

    private String dateTimePattern = "dd.MM.yyyy.";
    private SimpleDateFormat formatter = new SimpleDateFormat(dateTimePattern);
    
    @Override
    public Object stringToValue(String text) throws ParseException {
        return formatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if(value != null) {
            Calendar cal = (Calendar)value;
            return formatter.format(cal.getTime());
        }
        return "";
    }
    
}
