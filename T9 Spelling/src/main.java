import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import com.parser.Parser;

public class main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		HashMap<String, String> map = new HashMap<String, String>();
		initMap(map);
		
		Parser parse = new Parser("./input/C-small-practice.in");
		String out = "";
		for(int i = 0; i<parse.getN(); i++){
			String[] tmp = parse.getWords()[i].split("");
			String code = "";
			
			
			for(int j=1; j<tmp.length; j++){
				if(tmp[j].equals(tmp[j-1])){
					code += " ";
				}else if(j >= 2){
					String[] tmpCode = map.get(tmp[j]).split("");				
					String[] tmpCode1 = map.get(tmp[j-1]).split("");
					//double
					if(j >= 2 && tmpCode[1].equals(tmpCode1[tmpCode1.length-1])){
						code += " ";			
					}
				}
				
				code += map.get(tmp[j]);
			}
			out += "Case #"+(i+1)+": "+code+"\n";	
		}
		
		PrintWriter writer = new PrintWriter("./output/file.out", "UTF-8");
		int size = 12;
		writer.println(out);
		writer.close();
		
		System.out.println("Ok!!");
	}
	
	public static void initMap(HashMap<String, String> map){
		map.put(" ", "0");
		map.put("0", "0000");
		map.put("1", "1111");
		map.put("2", "2222");
		map.put("3", "3333");
		map.put("4", "4444");
		map.put("5", "5555");
		map.put("6", "6666");
		map.put("7", "77777");
		map.put("8", "8888");
		map.put("9", "99999");
		
		
		map.put("a", "2");
		map.put("b", "22");
		map.put("c", "222");
		
		map.put("d", "3");
		map.put("e", "33");
		map.put("f", "333");
		
		map.put("g", "4");
		map.put("h", "44");
		map.put("i", "444");
		
		map.put("j", "5");
		map.put("k", "55");
		map.put("l", "555");
		
		map.put("m", "6");
		map.put("n", "66");
		map.put("o", "666");
		
		map.put("p", "7");
		map.put("q", "77");
		map.put("r", "777");
		map.put("s", "7777");
		
		map.put("t", "8");
		map.put("u", "88");
		map.put("v", "888");
		
		map.put("w", "99");
		map.put("x", "99");
		map.put("y", "999");
		map.put("z", "9999");
		
		
		
	}

}
