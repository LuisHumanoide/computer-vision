/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author HumanoideFilms
 */
public class Reader {
    
     public static void readXML() {
        File xmlFile = new File("properties.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement();
            
            NodeList properties = doc.getElementsByTagName("properties");

            Node property = properties.item(0);
            if (property.getNodeType() == Node.ELEMENT_NODE) {
                Element propertyElement = (Element) property;
                
                int width = Integer.parseInt(propertyElement.getElementsByTagName("width").item(0).getTextContent());
                int height = Integer.parseInt(propertyElement.getElementsByTagName("height").item(0).getTextContent());
                int locationx = Integer.parseInt(propertyElement.getElementsByTagName("locationx").item(0).getTextContent());
                int locationy = Integer.parseInt(propertyElement.getElementsByTagName("locationy").item(0).getTextContent());
                int blur = Integer.parseInt(propertyElement.getElementsByTagName("blur").item(0).getTextContent());
                int thresh = Integer.parseInt(propertyElement.getElementsByTagName("thresh").item(0).getTextContent());
                int autoErase = Integer.parseInt(propertyElement.getElementsByTagName("autoErase").item(0).getTextContent());
                int tErase = Integer.parseInt(propertyElement.getElementsByTagName("tErase").item(0).getTextContent());
                int refreshTime = Integer.parseInt(propertyElement.getElementsByTagName("refreshTime").item(0).getTextContent());
                int camera=Integer.parseInt(propertyElement.getElementsByTagName("camera").item(0).getTextContent());
                double decay=Double.parseDouble(propertyElement.getElementsByTagName("decay").item(0).getTextContent());
                
                Properties.setWidth(width);
                Properties.setHeight(height);
                Properties.setLocationX(locationx);
                Properties.setLocationY(locationy);
                Properties.setBlur(blur);
                Properties.setThresh(thresh);
                Properties.setAutoErase(autoErase);
                Properties.settErase(tErase);
                Properties.setRefreshTime(refreshTime);
                Properties.setRefreshTime(camera);
                Properties.setDecay(decay);
                
            }
        } catch (Exception ex) {
        }
    }
    
}
