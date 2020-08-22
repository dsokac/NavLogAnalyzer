package navloganalyzer.menu_actions.menubars;

import navloganalyzer.menu_actions.menus.FileMenu;

public class MainMenuBar extends AppAbstractMenuBar{
       
    public MainMenuBar() {
        addMenu(new FileMenu());
    }
    
}
