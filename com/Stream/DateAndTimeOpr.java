package com.Stream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateAndTimeOpr {
	public static void main(String[] args) {

		//81. Write a program to get the current date and time using LocalDateTime.
		LocalDateTime currentDateTime = LocalDateTime.now();

		//87. Write a program to format a date using DateTimeFormatter.
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");

		String FormattedDateTime = currentDateTime.format(formatter);
		System.out.println("Current Date and Time : "+FormattedDateTime );

		//82. Write a program to convert a Date to LocalDate.
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println("Original Date : "+date);
		System.out.println("Comnverted LocalDate : "+localDate);

		//83. Write a program to calculate the difference between two dates in days using ChronoUnit.
		LocalDate startDate = LocalDate.of(2025, 10, 1);
		LocalDate endDate = LocalDate.of(2025, 10, 15);
		long dayBetween = ChronoUnit.DAYS.between(startDate, endDate);
		System.out.println("Days between "+startDate+" and "+endDate+" : "+dayBetween);

		//84. Write a program to add or subtract days from the current date using LocalDate.
		LocalDate currentDate1 = LocalDate.now();
		LocalDate futureDate = currentDate1.plusDays(10);
		LocalDate pastDate = currentDate1.minusDays(5);
		System.out.println("Current Date : "+currentDate1);
		System.out.println("Future Date ofter 10 days : "+futureDate);
		System.out.println("Date before 5 days : "+pastDate);

		//85. Write a program to get the first day of the month using LocalDate.
		LocalDate firstDayOfMonth = currentDate1.withDayOfMonth(1);
		System.out.println("First Day of month : "+firstDayOfMonth);

		//86. Write a program to get the current time in different time zones using ZonedDateTime.
		ZonedDateTime IndiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));	
		ZonedDateTime USTime =ZonedDateTime.now(ZoneId.of("America/New_York"));
		ZonedDateTime londonTime =ZonedDateTime.now(ZoneId.of("Europe/London"));

		System.out.println("India Time: " + IndiaTime.format(formatter));
		System.out.println("New York Time: " + USTime.format(formatter));
		System.out.println("London Time: " + londonTime.format(formatter));

		//88. Write a program to compare two dates using LocalDate.
		LocalDate Date1 = LocalDate.of(2025, 10, 1);
		LocalDate Date2 = LocalDate.of(2025, 10, 15);
		if(Date1.isBefore(Date2)) {
			System.out.println(Date1 + " is before " + Date2);
		}
		else if(Date1.isAfter(Date2)) {
			System.out.println(Date1 + " is After " + Date2);
		}
		else
		{
			System.out.println(Date1 + " is equal to "+Date2);
		}


		//	89. Write a program to convert LocalDate to Date and vice versa.
		// Convert LocalDate to Date
		LocalDate localDate1 = LocalDate.of(2025, 10, 3);
		Date dateFromLocalDate1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
		System.out.println("LocalDate: " + localDate1);
		System.out.println("Converted to Date: " + dateFromLocalDate1);

		// Convert Date to LocalDa
		Date currentDate2 = new Date();
		LocalDate localDateFromDate = currentDate2.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
		System.out.println("Date: " + currentDate2);
		System.out.println("Converted to LocalDate: " + localDateFromDate);


		//90. Write a program to parse a date string into LocalDate using DateTimeFormatter.


		String dateString = "03-10-2025";
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		// Parse the string into LocalDate
		LocalDate parsedDate = LocalDate.parse(dateString, formatter1);

		System.out.println("Parsed LocalDate: " + parsedDate);

	}
}
