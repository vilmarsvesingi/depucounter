/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depucount.main.utils;

import com.depucount.main.interfaces.Overviews;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

/**
 *
 * @author vilmars.vesingi
 */
public class OverviewTools {

    public static String overviewDocLocation;
    public static String overviewDocFullPathName;

    public static TableModel overviewTableModel;
    public static Integer overviewTableColumnCount;
    public static Integer overviewTableRowCount;

    public static TableModel getOverviewTableModel() {
        return overviewTableModel;
    }

    public static void setOverviewTableModel(TableModel overviewTableModel) {
        OverviewTools.overviewTableModel = overviewTableModel;
    }

    public static Integer getOverviewTableColumnCount() {
        return overviewTableColumnCount;
    }

    public static void setOverviewTableColumnCount(Integer overviewTableColumnCount) {
        OverviewTools.overviewTableColumnCount = overviewTableColumnCount;
    }

    public static Integer getOverviewTableRowCount() {
        return overviewTableRowCount;
    }

    public static void setOverviewTableRowCount(Integer overviewTableRowCount) {
        OverviewTools.overviewTableRowCount = overviewTableRowCount;
    }

    public static String getOverviewDocLocation() {
        return overviewDocLocation;
    }

    public static void setOverviewDocLocation(String overviewDocLocation) {
        OverviewTools.overviewDocLocation = overviewDocLocation;
    }

    public static String getOverviewDocFullPathName() {
        return overviewDocFullPathName;
    }

    public static void setOverviewDocFullPathName(String overviewDocFullPathName) {
        OverviewTools.overviewDocFullPathName = overviewDocFullPathName;
    }

    public static void CreateOverviewDoc() {

        FileOutputStream out = null;
        try {

            XWPFDocument document = new XWPFDocument();
            out = new FileOutputStream(new File(getOverviewDocFullPathName()));

            XWPFTable tabelForDoc = document.createTable(getOverviewTableRowCount() + 1, getOverviewTableColumnCount());

            Integer overviewTableRowCount1 = getOverviewTableRowCount();
            Integer overviewTableColumnCount1 = getOverviewTableColumnCount();
            TableModel overviewTableModel1 = getOverviewTableModel();
            
           

            for (int column = 0; column < getOverviewTableColumnCount(); column++) {

                XWPFRun run = tabelForDoc.getRow(0).getCell(column).addParagraph().createRun();
                run.setBold(true);
                run.setText(getOverviewTableModel().getColumnName(column));

            }

            for (int row = 1; row < getOverviewTableRowCount() + 1; row++) {

                for (int column = 0; column < getOverviewTableColumnCount(); column++) {

                    XWPFRun run = tabelForDoc.getRow(row).getCell(column).addParagraph().createRun();
                    run.setText(getOverviewTableModel().getValueAt(row - 1, column).toString());

                }

            }

            document.write(out);
            out.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OverviewTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OverviewTools.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(OverviewTools.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void SetTableSettingsForDocs(JTable overviewTable) {

        setOverviewTableModel(overviewTable.getModel());
        setOverviewTableRowCount(overviewTable.getModel().getRowCount());
        setOverviewTableColumnCount(overviewTable.getModel().getColumnCount());

    }

}
