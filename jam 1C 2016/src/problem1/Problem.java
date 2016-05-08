package problem1;

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
	
	
	private int max1(int tab[]){
		int m = 0;
		int index = 0;
		for(int i=0; i< tab.length; i++){
			if(tab[i] > m){
				index = i;
				m = tab[i];
			}
		}
		return index;
	}
	
	private int max2(int tab[]){
		int i1 = max1(tab);
		int m = 0;
		int index = 0;
		for(int i=0; i< tab.length; i++){
			if(i != i1)
				if(tab[i] > m){
					index = i;
					m = tab[i];
				}
		}
		return index;
	}
	
	private double ratio(int tab[], int i){
		double sum = 0.0;
		for(int k =0; k<tab.length; k++){
			sum += tab[k];
		}
		return tab[i]/sum;
	}
	
	private boolean isEqual(int tab[], int index){
		tab[index]--;
		for(int i = 0; i<tab.length; i++){
			if(ratio(tab, i) > 0.5){
				tab[index]++;
				return false;
			}
		}
		tab[index]++;
		return true;
	}
	
	private boolean isEmpty(int tab[]){
		for(int i=0; i<tab.length; i++){
			if(tab[i] != 0){
				return false;
			}
		}
		return true;
	}
	
	private boolean isLast(int tab[], int index){
		if(tab[index] > 0)
			for(int i =0; i< tab.length; i++){
				if(i != index && tab[i] > 0)
					return false;
			}		
		return true;
	}
	
	public void solve(){
		System.out.println("Solving...");
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int i = 0;
		for (char ch = 'A'; ch <= 'Z'; ch++){ 
			  map.put(i, String.valueOf(ch)); 
			  i++;
		}
		
		for(i = 0; i<n; i++){
			int N = numCase[i];
			String var[] = cases[i].split(" ");
			int tab[] = new int[N];
			
			String sol = "";
			
			
			for(int j = 0; j<N; j++){
				tab[j] = Integer.parseInt(var[j]);
			}
			
			while(!isEmpty(tab)){
				int index1 = max1(tab);
				int index2 = max2(tab);
				
				//add 
				if(tab[index1] > 0){
					String part1 = map.get(index1);
					tab[index1]--;
					sol += part1;
				}
				if(tab[index1] > 0 && isEqual(tab, index1)){
					String part1 = map.get(index1);
					tab[index1]--;
					sol += part1;
				}else if(tab[index2] > 0 && isEqual(tab, index2)){
					String part2 = map.get(index2);
					tab[index2]--;
					sol += part2;
				}else if(tab[index2] > 0 && isLast(tab, index2)){
					String part2 = map.get(index2);
					tab[index2]--;
					sol += part2;
				}
						
				sol +=" ";
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
