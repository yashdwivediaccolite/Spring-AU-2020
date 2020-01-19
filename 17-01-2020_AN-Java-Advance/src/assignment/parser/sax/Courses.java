package assignment.parser.sax;
import java.util.*;

public class Courses {
	private String reg_no;
	private String subj;
	private String crse;
	private String sect;
	private String title;
	private float units;
	private String instructor;
	private String days;
	private HashMap<String,String> time=new HashMap<>();
	private HashMap<String,String> place=new HashMap<>();
	private String start_time;
	private String end_time;
	private String building;
	private String room;
	
	public String get_reg_no() {
		return this.reg_no;
	}
	
	public void set_reg_no(String val) {
		this.reg_no=val;
	}
	
	public String get_subj() {
		return this.subj;
	}
	
	public void set_subj(String val) {
		this.subj=val;
	}
	
	public String get_crse() {
		return this.crse;
	}
	
	public void set_crse(String val) {
		this.crse=val;
	}
	
	public String get_sect() {
		return this.sect;
	}
	
	public void set_sect(String val) {
		this.sect=val;
	}
	
	public String get_title() {
		return this.title;
	}
	
	public void set_title(String val) {
		this.title=val;
	}
	
	public float get_units() {
		return this.units;
	}
	
	public void set_units(float val) {
		this.units=val;
	}
	
	public String get_instructor() {
		return this.instructor;
	}
	
	public void set_instructor(String val) {
		this.instructor=val;
	}
	
	public String get_days() {
		return this.days;
	}
	
	public void set_days(String val) {
		this.days=val;
	}
	
	public String get_start_time() {
		return this.start_time;
	}
	
	public void set_start_time(String val) {
		this.start_time=val;
	}
	public String get_end_time() {
		return this.end_time;
	}
	
	public void set_end_time(String val) {
		this.end_time=val;
	}
	
	public String get_building() {
		return this.building;
	}
	
	public void set_building(String val) {
		this.building=val;
	}
	
	public String get_room() {
		return this.room;
	}
	
	public void set_room(String val) {
		this.room=val;
	}
	
	public HashMap<String,String> get_time() {
		return this.time;
	}
	
	public void set_time() {
		this.time.put("start_time",this.start_time);
		this.time.put("end_time",this.end_time);
	}
	public HashMap<String,String> get_place() {
		return this.place;
	}
	
	public void set_place() {
		this.place.put("building",this.building);
		this.place.put("room",this.room);
	}
	
	
	@Override
	public String toString() {
		return "Reg_no=" + this.reg_no + " Subject=" + this.subj + " Course Number=" + this.crse + " Section=" + this.sect
				+ " Title=" + this.title+ " Units=" + this.units+ " Instructor=" + this.instructor+ " Start Time=" + this.start_time+ " End Time=" + this.end_time+ " Building=" + this.building+ " Room=" + this.room;
	}
	
}
