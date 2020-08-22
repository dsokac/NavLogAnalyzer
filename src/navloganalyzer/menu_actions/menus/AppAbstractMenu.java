package navloganalyzer.menu_actions.menus;

import javax.swing.JMenu;
import navloganalyzer.menu_actions.AppMenuItem;
import navloganalyzer.menu_actions.menu_items.AppAbstractMenuItem;
import navloganalyzer.menu_actions.menubars.AppAbstractMenuBar;

public abstract class AppAbstractMenu extends JMenu implements AppMenuItem{
    
    protected AppAbstractMenuBar menuBar = null;
    protected AppAbstractMenu menu = null;
    
    public void setMenuBar(AppAbstractMenuBar menuBar) {
        this.menuBar = menuBar;
    }
    
    public AppAbstractMenuBar getMenuBar() {
        return this.menuBar;
    }
    
    public void addMenuItem(AppMenuItem item) {
        if(item instanceof AppAbstractMenu) {
            this.add((AppAbstractMenu)item);
        } else if(item instanceof AppAbstractMenuItem) {
            this.add((AppAbstractMenuItem)item);
        }
        item.setMenu(this); 
    }

    @Override
    public void setMenu(AppAbstractMenu menu) {
        this.menu = menu;
    }

    @Override
    public AppAbstractMenu getMenu() {
        return  this.menu;
    }    
}
