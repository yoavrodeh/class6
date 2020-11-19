package ex1;

public class Main {
	public static void main(String[] args) {
		Scorer[] ss = new Scorer[3];
		try {
			ss[0] = new DivideScorer(-2);
			ss[1] = new DivideScorer(3);
		} catch (ScorerException e) {
			e.printStackTrace();
			return;
		}
		ss[2] = new SquareScorer();
		System.out.println(Util.sumScores(ss, -8));		
	}
}
