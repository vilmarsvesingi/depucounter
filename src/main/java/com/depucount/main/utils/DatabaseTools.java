/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depucount.main.utils;

import com.depucount.main.interfaces.MainInterface;
import com.depucount.main.models.BasicWorkEntry;
import java.io.File;
import java.io.IOException;
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
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static com.depucount.main.interfaces.MainInterface.indexOfEntryForEdit;

/**
 *
 * @author vilmars.vesingi
 */
public class DatabaseTools {

    public static List<String> categoriesFromXml = new ArrayList();
    public static String possibleNewCategory;

    public static String getPossibleNewCategory() {
        return possibleNewCategory;
    }

    public static void setPossibleNewCategory(String possibleNewCategory) {
        DatabaseTools.possibleNewCategory = possibleNewCategory;
    }

    public static Boolean fileChecker(String filepath) {

        File tmpDir = new File(filepath);
        return tmpDir.exists();

    }

    public static List<String> CategoriesFromCurrentDB(List<BasicWorkEntry> foundInList) {

        if (!categoriesFromXml.isEmpty()) {
            categoriesFromXml.clear();
        }
        if (foundInList != null) {
            for (int position = 0; position < foundInList.size(); position++) {

                foundInList.get(position).getWorkName();
                if (!categoriesFromXml.contains(
                        foundInList.get(position).getWorkName())) {
                    categoriesFromXml.add(foundInList.get(position).getWorkName());
                }
            }
        }
        return categoriesFromXml;

    }

    public static void DeleteFromCurrentList(int[] deleteListIndexes) {

        ArrayList<BasicWorkEntry> listForChanges = MainInterface.getCurrentListInProgess();
        int deleterCount = 0;

        for (Integer index : deleteListIndexes) {
            listForChanges.remove(index - deleterCount);
            deleterCount++;
        }

        MainInterface.setCurrentListInProgess(listForChanges);

    }

    public static void EditInDBObject(int idOfXMLEntryForEdit, BasicWorkEntry receivedData) {

        ArrayList<BasicWorkEntry> currentListInProgess = MainInterface.getCurrentListInProgess();

        currentListInProgess.set(indexOfEntryForEdit, receivedData);

        MainInterface.setCurrentListInProgess(currentListInProgess);
    }

    public static Boolean IsThisIDUnique(String id, ArrayList<BasicWorkEntry> alreadyIn) {

        if (alreadyIn != null) {
            for (BasicWorkEntry entry : alreadyIn) {
                if (entry.getId().equals(id)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    

}
