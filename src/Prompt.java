
import java.util.Scanner;

public class Prompt {
	
	/**
	 * 
	 * @param week ���ϸ�
	 * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
	 */
	public int parseDay(String week) {
		if (week.equals("su")) return 0;
		else if(week.equals("mo")) return 1;
		else if(week.equals("tu")) return 2;
		else if(week.equals("we")) return 3;
		else if(week.equals("th")) return 4;
		else if(week.equals("fr")) return 5;
		else if(week.equals("sa")) return 6;
		else
			return 0;		
	}

	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();
		boolean breaker = false;
		
		while (true) {
			printMenu();
			String order = sc.next();	
			
			switch(order) {
				case "1":		
					String date = cal.createSchezule(sc);
					cal.putSchezule(date, sc);
					break;		
				case "2":
					cal.getSchezules(sc);
					break;
				case "3":
					cal.showCalendar(sc);
					break;
				case "h":
					printMenu();
					break;
				case "q":
					breaker = true;
					break;
					
			}
			
			if(breaker) {
				break;
			}
		}
//
//		System.out.println("Bye~");
//		sc.close();
	}

	private void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("+==================+");
		System.out.println("| 1. ���� ���");
		System.out.println("| 2. ���� �˻�");
		System.out.println("| 3. �޷� ����");
		System.out.println("| h. ����, q : ����");
		System.out.println("+==================+");
		System.out.println("��� (1, 2, 3, h, q)");
	}

	public static void main(String[] args) {
		// �� ����
		Prompt p = new Prompt();
		p.runPrompt();
	}
}