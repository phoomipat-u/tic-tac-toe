import java.util.*;
public class PP3Ch7_181128_PunPun {
	private static int numbersCorrect;
	private static int dCorPlace;
	private static int dWroPlace;
	private static int tries= 0;
	private static Scanner console = new Scanner (System.in);
	private static int [] guess = new int [4];
	public static void main (String [] args) {
		int [] answer = new int[4];
		Random rand = new Random();
		for (int i = 0; i < 4; i++) {
			answer[i]=rand.nextInt(10);
		}
		do {
			guess();
			checkNumber(guess,answer);
			tries++;
		} while (dCorPlace < 4);
		System.out.print("The answer is ");
		for (int i = 0; i < 4; i++) {
			System.out.print(answer[i]);
		}
		System.out.print(". You got the answer right in "+tries +" tries.");
	}
	public static void guess() {
		System.out.print("Give me a four-digit number");
		String guess = console.next();
		checkValidGuess(guess);
	}
	public static void checkValidGuess(String number) {
		if (number.length() != 4) {
			System.out.println("Invalid number");
			guess();
		} else {
			int num = Integer.parseInt(number);
			for (int i = 3; i >= 0; i--) {
				guess[i]= num % 10;
				num /= 10;
			}
		}
	}
	public static void checkNumber(int [] guess, int [] answer) {
		numbersCorrect = 0;
		dCorPlace = 0;
		dWroPlace = 0;
		for (int i = 0; i < 4; i++) {
			if (guess[i]==answer[i]) {
				dCorPlace++;
				numbersCorrect++;
				continue;
			} 
			for (int j = 0; j < 4; j++) {
				if (guess[j]== answer[i]) {
					numbersCorrect++;
					dWroPlace++;
					break;
				}
			}
		}
		if (numbersCorrect < 4 || dCorPlace <4) {
			System.out.println("You got "+numbersCorrect +" number(s) right.");
			if (numbersCorrect > 0 && dCorPlace < 4) {
				System.out.println("Of those "+ numbersCorrect +" value(s), "+dCorPlace +" is/are in the correct place.");
				System.out.println("Of those "+ numbersCorrect +" value(s), "+dWroPlace +" is/are in the wrong place.");
			}
			System.out.println();
		}
	}
}