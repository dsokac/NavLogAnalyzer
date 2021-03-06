/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navloganalyzer.windows;

import java.awt.Dimension;

/**
 *
 * @author DanijelSokac
 */
public class ProgressBarPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProgressBarPanel
     */
    public ProgressBarPanel() {
        initComponents();
        setSize(new Dimension(556, 158));
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();
        progressBarWaitLabel = new javax.swing.JLabel();
        currentActionLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        progressBarWaitLabel.setText("Please wait...");
        progressBarWaitLabel.setToolTipText("");

        currentActionLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        currentActionLabel.setText("Default action description.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentActionLabel)
                    .addComponent(progressBarWaitLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(progressBarWaitLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(currentActionLabel)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentActionLabel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel progressBarWaitLabel;
    // End of variables declaration//GEN-END:variables
    
    public javax.swing.JProgressBar getProgressBar() {
        return this.progressBar;
    }
    
    public javax.swing.JLabel getCurrentActionLabel() {
        return this.currentActionLabel;
    }
}
