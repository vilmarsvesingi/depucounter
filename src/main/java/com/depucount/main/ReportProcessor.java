/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depucount.main;

import static com.depucount.main.interfaces.MainInterface.currentListInProgess;
import com.depucount.main.models.BasicWorkEntry;
import com.depucount.main.models.DataForReport;
import com.depucount.main.models.ListFilterDetails;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;

/**
 *
 * @author vilmars.vesingi
 */
public class ReportProcessor {

    public static String XLSTitle;
    public static String XLSDirectory;
    public static String reportPersonName;
    public static ArrayList<BasicWorkEntry> reducedListForReport;

    public static ArrayList<DataForReport> compressedDataForReport;

    public static String builtXLSPath;

    public static String getBuiltXLSPath() {
        return builtXLSPath;
    }

    public static void setBuiltXLSPath(String builtXLSPath) {
        ReportProcessor.builtXLSPath = builtXLSPath;
    }

    public static String getReportPersonName() {
        return reportPersonName;
    }

    public static void setReportPersonName(String reportPersonName) {
        ReportProcessor.reportPersonName = reportPersonName;
    }

    public static ArrayList<DataForReport> getCompressedDataForReport() {
        return compressedDataForReport;
    }

    public static void setCompressedDataForReport(ArrayList<DataForReport> compressedDataForReport) {
        ReportProcessor.compressedDataForReport = compressedDataForReport;
    }

    public static ArrayList<BasicWorkEntry> getReducedListForReport() {
        return reducedListForReport;
    }

    public static void setReducedListForReport(ArrayList<BasicWorkEntry> reducedListForReport) {
        ReportProcessor.reducedListForReport = reducedListForReport;
    }

    public static String getXLSTitle() {
        return XLSTitle;
    }

    public static void setXLSTitle(String XLSTitle) {
        ReportProcessor.XLSTitle = XLSTitle;
    }

    public static String getXLSDirectory() {
        return XLSDirectory;
    }

    public static void setXLSDirectory(String XLSDirectory) {
        ReportProcessor.XLSDirectory = XLSDirectory;
    }

    public static String monthForReporting;

    public static String getMonthForReporting() {
        return monthForReporting;
    }

    public static void setMonthForReporting(String monthForReporting) {
        ReportProcessor.monthForReporting = monthForReporting;
    }

    public static void MakeCurrentWorkListFromReportDetails(ListFilterDetails details) {

        ArrayList<BasicWorkEntry> reducedListForReport = new ArrayList();

        setMonthForReporting(details.getChosenMonth());

        for (BasicWorkEntry entry : currentListInProgess) {
            if (details.getChosenTasks().contains(entry.getWorkName())) {

                if (details.getChosenYear().equals(String.valueOf(entry.getStartYear()))) {

                    if (details.getChosenMonth().equals(entry.getStartMonthText())) {

                        reducedListForReport.add(entry);
                        System.out.println("No saraksta: " + entry.getStartMonth() + " : " + entry.getStartYear() + " : " + entry.getWorkName());

                    }

                }

            }
        }
        setReducedListForReport(reducedListForReport);

    }

    public static void BuildReportXLS() {
        try {
            Workbook reportWorkbook = new XSSFWorkbook();

            org.apache.poi.ss.usermodel.Sheet reportSheet = reportWorkbook.createSheet(
                    reducedListForReport.get(0).getStartMonth()
                    + "."
                    + reducedListForReport.get(0).getStartYear()
            );
            reportSheet.setPrintGridlines(true);
            reportSheet.getPrintSetup().setLandscape(true);
            reportSheet.getPrintSetup().setPaperSize(HSSFPrintSetup.A4_PAPERSIZE);
            reportSheet.setFitToPage(true);

            Row row1 = reportSheet.createRow(0);
            Row row2 = reportSheet.createRow(1);
            Row row3 = reportSheet.createRow(2);
            Row row4 = reportSheet.createRow(3);
            Row row5 = reportSheet.createRow(4);
            Row row6 = reportSheet.createRow(5);
            Row row7 = reportSheet.createRow(6);
            Row row8 = reportSheet.createRow(7);
            Row row9 = reportSheet.createRow(8);
            
            
            XSSFFont simpleTNRfontForAlignLeft = (XSSFFont) reportWorkbook.createFont();
            simpleTNRfontForAlignLeft.setFontHeightInPoints((short) 11);
            simpleTNRfontForAlignLeft.setFontName("Times New Roman");

            XSSFFont simpleTNRfontForAlignRight = (XSSFFont) reportWorkbook.createFont();
            simpleTNRfontForAlignRight.setFontHeightInPoints((short) 11);
            simpleTNRfontForAlignRight.setFontName("Times New Roman");

            XSSFFont simpleTNRfontBoldAlignCenter = (XSSFFont) reportWorkbook.createFont();
            simpleTNRfontBoldAlignCenter.setFontHeightInPoints((short) 9);
            simpleTNRfontBoldAlignCenter.setFontName("Times New Roman");
            simpleTNRfontBoldAlignCenter.setBold(true);

            XSSFFont simpleTNRfontBoldAlignCenterLarge = (XSSFFont) reportWorkbook.createFont();
            simpleTNRfontBoldAlignCenterLarge.setFontHeightInPoints((short) 11);
            simpleTNRfontBoldAlignCenterLarge.setFontName("Times New Roman");
            simpleTNRfontBoldAlignCenterLarge.setBold(true);

            XSSFFont simpleTNRfontBoldAlignLeft = (XSSFFont) reportWorkbook.createFont();
            simpleTNRfontBoldAlignLeft.setFontHeightInPoints((short) 9);
            simpleTNRfontBoldAlignLeft.setFontName("Times New Roman");
            simpleTNRfontBoldAlignLeft.setBold(true);

            XSSFFont simpleTNRfontSmall = (XSSFFont) reportWorkbook.createFont();
            simpleTNRfontSmall.setFontHeightInPoints((short) 9);
            simpleTNRfontSmall.setFontName("Times New Roman");

            XSSFCellStyle simpleTNRstyleSmall = (XSSFCellStyle) reportWorkbook.createCellStyle();
            simpleTNRstyleSmall.setFont(simpleTNRfontSmall);
            simpleTNRstyleSmall.setVerticalAlignment(VerticalAlignment.TOP);
            simpleTNRstyleSmall.setAlignment(HorizontalAlignment.LEFT);
            simpleTNRstyleSmall.setWrapText(true);

            XSSFCellStyle simpleTNRstyleAlignLeft = (XSSFCellStyle) reportWorkbook.createCellStyle();
            simpleTNRstyleAlignLeft.setFont(simpleTNRfontForAlignLeft);
            simpleTNRstyleAlignLeft.setAlignment(HorizontalAlignment.LEFT);

            XSSFCellStyle simpleTNRstyleAlignRight = (XSSFCellStyle) reportWorkbook.createCellStyle();
            simpleTNRstyleAlignRight.setFont(simpleTNRfontForAlignRight);
            simpleTNRstyleAlignRight.setAlignment(HorizontalAlignment.RIGHT);

            XSSFCellStyle simpleTNRstyleBoldCenter = (XSSFCellStyle) reportWorkbook.createCellStyle();
            simpleTNRstyleBoldCenter.setFont(simpleTNRfontBoldAlignCenter);
            simpleTNRstyleBoldCenter.setAlignment(HorizontalAlignment.CENTER);

            XSSFCellStyle simpleTNRstyleBoldCenterLarge = (XSSFCellStyle) reportWorkbook.createCellStyle();
            simpleTNRstyleBoldCenterLarge.setFont(simpleTNRfontBoldAlignCenterLarge);
            simpleTNRstyleBoldCenterLarge.setAlignment(HorizontalAlignment.CENTER);

            XSSFCellStyle simpleTNRstyleBoldLeft = (XSSFCellStyle) reportWorkbook.createCellStyle();
            simpleTNRstyleBoldLeft.setFont(simpleTNRfontBoldAlignLeft);
            simpleTNRstyleBoldLeft.setAlignment(HorizontalAlignment.LEFT);

            XSSFCellStyle simpleTNRstyleBoldCenterFrame = (XSSFCellStyle) reportWorkbook.createCellStyle();
            simpleTNRstyleBoldCenterFrame.setFont(simpleTNRfontBoldAlignCenter);
            simpleTNRstyleBoldCenterFrame.setAlignment(HorizontalAlignment.CENTER);
            simpleTNRstyleBoldCenterFrame.setVerticalAlignment(VerticalAlignment.CENTER);
            simpleTNRstyleBoldCenterFrame.setBorderBottom(BorderStyle.THIN);
            simpleTNRstyleBoldCenterFrame.setBorderTop(BorderStyle.THIN);
            simpleTNRstyleBoldCenterFrame.setBorderRight(BorderStyle.THIN);
            simpleTNRstyleBoldCenterFrame.setBorderLeft(BorderStyle.THIN);
            simpleTNRstyleBoldCenterFrame.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(0, 0, 0)));
            simpleTNRstyleBoldCenterFrame.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(0, 0, 0)));
            simpleTNRstyleBoldCenterFrame.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(0, 0, 0)));
            simpleTNRstyleBoldCenterFrame.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(0, 0, 0)));
            simpleTNRstyleBoldCenterFrame.setWrapText(true);

            XSSFCellStyle simpleTNRstyleBoldLeftFrame = (XSSFCellStyle) reportWorkbook.createCellStyle();
            simpleTNRstyleBoldLeftFrame.setFont(simpleTNRfontBoldAlignLeft);
            simpleTNRstyleBoldLeftFrame.setAlignment(HorizontalAlignment.LEFT);
            simpleTNRstyleBoldLeftFrame.setVerticalAlignment(VerticalAlignment.CENTER);
            simpleTNRstyleBoldLeftFrame.setBorderBottom(BorderStyle.THIN);
            simpleTNRstyleBoldLeftFrame.setBorderTop(BorderStyle.THIN);
            simpleTNRstyleBoldLeftFrame.setBorderRight(BorderStyle.THIN);
            simpleTNRstyleBoldLeftFrame.setBorderLeft(BorderStyle.THIN);
            simpleTNRstyleBoldLeftFrame.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(0, 0, 0)));
            simpleTNRstyleBoldLeftFrame.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(0, 0, 0)));
            simpleTNRstyleBoldLeftFrame.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(0, 0, 0)));
            simpleTNRstyleBoldLeftFrame.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(0, 0, 0)));
            simpleTNRstyleBoldLeftFrame.setWrapText(true);

            XSSFCell cellA1 = (XSSFCell) row1.createCell(0);
            cellA1.setCellValue("Valkas novada dome");
            cellA1.setCellStyle(simpleTNRstyleAlignLeft);

            XSSFCell cellA2 = (XSSFCell) row2.createCell(0);
            cellA2.setCellValue("Reģistrācijas Nr. 90009114839");
            cellA2.setCellStyle(simpleTNRstyleAlignLeft);

            XSSFCell cellAI1 = (XSSFCell) row1.createCell(34);
            cellAI1.setCellValue("APSTIPRINU:");
            cellAI1.setCellStyle(simpleTNRstyleAlignRight);

            XSSFCell cellAI2 = (XSSFCell) row2.createCell(34);
            cellAI2.setCellValue("Valkas novada domes priekšsēdētājs");
            cellAI2.setCellStyle(simpleTNRstyleAlignRight);

            XSSFCell cellAI3 = (XSSFCell) row3.createCell(34);
            cellAI3.setCellValue("________________   V.A.Krauklis");
            cellAI3.setCellStyle(simpleTNRstyleAlignRight);

            XSSFCell cellAI4 = (XSSFCell) row4.createCell(34);
            cellAI4.setCellValue("2019.gada  ____________________");
            cellAI4.setCellStyle(simpleTNRstyleAlignRight);

            XSSFCell cellR5 = (XSSFCell) row5.createCell(17);
            cellR5.setCellValue("DEPUTĀTA DARBA LAIKA UZSKAITES TABELE");
            cellR5.setCellStyle(simpleTNRstyleBoldCenterLarge);

            XSSFCell cellR6 = (XSSFCell) row6.createCell(17);
            cellR6.setCellValue(
                    reportPersonName + " - " + reducedListForReport.get(0).getStartYear()
                    + ". gada " + monthForReporting.toLowerCase());
            cellR6.setCellStyle(simpleTNRstyleBoldCenterLarge);

            XSSFCell cellA8 = (XSSFCell) row8.createCell(0);
            cellA8.setCellValue("Nr.p.k.");
            cellA8.setCellStyle(simpleTNRstyleBoldCenterFrame);

            XSSFCell cellB8 = (XSSFCell) row8.createCell(1);
            cellB8.setCellValue("Veiktie darbi");
            cellB8.setCellStyle(simpleTNRstyleBoldCenterFrame);

            XSSFCell cellC8 = (XSSFCell) row8.createCell(2);
            cellC8.setCellValue(monthForReporting);
            cellC8.setCellStyle(simpleTNRstyleBoldCenterFrame);

            XSSFCell cellAH8 = (XSSFCell) row8.createCell(33);
            cellAH8.setCellValue("Darba stundas");
            cellAH8.setCellStyle(simpleTNRstyleBoldCenterFrame);

            XSSFCell cellAI8 = (XSSFCell) row8.createCell(34);
            cellAI8.setCellValue("Piezīmes");
            cellAI8.setCellStyle(simpleTNRstyleBoldCenterFrame);

            reportSheet.addMergedRegion(new CellRangeAddress(7, 8, 0, 0));
            reportSheet.addMergedRegion(new CellRangeAddress(7, 8, 1, 1));
            reportSheet.addMergedRegion(new CellRangeAddress(7, 7, 2, 32));
            reportSheet.addMergedRegion(new CellRangeAddress(7, 8, 33, 33));
            reportSheet.addMergedRegion(new CellRangeAddress(7, 8, 34, 34));
            int date = 1;
            for (int column = 2; column <= 32; column++) {

                XSSFCell thisCell = (XSSFCell) row9.createCell(column);
                thisCell.setCellValue(date);
                thisCell.setCellStyle(simpleTNRstyleBoldCenterFrame);
                date++;
            }

            int rowForLooping = 9;
            int entryNumberCounter = 1;

            double totalForAll = 0;

            ArrayList<String> workTitles = new ArrayList();
            for (BasicWorkEntry x : reducedListForReport) {

                if (!workTitles.contains(x.getWorkName())) {
                    workTitles.add(x.getWorkName());
                }
            }
            Collections.sort(workTitles);

            for (String uniqueTitle : workTitles) {

                Row currentRow = reportSheet.createRow(rowForLooping);
                XSSFCell entryNumber = (XSSFCell) currentRow.createCell(0);
                entryNumber.setCellValue(entryNumberCounter + ".");
                entryNumber.setCellStyle(simpleTNRstyleBoldLeftFrame);

                XSSFCell entryTitle = (XSSFCell) currentRow.createCell(1);
                entryTitle.setCellValue(uniqueTitle);
                entryTitle.setCellStyle(simpleTNRstyleBoldLeftFrame);
                double totalFromRow = 0;

                for (int column = 2; column <= 33; column++) {
                    XSSFCell formatThisCell = (XSSFCell) currentRow.createCell(column);

                    for (BasicWorkEntry x : reducedListForReport) {

                        if (x.getWorkName().equals(uniqueTitle)
                                && x.getStartDay() == column - 1) {
                            formatThisCell.setCellValue(formatThisCell.getNumericCellValue() + x.getUpperRoundWorkDuration());

                            totalFromRow += x.getUpperRoundWorkDuration();
                        } else {

                        }
                    }
                    formatThisCell.setCellStyle(simpleTNRstyleBoldCenterFrame);

//                XSSFCell entryDuration = (XSSFCell) currentRow.createCell(1);
//                
//                x.getStartDay();
//                ;
                }
                XSSFCell totalCell = (XSSFCell) currentRow.createCell(33);
                totalCell.setCellValue(totalFromRow);
                totalCell.setCellStyle(simpleTNRstyleBoldCenterFrame);

                XSSFCell lastCell = (XSSFCell) currentRow.createCell(34);
                lastCell.setCellStyle(simpleTNRstyleBoldCenterFrame);

                currentRow.setHeight((short) 1000);
                totalForAll += totalFromRow;
                rowForLooping++;
                entryNumberCounter++;
            }

            Row totalSumRow = reportSheet.createRow(rowForLooping);
            XSSFCell cellAE = (XSSFCell) totalSumRow.createCell(30);
            cellAE.setCellValue("KOPĀ");
            cellAE.setCellStyle(simpleTNRstyleBoldCenterFrame);

            XSSFCell cellAH = (XSSFCell) totalSumRow.createCell(33);
            cellAH.setCellValue(totalForAll);
            cellAH.setCellStyle(simpleTNRstyleBoldCenterFrame);

            XSSFCell cellAI = (XSSFCell) totalSumRow.createCell(34);
            cellAI.setCellStyle(simpleTNRstyleBoldCenterFrame);
            reportSheet.addMergedRegion(new CellRangeAddress(rowForLooping, rowForLooping, 30, 32));

            int nextRow = rowForLooping + 1;

            Row legendRow = reportSheet.createRow(nextRow);

            XSSFCell cellC = (XSSFCell) legendRow.createCell(1);
            cellC.setCellValue("Apzīmējumi:");
            cellC.setCellStyle(simpleTNRstyleBoldCenter);

            XSSFCell cellD = (XSSFCell) legendRow.createCell(2);
            cellD.setCellValue("Stundas – darba diena, B - brīvdienas, svinamās dienas, K - komandējumi, "
                    + "AK – likumā atļautie neierašanās gadījumi darbā, SA – darba nespējas lapa A, "
                    + "SB – darba nespējas lapa B, A – atvaļinājumi, BA – bezalgas atvaļinājumi, MA – mācību atvaļinājumi, "
                    + "DZ – dzemdību atvaļinājumi, BK – bērna kopšanas atvaļinājumi");
            cellD.setCellStyle(simpleTNRstyleSmall);
            reportSheet.addMergedRegion(new CellRangeAddress(nextRow, nextRow + 3, 2, 28));

            nextRow = nextRow + 4;

            Row signatureRow = reportSheet.createRow(nextRow);
            XSSFCell cellB = (XSSFCell) signatureRow.createCell(0);
            cellB.setCellValue("Darba laika uzskaites tabeli sastādīja ___________________________________");
            cellB.setCellStyle(simpleTNRstyleBoldLeft);

            nextRow = nextRow + 2;

            Row lastDateRow = reportSheet.createRow(nextRow);
            XSSFCell cellForDate = (XSSFCell) lastDateRow.createCell(0);
            cellForDate.setCellValue("Datums ________________");
            cellForDate.setCellStyle(simpleTNRstyleBoldLeft);

            for (int columnID = 0; columnID <= 34; columnID++) {

                switch (columnID) {
                    case 1:
                        reportSheet.setColumnWidth(columnID, 4000);
                        break;
                    case 33:
                    case 34:
                        reportSheet.setColumnWidth(columnID, 1800);
                        break;
                    default:
                        reportSheet.setColumnWidth(columnID, 900);
                        break;

                }

            }

            FileOutputStream fileOut = new FileOutputStream(
                    getXLSDirectory() + "\\" + getXLSTitle() + ".xlsx"
            );

            setBuiltXLSPath(getXLSDirectory() + "\\" + getXLSTitle() + ".xlsx");

            reportWorkbook.write(fileOut);
            fileOut.close();
        } catch (IOException ex) {

            Logger.getLogger(ReportProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
