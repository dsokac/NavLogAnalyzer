package navloganalyzer.menu_actions.menu_items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportFromWord extends AppAbstractMenuItem{
    
    public ImportFromWord() {
        setText("..from Word");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Importing from word");
            }
        });
    }
    
}
