package navloganalyzer.menu_actions.menu_items;

import javax.swing.JMenuItem;
import navloganalyzer.menu_actions.AppMenuItem;
import navloganalyzer.menu_actions.menus.AppAbstractMenu;

public abstract class AppAbstractMenuItem extends JMenuItem implements AppMenuItem{
    
    protected AppAbstractMenu menu = null;
    
    @Override
    public void setMenu(AppAbstractMenu menu) {
        this.menu = menu;
    }
    
    @Override
    public AppAbstractMenu getMenu() {
        return this.menu;
    }    
}
