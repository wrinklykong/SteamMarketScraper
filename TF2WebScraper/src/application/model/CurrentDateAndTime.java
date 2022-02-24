//****************************************
//Class: 	CurrentDateAndTime
//Purpose: 	Used in file naming for .csv file
//			output to include the current date
//			and time.
//
//****************************************

package application.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateAndTime {
	
	// Returns string of current date formatted in File-naming-friendly manner
	public static String getCurrentDateAndTime() {					
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd_hh-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

}
