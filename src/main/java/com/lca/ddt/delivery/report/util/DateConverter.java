package com.lca.ddt.delivery.report.util;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

public class DateConverter {

	public static XMLGregorianCalendar toXMLGregorianCalendar(Date date) {
		try {
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(date);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date toDate(XMLGregorianCalendar xmlGregorianCalendar) {
		if (xmlGregorianCalendar == null) {
			return null;
		}
		return xmlGregorianCalendar.toGregorianCalendar().getTime();
	}

	public static void main(String[] args) {
		Date date = new Date();
		XMLGregorianCalendar xmlGregorianCalendar = toXMLGregorianCalendar(date);
		System.out.println("Converted Date to XMLGregorianCalendar: " + xmlGregorianCalendar);

		Date convertedDate = toDate(xmlGregorianCalendar);
		System.out.println("Converted XMLGregorianCalendar to Date: " + convertedDate);
	}

	public static String getStringDateTime(XMLGregorianCalendar gDate, String pattern) {

		return Optional.ofNullable(gDate).map(gdate -> {
			Calendar calendar = gDate.toGregorianCalendar();
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			formatter.setTimeZone(calendar.getTimeZone());
			return formatter.format(calendar.getTime());
		}).orElse(null);
	}

	public static XMLGregorianCalendar getCurrentDate() {

		try {
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(new Date());
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String getStringDate() {
		   Date date = Calendar.getInstance().getTime();  
           DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
           return dateFormat.format(date);  
	}

}
