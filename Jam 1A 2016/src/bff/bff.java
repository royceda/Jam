package bff;

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

public class bff {
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
	
	
	private int maxi(int tab[]){
		int m1 = 0;
		for(int i =0; i<tab.length; i++){
			if(m1<tab[i]){
				m1 = tab[i];
			}	
		}
		
		return m1;
	}
	
	private boolean isCompleted(Node v, boolean tab[]){
		for(Iterator<Node> ite = v.getChilds().iterator(); ite.hasNext();){
			Node tmp = ite.next();
			if(!tab[tmp.getId()]){
				return false;
			}
		}
		return true;
	}
	
	
	public int DFS(Node v, int k, boolean black[]){
		black[v.getId()] = true;
		
		int n = v.getChilds().size();
		int tab[] = new int[n];
		if(isCompleted(v, black)){
			return k;
		}else{
			int i = 0;
			k++;
			for(Iterator<Node> ite = v.getChilds().iterator(); ite.hasNext();){
				Node tmp = ite.next();
				
				if(!black[tmp.getId()]){
					tab[i] = DFS(tmp, k, black);
					i++;
				}
			}
		}
		return maxi(tab);
	}
	
	
	public void solve(){
		for(int i = 0; i<n; i++){
			HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
			String var[] = cases[i].split(" ");
			
			for(int j = 0; j< var.length; j++){
				Node tmp = new Node(j);
				nodes.put(j,tmp);
			}
			
			for(int j = 0; j< var.length; j++){
				int bff = Integer.parseInt(var[j])-1;
				nodes.get(j).getChilds().add(nodes.get(bff));	
				nodes.get(bff).getChilds().add(nodes.get(j));
			}
			
			
			int tab[] = new int[var.length];
			int k = 0;
			boolean black[] = new boolean[var.length];
			
			for(Integer key : nodes.keySet()){
				Arrays.fill(black, false);
				tab[k] = DFS(nodes.get(key), 1, black);
				k++;
			}
			
			solutions[i] = ""+maxi(tab);
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
