import java.util.InputMismatchException;
import java.util.Scanner;

public class MainForStringArray {
	public static void main(String[] args) {
		StringArray sa = new StringArray(10);
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			try {
				System.out.print("Enter command:");
				int start = scanner.nextInt();
				if (start == -1) return;
				int num = scanner.nextInt();
				String word = scanner.next();
				sa.setRange(start, start + num, word);
			} catch (StringArrayException e) {
				System.out.println("out of range...");
			} catch (InputMismatchException e) {
				System.out.println("bad input...");
				scanner.nextLine();
			} finally {
				System.out.println(sa); 
			}
		}
	}
}
