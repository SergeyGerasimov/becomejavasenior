package ua.dobro;

import javax.xml.parsers.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParser {
    public static void main(String[] args) {
        SAXParser.parse("computerStore.xml");
    }

    public static void parse(String xml) {
        try {
            SAXParserFactory f = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = f.newSAXParser();
            saxParser.parse(xml, new Handler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Handler extends DefaultHandler {
    private boolean computerFlag = false;
    private boolean titleFlag = false;
    private String computerIdName = null;
    private String computerIdValue = null;

    // start parsing XML
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing XML...");
    }

    // looking for the elements
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("computer")) {
            computerIdName = attributes.getQName(0);
            computerIdValue = attributes.getValue(0);
            computerFlag = true;
        }
        if (qName.equalsIgnoreCase("title")) {
            titleFlag = true;
        }
    }

    // reading characters
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (computerFlag) {
            computerFlag = false;
        }
        if (titleFlag) {
            System.out.println(computerIdName + ": " + computerIdValue + " - title: " + new String(ch, start, length));
            titleFlag = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        computerIdName = null;
        computerIdValue = null;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End parsing XML.");
    }

}
