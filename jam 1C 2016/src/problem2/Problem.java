package problem2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Problem {
	private int    n; 
	private int    numCase[];
	private String cases[];
	private String solutions[];
	
	
	public void parse(String file){
		System.out.println("Parsing...");
		String line;
		try {
			InputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(isr);
			
			//first line and nb of cases
			if((line = br.readLine()) != null){
				n = Integer.parseInt(line);
			}
			
			cases = new String[n];
			solutions = new String[n];
			numCase = new int[n];
			
			
			//others lines
			for(int i =0; i<n; i++){
				if((line = br.readLine()) != null){
					numCase[i] = Integer.parseInt(line);
				}
				if((line = br.readLine()) != null){
					cases[i] = line; 
				}
			}
		}catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public void solve(){
		for(int i = 0; i<n; i++){
			
		}		
	}
	
	
	
	public void print(String file1){
		System.out.println("Printing...");
		PrintWriter writer;
		try {
			writer = new PrintWriter(file1, "UTF-8");
			int size = 12;
			
			String txt = "";
			for(int i =0; i<n; i++){
				int c = i+1;
				txt += "Case #"+c+": "+solutions[i]+"\n";  
			}
			
			writer.println(txt);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
