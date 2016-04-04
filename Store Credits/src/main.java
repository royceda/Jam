import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import com.cases.Case;
import com.parser.Parser;
import com.test.IntegerProg;

public class main {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException{
		// TODO Auto-generated method stub
		System.out.println("Hello World");
				
		Parser parse = new Parser("./input/A-large-practice.in");
		IntegerProg prog = new IntegerProg();
		
		int k = 0;
		String out="";
		
		for(Iterator<Case> ite = parse.getCases().iterator(); ite.hasNext();){
			k++;
			Case tmp = ite.next();
			double x[] = prog.solve(tmp);	
			out += "Case #"+k+":";
			for(int i=0; i<x.length; i++){
				if(x[i] > 0){
					out += " "+(i+1);
				}
			}
			out +="\n";
		}
		System.out.println(out);
		
		print("./output/file.out", out);
		
		System.out.println("OK");

	}
	
	
	
	public static void print(String file1, String txt) throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter(file1, "UTF-8");
		int size = 12;
		writer.println(txt);
		/*for(Iterator<String> ite = instruction.iterator(); ite.hasNext();){
			String tmp = ite.next();
			writer.println(tmp);
		}*/
		writer.close();
		System.out.println("End.");
	}
	
	
}
