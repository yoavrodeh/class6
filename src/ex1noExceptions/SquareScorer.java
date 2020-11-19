package ex1noExceptions;

public class SquareScorer implements Scorer {
	@Override
	public int score(int n) {
		int root = (int)Math.sqrt(n);
		return root * root == n ? 3 : 0;
	}
}
