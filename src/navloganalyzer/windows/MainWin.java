/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navloganalyzer.windows;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import navloganalyzer.AppConstants;
import navloganalyzer.models.Events;
import navloganalyzer.models.FilteredDataItem;
import navloganalyzer.models.StudentAttendanceItem;
import navloganalyzer.tasks.CleanXmlTask;
import navloganalyzer.tasks.FileUploadTask;
import navloganalyzer.tasks.MapXmlToObjectTask;
import navloganalyzer.tasks.RemoveDuplicatesTask;
import navloganalyzer.tasks.RemoveIrrelevantElementsTask;
import navloganalyzer.utils.WindowUtils;

/**
 *
 * @author DanijelSokac
 */
public class MainWin extends javax.swing.JFrame 
        implements  FileUploadTask.Listener, 
                    CleanXmlTask.Listener, 
                    MapXmlToObjectTask.Listener, 
                    RemoveIrrelevantElementsTask.Listener, 
                    RemoveDuplicatesTask.Listener{

    /**
     * Creates new form MainWin
     */
    public MainWin() {
        initComponents();
        initialView();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        mainPanel = new javax.swing.JPanel();
        centerPanel = new javax.swing.JPanel();
        mainWinMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        uploadFilesItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        fileMenu.setText("File");

        uploadFilesItem.setMnemonic('U');
        uploadFilesItem.setText("Upload files");
        uploadFilesItem.setToolTipText("Upload files for the analysis.");
        uploadFilesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadFilesItemActionPerformed(evt);
            }
        });
        fileMenu.add(uploadFilesItem);

        mainWinMenuBar.add(fileMenu);

        setJMenuBar(mainWinMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadFilesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadFilesItemActionPerformed
        File[] chosen = WindowUtils.fetchChosenFiles(this);
        if(chosen != null) {
            FileUploadTask task = new FileUploadTask(chosen, this);
            task.execute();
        }
    }//GEN-LAST:event_uploadFilesItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWin mw = new MainWin();
                mw.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerPanel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar mainWinMenuBar;
    private javax.swing.JMenuItem uploadFilesItem;
    // End of variables declaration//GEN-END:variables
    private ProgressBarPanel progressBarPanel;
    private NoDataPanel noDataPanel;
    private DataTablePanel dataTablePanel;
    private int previousProgress = 0;
    private MainWin object = this;
    private ComponentAdapter componentAdapter = new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            mainPanel.setSize(object.getSize());
            centerPanel.setSize(object.getSize());
            if(dataTablePanel != null)dataTablePanel.setSize(object.getSize());
            Component[] components = mainPanel.getComponents();
            for(int i = 0; i < components.length; i++) {
                //mainPanel.getComponent(i).setSize(object.getSize());
            }
        }
    };
    
    private void initialView() {      
        setExtendedState(MAXIMIZED_BOTH);
        noDataPanel = new NoDataPanel(centerPanel);
        centerPanel.add(noDataPanel);
        //showTable(new ArrayList<>());
        
        
        addComponentListener(componentAdapter);
    }
    
    private void startProgressBar(String taskDescription) {
        previousProgress = 0;
        this.progressBarPanel = new ProgressBarPanel();
        JLabel currentAction = this.progressBarPanel.getCurrentActionLabel();
        currentAction.setText(taskDescription);     
        this.noDataPanel.setVisible(false);
        this.centerPanel.add(this.progressBarPanel, BorderLayout.CENTER);
        this.centerPanel.setSize(this.progressBarPanel.getSize());
        this.centerPanel.validate();
    }
    
    private void updateProgressBar(int progress) {
        if(previousProgress != progress) {
            previousProgress = progress;
            JProgressBar progressBar = this.progressBarPanel.getProgressBar();
            progressBar.setValue(progress);
            this.progressBarPanel.validate();
        }
    }
    
    private void stopProgressBar() {
        this.progressBarPanel.setVisible(false);
        this.centerPanel.validate();
    }
    
    private void handleTaskChain(String taskName, Object data) {
        switch(taskName) {
            case AppConstants.Tasks.UPLOAD_TASK: 
                CleanXmlTask cleanTask = new CleanXmlTask(StandardCharsets.UTF_8, this);
                cleanTask.execute();
                break;
            case AppConstants.Tasks.CLEAN_FILES_TASK:
                MapXmlToObjectTask mapTask = new MapXmlToObjectTask(this);
                mapTask.execute();
                break;
            case AppConstants.Tasks.MAP_TO_JAVA_TASK:
                RemoveIrrelevantElementsTask removeTask = new RemoveIrrelevantElementsTask(this,(List<Events>)data);
                removeTask.execute();
                break;
            case AppConstants.Tasks.REMOVE_ELEMENTS_TASK:
                RemoveDuplicatesTask duplicatesTask = new RemoveDuplicatesTask((List<FilteredDataItem>)data, this);
                duplicatesTask.execute();
                break;
            case AppConstants.Tasks.REMOVE_DUPLICATES_TASK:
                List<StudentAttendanceItem> items = StudentAttendanceItem.convert((List<FilteredDataItem>)data);
                showTable(items);
                break;
        }
    }
    
    public void showTable(List<StudentAttendanceItem> data) {
        dataTablePanel = new DataTablePanel();
        dataTablePanel.populateTable(data);
        this.centerPanel.setVisible(false);
        this.mainPanel.setSize(getSize());
        this.mainPanel.add(dataTablePanel, BorderLayout.CENTER);
        this.dataTablePanel.setSize(this.mainPanel.getSize());
        this.mainPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                mainPanel.setSize(object.getSize());                
            }            
        });
    }

    @Override
    public void onTaskStarted(String taskDescription) {
        System.out.println("navloganalyzer.windows.MainWin.onTaskStarted()");
        this.startProgressBar(taskDescription);
    }
    
    @Override
    public void onTaskProgressChanged(int progress) {
        System.out.println("navloganalyzer.windows.MainWin.onProgressStatusChanged()");
        this.updateProgressBar(progress);
    }
    
     @Override
    public void onProgressStatusChanged(int progress) {
        this.updateProgressBar(progress);
    }

    @Override
    public void onTaskFinished(String taskName) {
        System.out.println("navloganalyzer.windows.MainWin.onTaskFinished()");
        this.stopProgressBar();
        this.handleTaskChain(taskName, null);
    }
    
    @Override
    public void onTaskFinished(String taskName, Object result) {
        System.out.println("navloganalyzer.windows.MainWin.onTaskFinished()");
        this.stopProgressBar();
        this.handleTaskChain(taskName, result);
    }
}
