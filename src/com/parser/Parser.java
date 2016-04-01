package com.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

import com.cases.Case;


public class Parser {
	
	private int n;
	private ArrayList<Case> cases;
	
	public ArrayList<Case> getCases(){
		return cases;
	}
	
	public Parser(String file) {
		cases = new ArrayList<Case>();
		String line;
		try {
			InputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(isr);
			
			//first line and nb of cases
			if((line = br.readLine()) != null){
				n = Integer.parseInt(line);
			}
			
			
			//the next 
			for(int i = 0; i<n; i++){
				Case tmp = new Case();
				//first
				if((line = br.readLine()) != null){
					tmp.setCredit( Integer.parseInt(line));
				}
				
				//second
				if((line = br.readLine()) != null){
					tmp.setItem( Integer.parseInt(line));
				}
				
				
				//third
				int p[] = new int[tmp.getItem()];
				if((line = br.readLine()) != null){
					String[] var = line.split(" ");	
					for(int j=0; j < tmp.getItem(); j++){
						p[j] = Integer.parseInt(var[j]);
					}
				}
				
				tmp.setPrice(p);
				cases.add(tmp);
			}
			
			
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
