 
package hu.iit.uni.miskolc.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            File inputFile = new File("szemelyek.xml");
            if (!inputFile.exists()){
                System.out.println(inputFile.getAbsolutePath());
                return;
            }
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SaxMPJYO8 userhandler = new SaxMPJYO8();
            saxParser.parse(inputFile, userhandler);



            System.out.println(userhandler.getStringBuilder().toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
        }


}
