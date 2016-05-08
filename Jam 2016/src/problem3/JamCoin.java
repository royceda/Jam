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

public class JamCoin {
	private int n;
	private int J[];
	private int N[];
	
	
	private String solutions[];
	private long[] set;
	
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
			
			J = new int[n];
			N = new int[n];
			
			//others lines
			for(int i =0; i<n; i++){
				if((line = br.readLine()) != null){
					String var[] = line.split(" ");
					N[i] = Integer.parseInt(var[0]);
					J[i] = Integer.parseInt(var[1]);
				}
			}
		}catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private int isPrime(long n){
		int c = 0;
		
		for(int i =2; i<n; i++){
			if(n%i == 0){
				c = i;
			}
		}
		
		return c;
	}
	
	private boolean check(long tab[]){
		for(int i = 0; i<tab.length; i++){
			long tmp = isPrime(tab[i]);
			if(tmp == 0)
				return false;
			else{
				set[i] = tmp;
			}
		}
		return true;
	}
	
	private long interpret(String n, int b){
		String var[] = n.split("");
		long sum = 0;
		for(int i=var.length-1; i>=1; i--){
			if(var[i].equals("1"))
				sum += 1*Math.pow(b, i);	
		}
		
		return sum;
	}
	
	
	public void solve(){
		System.out.println("Solving...");
		solutions = new String[n];
		
		int s = 10;
		for(int i = 0; i<n; i++){
			solutions[i] = "";
			int count = 0;
			int j =0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			while(count < J[i] ){
			//for(int j=0; j<s; j++){
				//if(count == J[i])
					//break;
				
				j = (int) (0 + (Math.random())*Math.pow(2, N[i]-2));
				while(list.contains(j))
					j = (int) (0 + (Math.random())*Math.pow(2, N[i]-2));	
				
				
				list.add(j);
				
				System.out.println("time: "+j);
				
				//create a jam
				String bin = "1";
				String bin2 = Integer.toBinaryString(j);
				int len = bin2.split("").length -1;
				for(int k = 0; k<N[i]-(len+2); k++){
					bin += "0";
				}
				bin += bin2+"1";
				
				//bin = "1001";
				//create interpretation
				long inter[] = new long[9];
				for(int k = 2; k <=10; k++ ){
					inter[k-2] = Long.parseLong(bin,k);	
					//inter[k-2] = interpret(bin, k);
				}
				
				set = new long[9];
				
				if(check(inter)){
					solutions[i] += bin;
					for(int k=0; k<9; k++){
						solutions[i] += " "+set[k];
					}
					solutions[i] += "\n";
					count++;
				}				
				j++;		
			}
			System.out.println("Sol: "+solutions[i]);
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
				txt += "Case #"+(i+1)+":\n"+solutions[i]+"\n";  
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
