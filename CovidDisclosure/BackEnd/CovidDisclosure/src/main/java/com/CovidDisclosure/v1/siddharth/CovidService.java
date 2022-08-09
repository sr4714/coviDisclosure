package com.CovidDisclosure.v1.siddharth;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * 
 * @author siddharth rana
 *
 */
@Service
public class CovidService {
	
	/**
	 * service method for calculating number of days remaining in quarantine for a user since their last positive covid test
	 * @param testDate - last positive covid test date
	 * @return number of days remaining in quarantine
	 */
	public long getDays(int[] testDate) {
		long difference_In_Days=0;
		LocalDate date = LocalDate.of(testDate[2], testDate[0], testDate[1]).plusDays(14);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");			
		ZoneId zoneId = ZoneId.of("America/Chicago");
		LocalDate currentDate=LocalDate.now(zoneId);
		String formattedCurrentDate=currentDate.format(formatter);
		String formattedDate=date.format(formatter);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
		   Date d1 = sdf.parse(formattedDate); 
		   Date d2 = sdf.parse(formattedCurrentDate); 
		   long difference_In_Time = d1.getTime() - d2.getTime(); 
		   difference_In_Days = (difference_In_Time  / (1000 * 60 * 60 * 24)) % 365;
		   
		}
		catch (ParseException e) { 
		       e.printStackTrace(); 
		} 
		return difference_In_Days;

	}
	
	
    

}
