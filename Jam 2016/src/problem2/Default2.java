package problem2;

public class Default2 {

	public static void main(String[] args) {
		Pancakes pan = new Pancakes();
		
		pan.parse("./input/pb2/B-large.in");
		pan.solve();
		pan.print("./output/small1.out");
	}

}
