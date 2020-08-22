package navloganalyzer.menu_actions.menu_items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportFromExcel extends AppAbstractMenuItem{
    
    public ImportFromExcel() {
        setText("..from Excel");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Importing from excel");
            }
        });
    }
    
}
