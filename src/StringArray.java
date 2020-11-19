import java.util.Arrays;

public class StringArray {
	private String[] a;
	public StringArray(int size) {
		a = new String[size];
	}
	public void set(int i, String s)
			throws StringArrayException {
		try {
			a[i] = s;
		} catch (IndexOutOfBoundsException e) {
			throw new StringArrayException();
		}
	}

	public void setRange(int left, int right, String s)
			throws StringArrayException {
		for (int i = left; i < right; i++)
			set(i, s);
	}

	@Override
	public String toString() {
		return Arrays.toString(a);
	}
}