package ex1;

public class DivideScorer implements Scorer {
	private int d;
	public DivideScorer(int d) throws ScorerException {
		if (d <= 0)
			throw new ScorerException("DivideScorer constructor expects positive integers");
		this.d = d;
	}
	@Override
	public int score(int n) {
		return n % d == 0 ? 1 : 0;
	}
}
