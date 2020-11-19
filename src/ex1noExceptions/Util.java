package ex1noExceptions;

public class Util {
	public static int sumScores(Scorer[] ss, int n) {
		int sum = 0;
		for (Scorer s : ss)
			sum += s.score(n);
		return sum;
	}
}
