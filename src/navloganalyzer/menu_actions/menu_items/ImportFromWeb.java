package navloganalyzer.menu_actions.menu_items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportFromWeb extends AppAbstractMenuItem{
    
    public ImportFromWeb() {
        setText("..from Web");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Importing from Web");
            }
        });
    }
    
}
