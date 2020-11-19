public class Stack {
	private int[] a;
	private int num = 0;

	public Stack(int size) {
		a = new int[size];
	}

	public boolean isEmpty() {
		return num == 0;
	}

	public void push(int val) throws Exception {
		if (num == a.length)
			throw new Exception("Push to a full Stack");
		a[num++] = val;
	}

	public int pop() throws Exception {
		if (num == 0)
			throw new Exception(
					"Pop from an empty Stack");
		return a[--num];
	}

	public static void main(String[] args)
			throws Exception {
		Stack s = new Stack(10);
		s.pop();
	}
}
