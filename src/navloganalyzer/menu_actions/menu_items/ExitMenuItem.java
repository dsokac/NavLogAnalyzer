package navloganalyzer.menu_actions.menu_items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

public class ExitMenuItem extends AppAbstractMenuItem{
    
    public ExitMenuItem() {
        setText("Exit");
        setMnemonic(KeyEvent.VK_X);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
}
