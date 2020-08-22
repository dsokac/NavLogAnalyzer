package navloganalyzer.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import navloganalyzer.listeners.FilesUploadListener;

public class MainWindow extends AppAbstractWindow implements FilesUploadListener{
    
    private JPanel panel;
    private JProgressBar progressBar;
    
    public MainWindow() {
        super("Moj prozor", 1000, 1000);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(500, 100));
        panel.setBackground(Color.red);
        this.add(panel); 
        onUploadStarted();
    }

    @Override
    public void onUploadStarted() {
        System.out.println("navloganalyzer.windows.MainWindow.onUploadStarted()");
        this.progressBar = new JProgressBar(0, 100);
         
        GridLayout lay = new GridLayout(2, 1);
        lay.setHgap(20);
       // panel.setLayout(lay);
        panel.add(new JLabel("Please wait......."));
        panel.add(this.progressBar);
       
        panel.setVisible(true);
        this.validate();
        this.repaint();
    }
    
    @Override
    public void onUploadFinished() {
        panel.setVisible(false);
        panel.remove(this.progressBar);
        this.validate();
        this.repaint();        
        System.out.println("navloganalyzer.windows.MainWindow.onUploadFinished()");
    }

    @Override
    public void onProgressStatusChanged(int progress) {
       this.progressBar.setValue(progress);
    }
    
    public void simulate() {
         for(int i = 0; i <= 100; i++) {
            progressBar.setValue(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
}
