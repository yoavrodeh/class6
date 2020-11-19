public class NullThrower {
	public static int countPositive(int[] a) {
		if (a == null)
			throw new NullPointerException(
					"parameter should be non-null");
		int count = 0;
		for (int val : a)
			if (val > 0)
				count++;
		return count;
	}
	
	public static void main(String[] args) {
		countPositive(null);
	}
}
