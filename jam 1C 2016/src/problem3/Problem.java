package problem3;

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
	//private int    numCase[];
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
			
			
			//others lines
			for(int i =0; i<n; i++){	
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
		System.out.println("Solving...");
		
		
		for(int i = 0; i<n; i++){
			String[] cas = cases[i].split(" ");
			int K = Integer.parseInt(cas[3]);
			
			
			int J = Integer.parseInt(cas[0]);
			int P = Integer.parseInt(cas[1]);
			int S = Integer.parseInt(cas[2]);
			
			ArrayList<Integer[]> combi = new ArrayList<Integer[]>();
			
			//all combi
			for(int a=1; a<=J; a++){
				for(int b=1; b<=P; b++){
					for(int c=1; c<=S; c++){
						Integer tab[] = new Integer[3];
						tab[0] = a;
						tab[1] = b;
						tab[2] = c;
						combi.add(tab);										
					}
				}		
			}
			
			
			//first filter J+P
			ArrayList<Integer[]> combi1 = new ArrayList<Integer[]>();
			for(int a=1; a<=J; a++){
				for(int b=1; b<=P; b++){
					int count = 0;
					int index = 0;
					
					//loop in list
					for(Integer[] current : combi){			
						//traitement
						if(current[0] == a && current[1] == b && count < K){
							combi1.add(current);			
							count++;
						}
					}
					
				}
			}
			
			
			//second filter P+S
			ArrayList<Integer[]> combi2 = new ArrayList<Integer[]>();
			for(int b=1; b<=P; b++){
				for(int c=1; c<=S; c++){
					
					int count = 0;
					int index = 0;
					
					//loop in list
					for(Integer[] current : combi1){
						//traitement
						if(current[1] == b && current[2] == c && count < K){
							combi2.add(current);			
							count++;
						}
					}
				}
			}
			String sol = "";
			int max = combi2.size();
			
			sol += max+"\n";
			for(Iterator<Integer[]> ite= combi2.iterator(); ite.hasNext();){
				Integer[] tmp = ite.next();
				for(int k = 0; k < tmp.length; k++){
					sol += ""+tmp[k]+" ";			
				}
				sol += "\n";
			}
			
			System.out.println(sol);
			
			solutions[i] = sol;
		}		
	}
	
	
	
	public void print(String file1){
		System.out.println("Printing1...");
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
