package com.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Parser {
	private int n;
	private String tab[];
	
	public Parser(String file) throws NumberFormatException, IOException{
		
		InputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		
		//first line and nb of cases
		if((line = br.readLine()) != null){
			n = Integer.parseInt(line);
		}
		
		tab = new String[n];
		
		for(int i = 0; i< n; i++){
			if((line = br.readLine()) != null){
				 tab[i] = line;
			}
		}
	}
	
	public int getN(){
		return n;
	}
	
	public String[] getTab(){
		return tab;
	}
	
}
