
public class Sum {
	public static double sum(Number[] numbers) {
		double sum = 0;
		for (Number n : numbers)
			sum += n.doubleValue();
		return sum;  
	}
	
	public static void main(String[] args) {
		Double[] a = {2.0, 3.1, 10.2};
		System.out.println(sum(a));
	}
}
