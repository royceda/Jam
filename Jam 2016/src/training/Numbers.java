package training;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Numbers {
	
	private int n;
	private int cases[];
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
			
			cases = new int[n];
			solutions = new String[n];
			
			//others lines
			for(int i =0; i<n; i++){
				if((line = br.readLine()) != null){
					//String var[] = line.split(" ");
					cases[i] = Integer.parseInt(line);
				}
			}
		}catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void solve(){
		for(int i=0; i<n;i++){
			
			int a = cases[i]; 
			double sol = Math.pow((3+Math.sqrt(5)),a);
			
			System.out.println(sol);
			
			String tmp = ""+sol;
			String var[] = tmp.split("");
			
			String buff= "";
			int k = 0;
			while(!buff.equals(".")){
				k++; 
				buff = var[k];
			}
			
			String fin[] = new String[3];
			int ind = 3;
			for(int j=k-1; j>0; j--){
				ind--;
				//System.out.println("count: "+var[j]);
				fin[ind] = var[j];
				if(ind == 0){
					break;
				}
				
			}
			
			for(int j=0; j<ind; j++){
				fin[j] = "0";
			}
			
			solutions[i] = fin[0]+fin[1]+fin[2];
			
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
