package com.ss.sf.monthDays;



// Demonstrates basic practice using Date & Time

import java.time.YearMonth;
import java.time.LocalDate;
import java.util.ArrayList;

public class MonthDays {
	public static void main(String[] args){
		MonthDays test = new MonthDays();
		System.out.println(test.getNumDays(2021).toString());
		System.out.println(test.getMondays(12).toString());
		System.out.println(test.triskaidekaphobia(LocalDate.now()));
		
	}

	//Get the number of days in each month of a given year
	public ArrayList<String> getNumDays(int year){
		ArrayList<String> numDays = new ArrayList<String>();
		try{
				for(int i = 1; i <= 12; i++){
				YearMonth ym = YearMonth.of(year,  i);
				numDays.add(ym.getMonth().toString()+ ": " +ym.lengthOfMonth());
				}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
		return numDays;
	}
	//List the Mondays of a given month in a year
	public ArrayList<LocalDate> getMondays(int month){
		ArrayList<LocalDate> mondays = new ArrayList<>();
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		try{
			YearMonth ym = YearMonth.of(year, month);
			for(int i = 1; i < ym.lengthOfMonth(); i++){
				LocalDate day = LocalDate.of(year, month, i);
				if(day.getDayOfWeek().getValue() == 1){
					mondays.add(day);
				}
			}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
		return mondays;
		
	}
	//Tests whether date is Friday 13th
	public Boolean triskaidekaphobia(LocalDate date){
		if(date.getDayOfMonth() != 13){
			return false;
		}
		if(date.getDayOfWeek().getValue() != 5){
			return false;
		}
		return true;
	}
}
