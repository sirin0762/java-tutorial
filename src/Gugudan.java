import java.util.Arrays;
import java.util.Scanner;

public class Gugudan {
	
	public static int[] calculator(int time) {
		int[] gugudan = new int[9];
		
		for(int i = 0; i < 9; i++) {
			gugudan[i] = time * (i + 1);
		}
		
		return gugudan;
		
	}
}
