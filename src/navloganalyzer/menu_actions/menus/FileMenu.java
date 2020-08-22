package navloganalyzer.menu_actions.menus;

import java.awt.event.KeyEvent;
import navloganalyzer.menu_actions.menu_items.ExitMenuItem;
import navloganalyzer.menu_actions.menu_items.UploadFilesMenuItem;

public class FileMenu extends AppAbstractMenu{
    
    public FileMenu() {
        setText("File");
        setMnemonic(KeyEvent.VK_F);
        
        addMenuItem(new UploadFilesMenuItem());
        addMenuItem(new ImportSubmenu());
        addSeparator();
        addMenuItem(new ExitMenuItem());
    }
    
}
