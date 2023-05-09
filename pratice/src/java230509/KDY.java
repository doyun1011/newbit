package java230509;

import java.sql.Date;
import java.util.Scanner;

public class KDY {

	private int year;
	private int month;
	private int day;
	private String date = "";
	private String result = "";
	
	public KDY(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		
		checkDate(); 
		
		if(!result.equals("")) {
			String result = this.result;
			this.result = "";
			System.out.println(result);
		}
	}
	
	public String getDate() {

		String month2 = String.format("%02d", month);
		String day2 = String.format("%02d", day);
		date = date + year + month2 + day2;
		return date;
	}

	public String delimiterDate(String delimiter) {
		
		
		String month2 = String.format("%02d", month);
		String day2 = String.format("%02d", day);
		String date = year + delimiter + month2 + delimiter + day2;
		return date;
	}
	private void checkDate() {
		checkYear();
		checkMonth();
		checkDay();
	}
	
	private void checkYear() {
		String year2 = Integer.toString(year);
		if (year2.length() != 4 || year < 0) {
			result = result + "년 범위를 초과하였습니다.\n";
		}
	}
	
	private void checkMonth() {
		if (month < 1 || month > 12) {
			result = result + "월 범위를 초과하였습니다.\n";
		}
	}
	
	private void checkDay() {
		boolean checkDay = true;
		if (month == 2) {
			if (!isFebruaryValid(year, month, day)) {
				checkDay = false;
			}
		}else if (!isCheckedDay(year, month, day)) {
			checkDay = false;
		}
		
		if(!checkDay) {
			result = result + "일 범위를 초과하였습니다.\n";
		}
	}

	private boolean isFebruaryValid(int year, int month, int day) {

		if (year % 4 == 0 && year % 100 == 0) {
			if (year % 400 != 0) {
				if (day < 1 || day > 28) {
					return false;
				}
			} else if (year % 400 == 0) {
				if (day < 1 || day > 29) {
					return false;
				}
			}
		} else if (year % 4 == 0 && year % 100 != 0) {
			if (day < 1 || day > 29) {
				return false;
			}
		}

		if (year % 4 != 0) {
			if (day < 1 || day > 28) {
				return false;
			}
		}
		return true;
	}
	

	private boolean isCheckedDay(int year, int month, int day) {
		
		if (day < 1 || day > 31) {
			return false;
		}
		
		//최대일이 30일인 월 검사  ( 4, 6, 9, 11 )
		for (int i = 4; i < 12; i += 2) {
			if (i == 8) {
				i = 9;
			}
			if (i == month) {
				if (day == 31) {
					return false;
				}
			}
		}
		return true;
	}
}
