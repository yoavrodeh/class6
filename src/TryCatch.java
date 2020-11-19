public class TryCatch {

	private static void g() {
		throw new NullPointerException("X");
	}

	public static void main(String[] args) {
		try {
			g();
			System.out.print("A");
		} catch (NullPointerException e) { 
			System.out.print("B" + e.getMessage());
		} catch (Exception e) { 
			System.out.print("C" + e.getMessage());
		}
		System.out.print("D");
	}
}
