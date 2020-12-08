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
		
		//File objektum létrehozás
		File file = new File("XMLHx35eu.xml");

		//File beolvasás
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
		Element root = doc.getDocumentElement();
		
				//XML normalizálása
		root.normalize();

		//Kiíró fgv meghívása
		printXML(root, "");
	}

	public static void printXML(Node root, String indentation) {
	//kiválasztja a root nodeod
		String nodename = root.getNodeName();

		//Ha a node szöveges, akkor kiírja
		if (!nodename.contains("text")) {
			System.out.println(indentation + nodename + printAttrs(root));
		}

		//Minél mélyebben vagyunk a fában, annál beljebb tesszük a nodeokat a consoleban
		indentation += "\t";

		//Az összes childnode lekérése
		NodeList childNodes = root.getChildNodes();

		//Az összes childnodera megy a ciklus, ha komplex, akkor ismét meghívjuk rá a fgv-t, mert több node lehet még benne, ha pedig nem akkor simán kiírjuk
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

	//Az attribútumok kiírására szolgáló fgv.
	public static String printAttrs(Node child) {
	// A lehetséges attribútumok listája
		String[] attrset = { "VEVO_ID", "KOSAR_ID", "TIPUS_ID", "TERMEK_ID" };
		String attrs = "";
		//Ha a vizsgált node tartalmaz ilyen attribútumot, akkor összefűzi
		for (String attr : attrset) {
			if (child.getAttributes().getNamedItem(attr) != null)
				attrs += " " + child.getAttributes().getNamedItem(attr);
		}

		return attrs;
	}

}