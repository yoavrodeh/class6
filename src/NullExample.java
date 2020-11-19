public class NullExample {
	
	public static void main(String[] args) {
		System.err.println("begin main");
		f();
		System.err.println("end main");		
	}
	
	public static void f() {
		System.err.println("begin f");
		g();
		System.err.println("end f");
	}	
	public static void g() {
		String x = null;
		System.err.println("begin g");
		x.toString();
		System.err.println("end g");
	}

}
