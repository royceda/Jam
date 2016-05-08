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

public class Pancakes {

	private int n;
	private String cases[];
	//private String var[];
	
	private int solutions[];
	private int c;
	
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
	
	
	public void flip(String tab[], int b, int e){
		String tmp[] = new String[b+e];
		
		for(int i = b; i<e; i++){
			if(tab[e-i-1].equals("-")){
				tmp[i] = "+";
			}
			else if(tab[e-i-1].equals("+")){
				tmp[i] = "-";
			}
		}
		
		//copy
		for(int i = b; i<e; i++ ){
			tab[i] = tmp[i];
		}
	}
	
	private boolean completed(String var[]){
		for(int i=0; i<var.length; i++){
			if(var[i].equals("-")){
				return false;
			}
		}
		return true;
	}
	
	
	
	public int solveRec(String var[], int s){
		
		if(completed(var))
			return c;
		
		if(var[s-1].equals("+")){
			s = s-1; // change s = s-1 reduce()
			return solveRec(var, s);
		}
		
		if(var[s-1].equals("-")){
			if(var[0].equals("-")){
				c++;
				flip(var, 0,s); //flip all
				return solveRec(var, s); 
			}
			if(var[0].equals("+")){
				int k = s-1;
				while(var[k].equals("-")){
					k--;
				}
				c++;
				flip(var, 0, k+1);
				return solveRec(var, s);
			}	
		}
		return c;
	}
	
	
	public void solve(){
		solutions = new int[n];
		for(int i = 0; i<n; i++){
			String tmp = cases[i];
			String var1[] = tmp.split("");
			
			String var[] = new String[var1.length -1];
			
			
			//debug
			for(int j=1; j<var1.length; j++){
				var[j-1] = var1[j];
			}
			c = 0;
			solveRec(var, var.length);
			System.out.println("count: "+c);
			solutions[i] = c;
		}
	}
	
	
	public void print(String file1){
		System.out.println("Printing...");
		PrintWriter writer;
		try {
			writer = new PrintWriter(file1, "UTF-8");
			//int size = 12;
			
			String txt = "";
			for(int i =0; i<n; i++){
				txt += "Case #"+(i+1)+": "+solutions[i]+"\n";  
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

