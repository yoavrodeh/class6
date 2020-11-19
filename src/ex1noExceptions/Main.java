package ex1noExceptions;
public class Main {
	public static void main(String[] args) {
		Scorer[] ss = new Scorer[3];
		ss[0] = new DivideScorer(2);
		ss[1] = new DivideScorer(3);
		ss[2] = new SquareScorer();
		System.out.println(Util.sumScores(ss, 81));	 
		// 4	
	}
}
