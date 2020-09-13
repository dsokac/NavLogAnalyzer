package navloganalyzer.datepicker;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.JPanel;
import navloganalyzer.datepicker.formatters.DateLabelFormatter;
import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePanel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public abstract class DatePickerUtils {
    public static void initializeDatePicker(JPanel container) {
        DateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.setProperty("text.today", "Danas");
        p.setProperty("text.month", "Mjesec");
        p.setProperty("text.year", "Godina");
        p.setProperty("text.clear", "Očisti");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePanel.setSize(500,100);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePanel.setVisible(true);
        datePicker.setVisible(true);
        container.add(datePicker);
        container.validate();
    }
}
