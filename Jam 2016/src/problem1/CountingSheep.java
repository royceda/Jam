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



public class CountingSheep {
	private int n;
	private int cases[];
	
	private boolean set[];
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
			
			//others lines
			for(int i =0; i<n; i++){
				if((line = br.readLine()) != null){
					cases[i] = Integer.parseInt(line); 
				}
			}
		}catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private boolean isCompleted(){
		
		for(int i=0; i<10; i++){
			if(!set[i]){
				return false;
			}
		}
		return true;
	}
	
	
	public void solve(){
		System.out.println("Solving...");
		solutions = new String[n];
		set = new boolean[10];
		
		Arrays.fill(set, false);
		
		
		for(int k=0; k<n; k++){
			//one case
			
			if(cases[k] == 0){
				solutions[k] =  "INSOMNIA";
				k++;
			}
			
			int c = cases[k];
			int i = 0;
			int tmp = 0;
			while(!isCompleted()){
				i++;
				tmp = i*c;
				String tmp1 = ""+tmp;
				String var[] = tmp1.split("");
				
				for(int j=1; j<var.length; j++){
					int num = Integer.parseInt(var[j]);
					set[num] = true;
				}
				
			}
			Arrays.fill(set, false);
			System.out.println("count: "+tmp);
			solutions[k] = ""+tmp;
			
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
