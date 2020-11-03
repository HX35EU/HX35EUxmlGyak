 
package hu.iit.uni.miskolc.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHX35EU extends DefaultHandler {

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    private final StringBuilder stringBuilder;

    public SaxMPJYO8() {
        super();
        stringBuilder = new StringBuilder();
    }



    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        String attrName = attributes.getQName(0);
        String attrValue = attributes.getValue(0);

        stringBuilder
                .append(qName);

        if (attrName != null) {
            stringBuilder
                    .append(attrName)
                    .append(attrValue);
        }
        stringBuilder.append(" start\n");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        stringBuilder.append(qName).append(" end\n");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        stringBuilder.append(new String(ch, start, length)).append("\n");
    }

    // region Error Handling
    @Override
    public void warning(SAXParseException e) throws SAXException {
        super.warning(e);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        super.error(e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        super.fatalError(e);
    }
    // endregion
}
