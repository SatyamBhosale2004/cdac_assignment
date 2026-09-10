

public class Date {

	private int day;
	private int month;
	private int year;
	//setter
	public void setDate(int dd, int mm, int yy) {
		//year validation
		if(yy >= 1 && yy <=9999) {
			year = yy;
		} else {
			year = 2026;
		}
		//mpnth validation
		if(mm >=1 && mm <=12) {
			month = mm;
		} else {
			month = 1;
			day =1;
		}
		//day validation
		if(month == 1 || month == 3 || month ==5 || month == 7 || month == 8 || month ==10 || month== 12) {
			if(dd < 1 || dd >31) {
				day = 1;
			} else {
				day = dd;
			}
		}
		else if(month == 4 || month ==6 || month == 9 || month == 11) {
				if(dd < 1 || dd >30) {
					day = 1;
				} else {
					day = dd;
				}
		}
		else {
			if(month == 2 && ((year % 4 ==0 && year % 100 != 0) || (year % 400 == 0))){
				if(dd < 1 || dd > 29) {
					day = 1;
				} else {
					day = dd;
				}	
			}else if(month ==2) {
				if(dd < 1 || dd > 28) {
					day = 1;
				}else {
					day = dd;
				}
			}
//			if(((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) && month == 2)) {
//				if((day >= 1 &&  day <= 29) ) {
//					day = dd;
//				} else {
//					day = 1;
//				}
//			} else {
//				if ( month == 2 && (day >= 1 && day <=28)) {
//					day = dd;
//				}else {
//					day =1;
//				}
//			}
		}
		
	}
	//add days
	public void addDays(int d) {
		 day += d;
		if(month == 1 || month == 3 || month ==5 || month == 7 || month == 8 || month ==10 || month== 12) {
			int daysInMonth = 31;
			while(day > daysInMonth) {
				day = day - daysInMonth;
				month ++;
				if(month > 12) {
					year ++;
					month = 1;
				}
				if(month == 1 || month == 3 || month ==5 || month == 7 || month == 8 || month ==10 || month== 12) {
					daysInMonth = 31;
				}
				if (month == 4 || month ==6 || month == 9 || month == 11) {
					daysInMonth = 30;
				}
				if(month == 2 && ((year % 4 ==0 && year % 100 != 0) || (year % 400 == 0))) {
					daysInMonth = 29;
				}else if(month == 2) {
					daysInMonth = 28;
				}
			}
		} else if (month == 4 || month ==6 || month == 9 || month == 11) {
//			if(day > 30) {
//				day = day - 30;
//				month ++;
//				while(day > 30) {
//					day = day - 30;
//					month ++;
//				}
//			}
			int daysInMonth = 30;
			while(day > daysInMonth) {
				day = day - daysInMonth;
				month ++;
				if(month > 12) {
					year ++;
					month = 1;
				}
				if(month == 1 || month == 3 || month ==5 || month == 7 || month == 8 || month ==10 || month== 12) {
					daysInMonth = 31;
				}
				if (month == 4 || month ==6 || month == 9 || month == 11) {
					daysInMonth = 30;
				}
				if(month == 2 && ((year % 4 ==0 && year % 100 != 0) || (year % 400 == 0))) {
					daysInMonth = 29;
				}else if(month == 2) {
					daysInMonth = 28;
				}
			}
		} else {
			if(month == 2 && ((year % 4 ==0 && year % 100 != 0) || (year % 400 == 0))) {
//				if(day > 29) {
//					day = day - 29;
//					month++;
//					while(day > 29) {
//						day = day - 29;
//						month ++;
//					}
//				}
				int daysInMonth = 29;
				while(day > daysInMonth) {
					day = day - daysInMonth;
					month ++;
					if(month > 12) {
						year ++;
						month = 1;
					}
					if(month == 1 || month == 3 || month ==5 || month == 7 || month == 8 || month ==10 || month== 12) {
						daysInMonth = 31;
					}
					if (month == 4 || month ==6 || month == 9 || month == 11) {
						daysInMonth = 30;
					}
					if(month == 2 && ((year % 4 ==0 && year % 100 != 0) || (year % 400 == 0))) {
						daysInMonth = 29;
					}else if(month == 2) {
						daysInMonth = 28;
					}
				}
				
			} else if (month == 2) {
//				if(day > 28) {
//					day = day - 28;
//					month++;
//					while(day > 28) {
//						day = day - 28;
//						month ++;
//					}
//				}
				int daysInMonth = 28;
				while(day > daysInMonth) {
					day = day - daysInMonth;
					month ++;
					if(month > 12) {
						year ++;
						month = 1;
					}
					if(month == 1 || month == 3 || month ==5 || month == 7 || month == 8 || month ==10 || month== 12) {
						daysInMonth = 31;
					}
					if (month == 4 || month ==6 || month == 9 || month == 11) {
						daysInMonth = 30;
					}
					if(month == 2 && ((year % 4 ==0 && year % 100 != 0) || (year % 400 == 0))) {
						daysInMonth = 29;
					}else if(month == 2) {
						daysInMonth = 28;
					}
				}
			}
			
		}
	}
	//add months
	public void addMonths(int m) {
//		month += m;
//		if(month == 1 || month == 3 || month ==5 || month == 7 || month == 8 || month ==10 || month== 12) {
//			if(day == 30) {
//				day = 31;
//			}
//		}
//		if (month == 4 || month ==6 || month == 9 || month == 11) {
//			if(day == 31) {
//				day = 30;
//			}
//		}
//		if(month == 2 && ((year % 4 ==0 && year % 100 != 0) || (year % 400 == 0))) {
//			if(day > 29)
//				day = 29;
//		}else if(month == 2) {
//			if(day > 28)
//				day = 28;
//		}
//		if(month > 12) {
//			month = month -12;
//			year++;	
//			if(month == 2 && ((year % 4 ==0 && year % 100 != 0) || (year % 400 == 0))) {
//				if(day > 29)
//					day = 29;
//			}else if(month == 2) {
//				if(day > 28)
//					day = 28;
//			}
//		}
		month +=m;
		while(month > 12) {
			month -= 12;
			year++;
		}
		if(month == 1 || month == 3 || month ==5 || month == 7 || month == 8 || month ==10 || month== 12) {
			int daysInMonth = 31;
			if(day > daysInMonth ) {
				day = daysInMonth;
			}
		}
		if (month == 4 || month ==6 || month == 9 || month == 11) {
			int daysInMonth = 30;
			if(day > daysInMonth ) {
				day = daysInMonth;
			}
		}
		if(month == 2 && ((year % 4 ==0 && year % 100 != 0) || (year % 400 == 0))) {
			int daysInMonth = 29;
			if(day > daysInMonth ) {
				day = daysInMonth;
			}
		}else if(month == 2) {
			int daysInMonth = 28;
			if(day > daysInMonth ) {
				day = daysInMonth;
			}
		}
		
	}
	// add years
	public void addYears(int y) {
		year += y;
		if(month == 2 && ((year % 4 ==0 && year % 100 != 0) || (year % 400 == 0))) {
			int daysInMonth = 29;
			if(day > daysInMonth ) {
				day = daysInMonth;
			}
		}else if(month == 2) {
			int daysInMonth = 28;
			if(day > daysInMonth ) {
				day = daysInMonth;
			}
		}	
	}
	//display
	public void display() {
		System.out.println(day + "/" + month + "/" + year);
	}
	//compare
	public void compareDates() {
		System.out.println("Coming Soon");
	}
	//getters
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	
}
