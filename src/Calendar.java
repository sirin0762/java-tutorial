import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Calendar {

	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public HashMap<String, ArrayList<String>> schezule = new HashMap<String, ArrayList<String>>();

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}
	
	public void getSchezules(Scanner sc) {
		System.out.println("검색할 날짜를 입력해주세요.");
		String date = sc.next();
		
		ArrayList<String> schezules = schezule.get(date);
		
		System.out.printf("%d개의 일정이 있습니다.\n", schezules.size());
		for(int i = 0; i < schezules.size(); i++) {
			System.out.println((i + 1) + ". " + schezules.get(i));
		}
	}
	
	public void putSchezule(String date, Scanner sc) {
		System.out.println("일정을 입력하세요(\"1\" : 종료).");
		while(true) {
			String _schezule = sc.next();
			
			if(_schezule.equals("1")) {
				break;
			}
			
			this.schezule.get(date).add(_schezule);
		}	
	}
	
	public String createSchezule(Scanner sc) {
		System.out.println("[일정 등록] 날짜를 입력하세요.");
		String date = sc.next();
		this.schezule.put(date, new ArrayList<String>());
		
		return date;
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else  {
			return MAX_DAYS[month];
		}
	}
	
	public void showCalendar(Scanner sc) {
		System.out.print("Year>");
		int years = sc.nextInt();
		System.out.print("Month>");
		int month = sc.nextInt();
		printCalendar(years, month);
	}

	public void printCalendar(int years, int month) {
		System.out.printf("    <<%d년 %d월>>\n", years, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		//get weekday automatically
		int weekday = getWeekDay(years, month, 1); 
		
		//print blank space 
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		
		int maxDay = getMaxDaysOfMonth(years, month);
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;
		/*
		int delim;
		if (count < 7) {
			delim = count;
		} else {
			delim = 0;
		}*/
		
		//print first line
		for(int i = 1; i <= count; i++) {
			System.out.printf("%3d",i);
		}
		System.out.println();

		//print from second line to last
		
		count++;
		for(int i = count; i <= maxDay; i++) {
			System.out.printf("%3d",i);
			if (i % 7 == delim) 
				System.out.println();
		}
		
		System.out.println();
		System.out.println();
	}

	private int getWeekDay(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 3; //1970/Jan/1st = Thursday
		
		int count = 0;
		
		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		
		//System.out.println(count);
		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		
		count += day;
		
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;
	}
	
	//simple test code here
	public static void main(String[] args) {
		Calendar cal = new Calendar();
		System.out.println(cal.getWeekDay(1970, 1, 1) == 3);
		System.out.println(cal.getWeekDay(1971, 1, 1) == 4);
		System.out.println(cal.getWeekDay(1972, 1, 1) == 5);
		System.out.println(cal.getWeekDay(1973, 1, 1) == 0);
		System.out.println(cal.getWeekDay(1974, 1, 1) == 1);

	}
}
