/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depucount.main.interfaces;

import com.depucount.main.EmailProcessor;
import com.depucount.main.interfaces.EmailMessageForm;
import com.depucount.main.utils.Converters;
import static com.depucount.main.utils.Converters.ConvertAndSortFromMonthIntToAString;
import com.depucount.main.ReportProcessor;
import com.depucount.main.DatabaseProcessor;
import static com.depucount.main.interfaces.MainInterface.currentListInProgess;
import com.depucount.main.models.BasicWorkEntry;
import com.depucount.main.models.ListFilterDetails;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author vilmars.vesingi
 */
public class ReportRequest extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     */
    public static ListFilterDetails detailsForReport;

    public static ListFilterDetails getDetailsForReport() {
        return detailsForReport;
    }

    public static void setDetailsForReport(ListFilterDetails detailsForReport) {
        ReportRequest.detailsForReport = detailsForReport;
    }

    public ReportRequest(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        AddingChoices(currentListInProgess);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooserForOutgoingReport = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        makeReportRequestBtn = new javax.swing.JButton();
        chosenYearForReport = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskListForReport = new javax.swing.JList<>();
        chosenMonthForReport = new javax.swing.JComboBox<>();
        newReportDirectoryFinder = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        titleForReportField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        reportPersonNameField = new javax.swing.JTextField();
        sendEmailCheckbx = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();

        fileChooserForOutgoingReport.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Laika atskaites pieprasījums");

        makeReportRequestBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/xls.png"))); // NOI18N
        makeReportRequestBtn.setText("Sagatavot");
        makeReportRequestBtn.setIconTextGap(10);
        makeReportRequestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeReportRequestBtnActionPerformed(evt);
            }
        });

        chosenYearForReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chosenYearForReportActionPerformed(evt);
            }
        });

        jLabel2.setText("Gads");

        jLabel3.setText("Mēnesis");

        jLabel4.setText("Izvēlies darbus");

        jScrollPane1.setViewportView(taskListForReport);

        chosenMonthForReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chosenMonthForReportActionPerformed(evt);
            }
        });

        newReportDirectoryFinder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        newReportDirectoryFinder.setText("Atvērt...");
        newReportDirectoryFinder.setIconTextGap(10);
        newReportDirectoryFinder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newReportDirectoryFinderActionPerformed(evt);
            }
        });

        jLabel6.setText("Nosaukums");

        jLabel7.setText("Vārds, Uzvārds");

        reportPersonNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportPersonNameFieldActionPerformed(evt);
            }
        });

        sendEmailCheckbx.setText("Nosūtīt e-pastā");
        sendEmailCheckbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendEmailCheckbxActionPerformed(evt);
            }
        });

        jLabel8.setText("Atvērt saglabāšanas vietu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendEmailCheckbx)
                    .addComponent(makeReportRequestBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(titleForReportField))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(reportPersonNameField))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addGap(39, 133, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(chosenYearForReport, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chosenMonthForReport, 0, 78, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(newReportDirectoryFinder, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(reportPersonNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chosenYearForReport)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chosenMonthForReport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(newReportDirectoryFinder)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendEmailCheckbx)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleForReportField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(makeReportRequestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddingChoices(ArrayList<BasicWorkEntry> currentList) {

        chosenYearForReport.removeAllItems();
        chosenMonthForReport.removeAllItems();

        ReportProcessor.setXLSDirectory("");
        ReportProcessor.setXLSTitle("");

        // years 
        ArrayList<Integer> yearsFromEntriesList = new ArrayList();

        for (BasicWorkEntry entry : currentList) {

            if (!yearsFromEntriesList.contains(entry.getStartYear())) {
                yearsFromEntriesList.add(entry.getStartYear());
            }

        }
        Collections.sort(yearsFromEntriesList);

        for (int x : yearsFromEntriesList) {

            chosenYearForReport.addItem(String.valueOf(x));
        }

        // months
        ArrayList<Integer> monthsMidListFromEntriesList = new ArrayList();

        for (BasicWorkEntry entry : currentList) {

            if (!monthsMidListFromEntriesList.contains(entry.getStartMonth())) {
                monthsMidListFromEntriesList.add(entry.getStartMonth());
            } // getting unique month integers, then sort then ascending. then for each add 1 month
        }

        ArrayList<String> monthsFromEntriesList = ConvertAndSortFromMonthIntToAString(monthsMidListFromEntriesList);

        for (String x : monthsFromEntriesList) {

            chosenMonthForReport.addItem(x);

        }
        AddingWorkChoices(currentList);
    }


    private void newReportDirectoryFinderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newReportDirectoryFinderActionPerformed

        int chosen = fileChooserForOutgoingReport.showOpenDialog(null);
        if (chosen == JFileChooser.APPROVE_OPTION) {
            if (fileChooserForOutgoingReport.getSelectedFile().getAbsolutePath() != null) {
                ReportProcessor.setXLSDirectory(fileChooserForOutgoingReport.getSelectedFile().getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(this, "Izvēlies vietu");
            }
        }

    }//GEN-LAST:event_newReportDirectoryFinderActionPerformed

    private void makeReportRequestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeReportRequestBtnActionPerformed

        Boolean thisIsFine = ChosenParamsForReportAreOk();

        if (thisIsFine) {
            ReportProcessor.setXLSTitle(titleForReportField.getText());
            ReportProcessor.setXLSDirectory(fileChooserForOutgoingReport.getSelectedFile().getAbsolutePath());
            ReportProcessor.setReportPersonName(reportPersonNameField.getText());

            ListFilterDetails current = new ListFilterDetails(
                    String.valueOf(chosenYearForReport.getSelectedItem()),
                    String.valueOf(chosenMonthForReport.getSelectedItem()),
                    (ArrayList) taskListForReport.getSelectedValuesList());

            setDetailsForReport(current);

            ArrayList<String> chosenTasks = detailsForReport.getChosenTasks();

            for (String task : chosenTasks) {
                System.out.println("Nosūtītais filtrs" + detailsForReport.chosenMonth + " : " + detailsForReport.chosenYear + " : " + task);
            }

            if (ReportRequest.getDetailsForReport() != null) {
                ListFilterDetails detailsForReport = ReportRequest.getDetailsForReport();

                ReportProcessor.MakeCurrentWorkListFromReportDetails(detailsForReport);

                ReportProcessor.BuildReportXLS();

            }

            JOptionPane.showMessageDialog(this, "Atskaite " + titleForReportField.getText() + " izveidota");
            this.setVisible(false);
            
            if (sendEmailCheckbx.isSelected()){
           
           
           EmailProcessor.setEmailSubject("Atskaite " + titleForReportField.getText());
           
        
           EmailProcessor.setEmailAttachmentDirectory(new String[]{ReportProcessor.getBuiltXLSPath()});
           EmailProcessor.setIfSubjAndAttachRemotelySet(true);
           new EmailMessageForm(null, true).setVisible(true);
           
            }

        }

    }//GEN-LAST:event_makeReportRequestBtnActionPerformed

    public void AddingWorkChoices(ArrayList<BasicWorkEntry> currentList) {

        taskListForReport.removeAll();

        ArrayList<String> worksFromEntriesList = new ArrayList();

        for (BasicWorkEntry entry : currentList) {

            if (String.valueOf(chosenYearForReport.getSelectedItem()).
                    equals(
                            String.valueOf(entry.getStartYear()))
                    && String.valueOf(chosenMonthForReport.getSelectedItem()).
                            equals(
                                    entry.getStartMonthText())) {

                if (!worksFromEntriesList.contains(entry.getWorkName())) {
                    worksFromEntriesList.add(entry.getWorkName());
                }
            }
        }
        Collections.sort(worksFromEntriesList);

        DefaultListModel workList = new DefaultListModel();

        for (String x : worksFromEntriesList) {
            workList.addElement(x);
        }

        taskListForReport.setModel(workList);

    }

    private void reportPersonNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportPersonNameFieldActionPerformed


    }//GEN-LAST:event_reportPersonNameFieldActionPerformed

    private void chosenYearForReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chosenYearForReportActionPerformed

        AddingWorkChoices(currentListInProgess);

    }//GEN-LAST:event_chosenYearForReportActionPerformed

    private void chosenMonthForReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chosenMonthForReportActionPerformed
        AddingWorkChoices(currentListInProgess);
    }//GEN-LAST:event_chosenMonthForReportActionPerformed

    private void sendEmailCheckbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendEmailCheckbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendEmailCheckbxActionPerformed

    public boolean ChosenParamsForReportAreOk() {

        String msg = "Izvēlies";

        if (ReportProcessor.XLSDirectory.length() == 0) {
            msg += " faila saglabāšanas vietu;";
        }
        if (titleForReportField.getText().length() < 3 || titleForReportField.getText() == null) {
            msg += " korektu faila nosaukumu;";
        }
        if (taskListForReport.getSelectedValuesList().size() == 0) {
            msg += " vismaz 1 darbu;";
        }
        if (chosenYearForReport.getSelectedItem() == null) {
            msg += " gadu;";
        }
        if (chosenMonthForReport.getSelectedItem() == null) {
            msg += " mēnesi;";
        }

        if (reportPersonNameField.getText().length() < 5) {
            msg += " korektu personas vārdu;";
        }

        if (msg.length() > 10) {
            JOptionPane.showMessageDialog(this, msg);
            return false;
        }
        return true;
    }

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
            java.util.logging.Logger.getLogger(ReportRequest.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportRequest.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportRequest.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportRequest.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReportRequest dialog = new ReportRequest(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> chosenMonthForReport;
    private javax.swing.JComboBox<String> chosenYearForReport;
    private javax.swing.JFileChooser fileChooserForOutgoingReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton makeReportRequestBtn;
    private javax.swing.JButton newReportDirectoryFinder;
    private javax.swing.JTextField reportPersonNameField;
    private javax.swing.JCheckBox sendEmailCheckbx;
    private javax.swing.JList<String> taskListForReport;
    private javax.swing.JTextField titleForReportField;
    // End of variables declaration//GEN-END:variables
}
