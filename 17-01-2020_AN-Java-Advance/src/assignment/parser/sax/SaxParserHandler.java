package assignment.parser.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import assignment.parser.sax.Courses;

public class SaxParserHandler extends DefaultHandler{

	private List<Courses> crseList = null;
	private Courses crse = null;
	private StringBuilder data = null;

	public List<Courses> getcrseList() {
		return crseList;
	}

	boolean bReg = false;
	boolean bSubj = false;
	boolean bCrse = false;
	boolean bSect = false;
	boolean bTitle = false;
	boolean bUnits = false;
	boolean bInstructor = false;
	boolean bDays = false;
	boolean bStart = false;
	boolean bEnd = false;
	boolean bBuilding = false;
	boolean bRoom = false;
	boolean bTime = false;
	boolean bPlace = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("course")) {
			crse = new Courses();
			if (crseList == null)
				crseList = new ArrayList<>();
		} else if (qName.equalsIgnoreCase("reg_num")) {
			bReg = true;
		} else if (qName.equalsIgnoreCase("subj")) {
			bSubj = true;
		} else if (qName.equalsIgnoreCase("crse")) {
			bCrse = true;
		} else if (qName.equalsIgnoreCase("sect")) {
			bSect = true;
		}
		 else if (qName.equalsIgnoreCase("title")) {
				bTitle= true;
		}
		 else if (qName.equalsIgnoreCase("units")) {
				bUnits = true;
		}
		 else if (qName.equalsIgnoreCase("instructor")) {
				bInstructor = true;
			}
		 else if (qName.equalsIgnoreCase("days")) {
				bDays = true;
			}
		 else if (qName.equalsIgnoreCase("start_time")) {
				bStart = true;
			}
		 else if (qName.equalsIgnoreCase("end_time")) {
				bEnd = true;
			}
		 else if (qName.equalsIgnoreCase("building")) {
				bBuilding = true;
			}
		 else if (qName.equalsIgnoreCase("room")) {
				bRoom = true;
			}
		 else if (qName.equalsIgnoreCase("time")) {
				bTime = true;
			}
		 else if (qName.equalsIgnoreCase("room")) {
				bPlace = true;
			}
		// create the data container
		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (bReg) {
			crse.set_reg_no(data.toString());
			bReg = false;
		} else if (bSubj) {
			crse.set_subj(data.toString());
			bSubj = false;
		} else if (bCrse) {
			crse.set_crse(data.toString());
			bCrse = false;
		} else if (bSect) {
			crse.set_sect(data.toString());
			bSect = false;
		}
		 else if (bTitle) {
				crse.set_title(data.toString());
				bTitle = false;
			}
			
		 else if (bUnits) {
				crse.set_units(Float.parseFloat(data.toString()));
				bUnits = false;
			}
			
		 else if (bInstructor) {
				crse.set_instructor(data.toString());
				bInstructor = false;
			}
			
		 else if (bDays) {
				crse.set_days(data.toString());
				bDays = false;
			}
			
		 else if (bStart) {
				crse.set_start_time(data.toString());
				bStart = false;
			}
			
		 else if (bEnd) {
				crse.set_end_time(data.toString());
				bEnd = false;
			}
			
		 else if (bBuilding) {
				crse.set_building(data.toString());
				bBuilding = false;
			}
			
		 else if (bRoom) {
				crse.set_room(data.toString());
				bRoom = false;
			}
			
		 else if (bTime) {
				crse.set_time();
				bTime = false;
			}
			
		 else if (bPlace) {
				crse.set_place();
				bPlace = false;
			}
			
		if (qName.equalsIgnoreCase("course")) {
			crseList.add(crse);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}
}
