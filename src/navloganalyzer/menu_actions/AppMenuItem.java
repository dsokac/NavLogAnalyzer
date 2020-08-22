package navloganalyzer.menu_actions;

import navloganalyzer.menu_actions.menus.AppAbstractMenu;

public interface AppMenuItem {
    void setMenu(AppAbstractMenu menu);
    AppAbstractMenu getMenu();
}
