package navloganalyzer.windows;

import javax.swing.JFrame;
import navloganalyzer.menu_actions.menubars.AppAbstractMenuBar;

public abstract class AppAbstractWindow extends JFrame{
    
    public AppAbstractWindow(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void addMenuBar(AppAbstractMenuBar menuBar) {
        this.setJMenuBar(menuBar);
        menuBar.setFrame(this);
    }
    
    public void showWindow() {
        this.setVisible(true);
    }
    
}
