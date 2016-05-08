package lastword;

public class Default {

	public static void main(String[] args) {
		String w1 = "toto";
		char[] first = w1.toLowerCase().toCharArray();

		if(first[0] == "t".toCharArray()[0])
			System.out.println("OK");
			
		
		for(int i = 0; i< first.length; i++){
			System.out.println(i+":"+first[i]);
		}
		
		Word test = new Word();
		test.parse("./input/A-large.in");
		test.solve();
		test.print("./output/small.out");
	}

}
