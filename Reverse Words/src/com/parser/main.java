package com.parser;

import java.io.IOException;
import java.io.PrintWriter;

public class main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Parser parse = new Parser("./input/B-large-practice.in");
		String out = "";
		for(int i = 0; i<parse.getN(); i++){
			String[]  line = parse.getTab()[i].split(" ");
			String word = "";
			for(int j = line.length-1; j >=0; j--){
				word += line[j]+" ";
				
			}
			out += "Case #"+(i+1)+": "+word+"\n";
		}

		PrintWriter writer = new PrintWriter("./output/file.out", "UTF-8");
		int size = 12;
		writer.println(out);
		writer.close();
		
		System.out.println("ok");
	}
	

}
