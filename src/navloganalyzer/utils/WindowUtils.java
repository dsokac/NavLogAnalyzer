/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navloganalyzer.utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.MenuBar;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author DanijelSokac
 */
public abstract class WindowUtils {
    
    public static JFrame createWindow(String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
    
    public static File[] fetchChosenFiles(JFrame frame) {
        File[] outcome = null;
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setMultiSelectionEnabled(true);
        int result = jFileChooser.showOpenDialog(frame);
        if(result == JFileChooser.APPROVE_OPTION) {
            outcome = jFileChooser.getSelectedFiles();
        }
        return outcome;
    }
    
    public static JMenuBar addMenuBarToFrame(JFrame frame){
        JMenuBar menuBar = new JMenuBar();
        return menuBar;
    }
    
    public static JMenu addMenuToMenuBar(JMenuBar menuBar, String label) {
        JMenu menu = new JMenu(label);
        menuBar.add(menu);
        return menu;
    }
    
    public static void addMenuItemToMenu(JMenu menu, String label, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(label);
        menuItem.addActionListener(actionListener);
        menu.add(menuItem);
    }
}
