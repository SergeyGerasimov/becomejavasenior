package ua.dobro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXParser {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        List<Computer> computersCatalog = new LinkedList<>();
        XMLInputFactory f = XMLInputFactory.newInstance();
        XMLEventReader reader = f.createXMLEventReader("computerStore.xml", new FileInputStream("computerStore.xml"));
        XMLEvent event = null;
        StartElement startElement = null;
        Computer computer = null;
        while (reader.hasNext()) {
            event = reader.nextEvent();
            if (event.isStartElement()) {
                startElement = event.asStartElement();
                if (startElement.getName().getLocalPart().equals("computer")) {
                    computer = new Computer();
                    computer.setComputer(startElement.getName().getLocalPart());
                    computer.setID(Integer.parseInt(startElement.getAttributeByName(new QName("id")).getValue()));
                } else if (startElement.getName().getLocalPart().equals("title")) {
                    event = reader.nextEvent();
                    computer.setTitle(event.asCharacters().getData());
                } else if (startElement.getName().getLocalPart().equals("type")) {
                    event = reader.nextEvent();
                    computer.setType(event.asCharacters().getData());
                } else if (startElement.getName().getLocalPart().equals("amount")) {
                    event = reader.nextEvent();
                    computer.setAmount(Integer.parseInt(event.asCharacters().getData()));
                }
            }
            if (event.isEndElement()) {
                EndElement endElement = event.asEndElement();
                if (endElement.getName().getLocalPart().equals("computer")) {
                    computersCatalog.add(computer);
                }
            }
        }
        computer = null;
        for (Computer comp : computersCatalog) {
            System.out.println(comp);
        }
    }
}

class Computer {
    private String computer = null;
    private int ID = 0;
    private String title = null;
    private String type = null;
    private int amount = 0;

    /**
     * @return the computer
     */
    public String getComputer() {
        return computer;
    }

    /**
     * @return the iD
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param computer
     *            the computer to set
     */
    public void setComputer(String computer) {
        this.computer = computer;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(int iD) {
        ID = iD;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ComputersCatalog [" + computer + ": ID=" + ID + ", title=" + title + ", type=" + type + ", amount="
                + amount + "]";
    }
}
