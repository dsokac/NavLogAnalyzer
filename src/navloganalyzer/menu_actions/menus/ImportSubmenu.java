package navloganalyzer.menu_actions.menus;

import java.awt.event.KeyEvent;
import navloganalyzer.menu_actions.menu_items.ImportFromExcel;
import navloganalyzer.menu_actions.menu_items.ImportFromWeb;
import navloganalyzer.menu_actions.menu_items.ImportFromWord;

public class ImportSubmenu extends AppAbstractMenu{
 
    public ImportSubmenu() {
        setText("Import...");
        setMnemonic(KeyEvent.VK_I);
        
        addMenuItem(new ImportFromExcel());
        addMenuItem(new ImportFromWeb());
        addMenuItem(new ImportFromWord());
    }
    
}
