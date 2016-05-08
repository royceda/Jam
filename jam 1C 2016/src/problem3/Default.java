package problem3;

public class Default {

	public static void main(String[] args) {
		Problem test = new Problem();
		test.parse("./inout/C-small-practice.in");
		//test.parse("./inout/small3.in");
		test.solve();
		test.print("./inout/small.out");
	}

}
