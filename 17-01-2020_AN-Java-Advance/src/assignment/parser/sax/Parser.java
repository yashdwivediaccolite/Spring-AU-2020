package assignment.parser.sax;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import assignment.parser.sax.Courses;
import assignment.parser.sax.SaxParserHandler;

public class Parser {
	public static void main(String[] args) {
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    try {
        SAXParser saxParser = saxParserFactory.newSAXParser();
        SaxParserHandler handler = new SaxParserHandler();
        saxParser.parse(new File("reed.xml"), handler);
        List<Courses> cList = handler.getcrseList();
        for(Courses c : cList)
            System.out.println(c);
    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
    }
}
}
