package problem1;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Default {

	public static void main(String[] args){
		CountingSheep prob = new CountingSheep();
		prob.parse("./input/A-large.in");
		prob.solve();
		prob.print("./output/small.out");
		System.out.println("ok");
	}

}
