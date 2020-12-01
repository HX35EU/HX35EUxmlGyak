package hu.domparse.hx35eu;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMReadHx35eu {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		File file = new File("XMLHx35eu.xml");

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
		Element root = doc.getDocumentElement();
		root.normalize();

		printXML(root, "");
	}

	public static void printXML(Node root, String indentation) {
		String nodename = root.getNodeName();

		if (!nodename.contains("text")) {
			System.out.println(indentation + nodename + printAttrs(root));
		}

		indentation += "\t";

		NodeList childNodes = root.getChildNodes();

		for (int i = 0; i < childNodes.getLength(); i++) {
			Node child = childNodes.item(i);
			boolean complexType = child.getTextContent().contains("\n");

			if (complexType) {
				printXML(child, indentation);
			} else {
				System.out
						.println(indentation + child.getNodeName() + printAttrs(child) + ": " + child.getTextContent());
			}
		}
	}

	public static String printAttrs(Node child) {
		String[] attrset = { "VEVO_ID", "KOSAR_ID", "TIPUS_ID", "TERMEK_ID" };
		String attrs = "";
		for (String attr : attrset) {
			if (child.getAttributes().getNamedItem(attr) != null)
				attrs += " " + child.getAttributes().getNamedItem(attr);
		}

		return attrs;
	}

} 
