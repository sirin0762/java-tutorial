import java.util.Scanner;

public class Calander {

	public static final int[] MAX_DAY = { 31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30 };
	public static final int[] LEAP_MAX_DAY = { 31, 29, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30 };
	public static final String[] DAY = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};
	
	public static boolean isLeapYear(int year) {
		boolean result = false;
		if(year % 4 == 0) {
			result = true;
		}
		
		if(year % 100 == 0) {
			result = false;
		}
		
		if(year % 400 == 0) {
			result = true;
		}
		
		return result;
	}

	public static int getMaxDay(int month) {
		return MAX_DAY[month - 1];
	}
	
	public static int getBlank(String day) {
		int result = 0;
		
		for(int i = 0; i < 7; i++) {
			if(DAY[i].equals(day)) {
				result = i + 1;
			}
		}
		
		return result;
	}
	
	public static void printMonth(int year, int month, String day) {
		int[] max_day;
		int blank = getBlank(day);
		System.out.printf("         <<%d년 %d월>>         \n", year, month);
		System.out.println("  MO  TU  WE  TH  FR  SA  SU  ");
		System.out.println("------------------------------");
		
		if(isLeapYear(year)) {
			max_day = LEAP_MAX_DAY;
		}
		else {
			max_day = MAX_DAY;
		}
		
		for(int i = 0; i < blank; i++) {
			System.out.print("    ");
		}
		
		for(int i = 1; i <= max_day[month - 1] + blank; i++) {	
			System.out.printf("%4d", i);
			if((i + blank) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("YEAR> ");
			int year = sc.nextInt();
			
			System.out.print("MONTH> ");
			int month = sc.nextInt();
			
			System.out.println("요일을 입력해주세요(MO, TU, WE, TH, FR, SA, SU)");
			System.out.print("DAY> ");
			String day = sc.next();

			if (month == -1) {
				System.out.println("Bye~");
				break;
			}
			
			printMonth(year, month, day);
		}
	}

}
