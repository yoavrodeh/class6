public class Catcher {
	public static void main(String[] args) {
		int a[] = new int[10];
		try {
			for (int i = 0; i <= 10; i++)
				a[i] = i;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Caught it!");
			System.out.println("The message is: " + 
					e.getMessage());			
		}
		System.out.println("And so life goes on.");
	}
}
