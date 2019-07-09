/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depucount.main;

import com.depucount.main.interfaces.MainInterface;
import com.depucount.main.models.BasicWorkEntry;
import com.depucount.main.utils.DatabaseTools;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author vilmars.vesingi
 */
public class DatabaseProcessor {

    
    static String filepathDB;

    public static void setFilepathDB(String filepathDB) {
        DatabaseProcessor.filepathDB = filepathDB;
    }

    public static String getFilepathDB() {
        return DatabaseProcessor.filepathDB;
    }
    
    static String fileNameDB;

    public static String getFileNameDB() {
        return fileNameDB;
    }

    public static void setFileNameDB(String fileNameDB) {
        DatabaseProcessor.fileNameDB = fileNameDB;
    }
    
    public static Boolean unsavedChanges;

    public static Boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public static void setUnsavedChanges(Boolean unsavedChanges) {
        DatabaseProcessor.unsavedChanges = unsavedChanges;
       
    }
    
    public static Boolean newDBAdded;

    public static Boolean getNewDBAdded() {
        return newDBAdded;
    }

    public static void setNewDBAdded(Boolean newDBAdded) {
        DatabaseProcessor.newDBAdded = newDBAdded;
    }

    public static Boolean XMLBuilder(ArrayList<BasicWorkEntry> entries) {
        Boolean isNewDataBase = false;
        if (!DatabaseTools.fileChecker(DatabaseProcessor.filepathDB)) {
            isNewDataBase = true;
        }
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element entriesNode = document.createElement("entries");
            document.appendChild(entriesNode);
            for (BasicWorkEntry entry : entries) {
                Element entryNode = document.createElement("entry");
                entriesNode.appendChild(entryNode);
                Element idNode = document.createElement("id");
                idNode.appendChild(document.createTextNode(String.valueOf(entry.getId())));
                entryNode.appendChild(idNode);
                Element workName = document.createElement("workName");
                workName.appendChild(document.createTextNode(entry.getWorkName()));
                entryNode.appendChild(workName);
                Element workDetails = document.createElement("workDetails");
                workDetails.appendChild(document.createTextNode(entry.getWorkDetails()));
                entryNode.appendChild(workDetails);
                Element startTime = document.createElement("startTime");
                startTime.appendChild(document.createTextNode(String.valueOf(entry.getStartTime())));
                entryNode.appendChild(startTime);
                Element endTime = document.createElement("endTime");
                endTime.appendChild(document.createTextNode(String.valueOf(entry.getEndTime())));
                entryNode.appendChild(endTime);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(DatabaseProcessor.filepathDB));
            transformer.transform(domSource, streamResult);
            System.out.println("Done creating XML File at: " + DatabaseProcessor.filepathDB);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException | ParserConfigurationException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isNewDataBase;
    }

    public static ArrayList<BasicWorkEntry> CreateEntryListFromXMLData() {
        if (DatabaseTools.fileChecker(DatabaseProcessor.filepathDB)) {
            try {
                //  File fXmlFile = new File(filepathDB);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document docToRead = dBuilder.parse(DatabaseProcessor.filepathDB);
                docToRead.getDocumentElement().normalize();
                NodeList entryList = docToRead.getElementsByTagName("entry");
                ArrayList<BasicWorkEntry> foundInXml = new ArrayList();
                for (int x = 0; x < entryList.getLength(); x++) {
                    Element currentElement = (Element) entryList.item(x);
                    BasicWorkEntry currentEntry = new BasicWorkEntry(currentElement.getElementsByTagName("id").item(0).getTextContent(), currentElement.getElementsByTagName("workName").item(0).getTextContent(), currentElement.getElementsByTagName("workDetails").item(0).getTextContent(), currentElement.getElementsByTagName("startTime").item(0).getTextContent(), currentElement.getElementsByTagName("endTime").item(0).getTextContent());
                    foundInXml.add(currentEntry);
                }
                return foundInXml;
                // BasicWorkEntry
            } catch (SAXException ex) {
                Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
