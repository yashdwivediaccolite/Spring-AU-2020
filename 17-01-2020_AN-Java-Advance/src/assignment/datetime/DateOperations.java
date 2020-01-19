package assignment.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.Scanner;

public class DateOperations {
	public static void main(String []args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter your Date of birth");
		String d1=in.nextLine();
		System.out.println("Enter your Sibling Date of birth");
		String d2=in.nextLine();
		LocalDate ldate1=LocalDate.parse(d1);
		LocalDate ldate2=LocalDate.parse(d2);
		LocalDateTime date1=ldate1.atStartOfDay();
		LocalDateTime date2=ldate2.atStartOfDay();
		long diffInNano = ChronoUnit.NANOS.between(date1, date2);
		System.out.println("Difference between the dates in nanoseconds is :"+Math.abs(diffInNano));

		ZoneId newYokZoneId = ZoneId.of("America/New_York");
		
		ZonedDateTime myDate = date1.atZone(newYokZoneId);
		ZonedDateTime siblingDate = date2.atZone(newYokZoneId);
		
		long noOfDaysBetween = ChronoUnit.DAYS.between(myDate, siblingDate);
		System.out.println("Difference between the dates in days is :"+Math.abs(noOfDaysBetween));
        
	}
}
