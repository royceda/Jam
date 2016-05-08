package training;

public class DefaultT {

	public static void main(String[] args) {
		Numbers num = new Numbers();
		num.parse("./input/training/C-large-practice.in");
		//num.parse("./input/training/small.in");
		num.solve();
		num.print("./output/small.out");

	}

}
