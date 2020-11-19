public class Thrower {
	public static void main(String[] args) {
		try {
			f();
		} catch (Exception e) {
			System.out.println("caught!");
		}
	}
	
	public static void f() {
		try {
			g();
			System.out.print("f1");
		} catch (ExceptionA e) { System.out.print("f2");
		} catch (ExceptionB e) { System.out.print("f3");
		} catch (Exception e) { System.out.print("f4");
		} finally {	
			System.out.print("fF");
		}
		System.out.print("fEnd");
	}

	public static void g() throws Exception {
		try {
			System.out.print("g1");
			throw new ExceptionA();
		} catch (ExceptionA e) {
			System.out.print("g2");
			throw new ExceptionB();
		} finally {
			System.out.print("gF");
		}
		// System.out.print("gEnd");
	}
}
