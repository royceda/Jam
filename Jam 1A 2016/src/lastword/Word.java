package lastword;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Word {

	private int n; 
	
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
	
	
	public void addTails(char[] word, char tmp){
		int i = 0;
		while(word[i] != '0'){
			i++;
		}
		word[i] = tmp;
		
		
	}
	
	public void addHead(char[] word, char tmp){
		int i = word.length-1;
		
		while(word[i] == '0' ){
			i--;
		}
		
		//moving
		for(int j = i; j>=0; j--){
			word[j+1] = word[j];
		}
		word[0] = tmp;
	}
	
	
	
	public void solve(){
		
		solutions = new String[n];
		for(int i = 0; i<n;i++){
			
			String w1 = cases[i];
			char[] first = w1.toUpperCase().toCharArray();
			char[] word = new char[first.length];
			
			Arrays.fill(word, '0');
			
			word[0] = first[0];
			char pivot = word[0];
			
			for(int j=1; j< first.length; j++){
				char tmp = first[j];
				
				if(tmp < word[0]){
					addTails(word,tmp);
				}else{
					addHead(word, tmp);
				}
			}
			
			solutions[i]= "";
			for(int j =0; j<word.length; j++)
				solutions[i] += word[j]; 		
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
