package ex1;

public class SquareScorer implements Scorer {
	@Override
	public int score(int n) throws ScorerException {
		if (n < 0)
			throw new ScorerException("SquareScorer.score expects non-negative integers");
		int root = (int)Math.sqrt(n);
		return root * root == n ? 3 : 0;
	}
}
