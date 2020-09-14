/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navloganalyzer.windows;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import navloganalyzer.datepicker.DatePickerUtils;
import navloganalyzer.models.StudentAttendanceItem;
import navloganalyzer.utils.MyStringUtils;

/**
 *
 * @author DanijelSokac
 */
public class DataTablePanel extends javax.swing.JPanel {

    /**
     * Creates new form DataTablePanel
     */
    public DataTablePanel() {
        initComponents();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        analysisTable = new javax.swing.JTable();
        tableOptionsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxStudents = new javax.swing.JComboBox<>();
        datePickerPanel = new javax.swing.JPanel();

        analysisTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student", "Vrijeme prijave", "Vrijeme odjave", "Trajanje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(analysisTable);
        analysisTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        tableOptionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Mogućnosti"));
        tableOptionsPanel.setMaximumSize(new java.awt.Dimension(12, 115));
        tableOptionsPanel.setMinimumSize(new java.awt.Dimension(10, 100));

        jLabel1.setText("Student:");
        jLabel1.setToolTipText("");
        jLabel1.setName("lUsername"); // NOI18N

        cbxStudents.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        datePickerPanel.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout tableOptionsPanelLayout = new javax.swing.GroupLayout(tableOptionsPanel);
        tableOptionsPanel.setLayout(tableOptionsPanelLayout);
        tableOptionsPanelLayout.setHorizontalGroup(
            tableOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableOptionsPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(tableOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(datePickerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tableOptionsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(759, Short.MAX_VALUE))
        );
        tableOptionsPanelLayout.setVerticalGroup(
            tableOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tableOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(datePickerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("Student");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableOptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable analysisTable;
    private javax.swing.JComboBox<String> cbxStudents;
    private javax.swing.JPanel datePickerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel tableOptionsPanel;
    // End of variables declaration//GEN-END:variables
    private Component object = this;
    private int width = -1;
    private int height = -1;
    private List<StudentAttendanceItem> originalData = new ArrayList<>();
    private List<StudentAttendanceItem> data = new ArrayList<>();

    public void populateTable(List<StudentAttendanceItem> data) {
        populateTable(data, false);
    }
    
    public void populateTable(List<StudentAttendanceItem> data, boolean isFiltering) {
        if(isFiltering) {
            this.data = data;
        } else {
            this.originalData = data;
        }
        DefaultTableModel tModel = (DefaultTableModel) analysisTable.getModel();
        tModel.setRowCount(0);
        for(StudentAttendanceItem item : data) {
            tModel.addRow(item.getRow());
        }
        validate();
        
        if(!isFiltering) {
            List<String> studentList = extractStudentsForCombobox(data);
            MyStringUtils.sortListItems(studentList);
            setupCombobox(studentList);
            DatePickerUtils.initializeDatePicker(datePickerPanel);
        }
    }
    
    private List<String> extractStudentsForCombobox(List<StudentAttendanceItem> data) {
        List<String> studentList = new ArrayList<>(); 
        for(StudentAttendanceItem item : data) {
            if(!studentList.contains(item.getUsername())) {
                studentList.add(item.getUsername());
            }
        }
        return studentList;
    }
    
    private void setupCombobox(List<String> studentList) {
        cbxStudents.removeAllItems();
        cbxStudents.addItem("Odaberi...");
        for(String item : studentList) {
            cbxStudents.addItem(item);
        }
        
        cbxStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = (String)((JComboBox)e.getSource()).getSelectedItem();
                System.out.println(".actionPerformed() => " + selectedValue);
                filterData(selectedValue);
            }
        });
    }
    
    private void filterData(String key) {
        Predicate<StudentAttendanceItem> predicate = new Predicate<StudentAttendanceItem>() {
            @Override
            public boolean test(StudentAttendanceItem t) {
               return t.getUsername().equals(key);
            }
        };
        this.data = this.originalData.stream().filter(predicate).collect(Collectors.toList());
        populateTable(data, true);
    }
}
