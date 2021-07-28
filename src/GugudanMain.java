import java.util.Arrays;
import java.util.Scanner;

public class GugudanMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] gugudan = Gugudan.calculator(n);
		
		System.out.println(Arrays.toString(gugudan));
	}
}
