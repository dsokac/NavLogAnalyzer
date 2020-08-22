package navloganalyzer.menu_actions.menubars;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JMenuBar;
import navloganalyzer.menu_actions.menus.AppAbstractMenu;
import navloganalyzer.windows.AppAbstractWindow;

public abstract class AppAbstractMenuBar extends JMenuBar{
    
    protected AppAbstractWindow frame = null;
    protected Map<String, AppAbstractMenu> menus = new HashMap<>();
    
    public void setFrame(AppAbstractWindow frame) {
        this.frame = frame;
    }
    
    public AppAbstractWindow getFrame() {
        return this.frame;
    }
    
    public void addMenu(AppAbstractMenu menu) {
        this.menus.put(menu.getText(), menu);
        menu.setMenuBar(this);
        this.add(menu);
    }
    
    public AppAbstractMenu getMenu(String label) {
        return this.menus.get(label);
    }
}
