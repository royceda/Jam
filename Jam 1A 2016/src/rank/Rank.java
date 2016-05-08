package rank;

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

public class Rank {

	private int n;
	private int N[];
	
	private String cases[][];
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
			
			cases = new String[n][];
			N = new int[n];
			
			
			//others lines
			for(int i =0; i<n; i++){
				//first line N
				if((line = br.readLine()) != null){
					N[i] = Integer.parseInt(line); 
				}
				
				
				//N-1 lines
				cases[i] = new String[N[i]];
				for(int j =0; j < N[i]; j++ ){
					if((line = br.readLine()) != null){
						cases[i][j] = line; 
					}
				}
			}
			
		}catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*
	 * return index of the row where the min is
	 */
	private int findMin(ArrayList<Integer[]> tab){
		
		return 0;
	}
	
	/*
	 * return index of the row where the max is
	 */
	private int findMax(ArrayList<Integer[]> tab){
		
		return 0;
	}
	
	private void place(ArrayList<Integer[]> tab, int sol[][], int index){
		
	}
	
	private boolean isCompleted(int sol[][]){
		
		
		return false;
	}
	
	private void stick(ArrayList<Integer[]> tab, int sol[][]){
		while(!isCompleted(sol) && !tab.isEmpty()){
			
			
			
		}
	}
	
	
	private String findMissing(int sol[][], ArrayList<Integer[]> list){
		
		return "";
	}
	
	
	/* trie des listes
	 * prendre le premier
	 * collage
	 * trouver le manquant (boucle NxN)
	 */
	public void solve(){
		for(int i = 0; i<n; i++){
			//init
			int size = N[i];
			String tmp[] = cases[i];
			ArrayList<Integer[]> list = new ArrayList<Integer[]>();
			ArrayList<Integer[]> tab = new ArrayList<Integer[]>();
			
			for(int j = 0; j<tmp.length; j++){
				String var[] = tmp[j].split(" ");
				Integer tmpTab[] = new Integer[var.length];
				
				for(int k = 0; k<var.length; k++){
					tmpTab[k] = Integer.parseInt(var[k]);
				}
				
				tab.add(tmpTab);
				list.add(tmpTab);
			}
			
			//pre-solve
			int sol[][] = new int[size+1][size+1]; 
			Arrays.fill(sol, -1);
			
			int min = findMin(tab);
			int max = findMax(tab);
			
			//first 
			place(tab, sol, min);

			//others
			stick(tab,sol);
			
			//sol
			solutions[i] = findMissing(sol, list);
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
