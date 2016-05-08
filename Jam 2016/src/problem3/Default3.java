package problem3;

public class Default3 {

	public static void  main(String args[]){
		JamCoin jam = new JamCoin();
		//jam.parse("./input/pb3/small.in");
		jam.parse("./input/pb3/C-small-attempt1.in");
		jam.solve();
		jam.print("./output/small3.out");
		System.out.println("OK:!!!");
	}
}
