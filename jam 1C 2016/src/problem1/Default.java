package problem1;

public class Default {

	public static void main(String[] args) {
		Problem test = new Problem();
		//test.parse("./inout/A-small-attempt4.in");
		//test.parse("./inout/small.in");
		test.parse("./inout/A-large.in");
		test.solve();
		test.print("./inout/small.out");
	}

}
