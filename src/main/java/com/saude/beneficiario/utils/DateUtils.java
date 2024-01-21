package com.saude.beneficiario.utils;

import java.time.DateTimeException;
import java.time.LocalDate;

public class DateUtils {

	public static boolean isDateValid(int year, int month, int day) {
	    try {
	        LocalDate.of(year, month, day);
	    } catch (DateTimeException e) {
	        return false;
	    }
	    return true;
	}
	
}
