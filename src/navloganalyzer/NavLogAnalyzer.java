package navloganalyzer;

import navloganalyzer.menu_actions.menubars.MainMenuBar;
import navloganalyzer.windows.MainWin;
import navloganalyzer.windows.MainWindow;

public class NavLogAnalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
               
        /*MainWindow mainWindow = new MainWindow();
        mainWindow.addMenuBar(new MainMenuBar());       
        mainWindow.showWindow();
        mainWindow.simulate();*/
        MainWin win = new MainWin();
        win.setVisible(true);
    }
    
}
