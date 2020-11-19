public class IntegerExample {
	public static void main(String[] args) {
		System.out.format("From %d upto %d%n",
				Integer.MIN_VALUE, Integer.MAX_VALUE);
		// From -2147483648 upto 2147483647
		Integer i1 = new Integer(15);
		Integer i2 = new Integer("-3543");
		System.out.println(i1.compareTo(i2)); // 1
		System.out.println(i1.equals(new Integer(15)));
		// true
		double d = i1.doubleValue();
		System.out.println(Integer.toString(18, 2)); 
		// 10010
	}
}
