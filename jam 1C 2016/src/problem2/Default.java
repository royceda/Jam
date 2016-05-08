package problem2;

public class Default {

	public static void main(String[] args) {
		Problem test = new Problem();
		test.parse("./input/C-small-practice.in");
		//test.parse("./input/small2.in");
		test.solve();
		test.print("./output/small.out");
	}

}
