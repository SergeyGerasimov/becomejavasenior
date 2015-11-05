package ua.dobro;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParser {
    public static void main(String[] args) throws Exception {
        String[] columns = { "title", "type", "amount" };
        parseUsingDOM(columns, "computerStore.xml");
    }

    public static void parseUsingDOM(String[] columns, String xml) {
        try {
            // create document using DOM
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            DocumentBuilder p = f.newDocumentBuilder();
            Document doc = p.parse(xml);
            doc.getDocumentElement().normalize();
            // create list of computer nodes
            NodeList list = doc.getElementsByTagName("computer");
            // print all columns
            for (String s : columns) {
                System.out.format("%-12s", s);
            }
            System.out.println();
            // iterate through all nodes with computer root
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    // print all text content of the columns
                    for (String s : columns) {
                        System.out.format("%-12s", element.getElementsByTagName(s).item(0).getTextContent());
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
