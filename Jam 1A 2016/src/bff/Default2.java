package bff;

public class Default2 {

	public static void main(String[] args) {
		bff test = new bff();
		test.parse("./input/C-small-practice.in");
		//test.parse("./input/small2.in");
		test.solve();
		test.print("./output/small.out");
	}

}
