package ex1noExceptions;

public class DivideScorer implements Scorer {
	private int d;
	public DivideScorer(int d) {
		this.d = d;
	}
	@Override
	public int score(int n) {
		return n % d == 0 ? 1 : 0;
	}
}
