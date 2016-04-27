/**
 * 
 */
package excercise02;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Jannes Brunner
 *
 */
public class TxtAnalyser {

	FileReader fr;
	BufferedReader br; 
	ArrayList<Character> charArrayList;
	String output;
	int[] statistic; 
	
	public TxtAnalyser() throws IOException {
		statistic = new int[94];
		output = "";
		charArrayList = new ArrayList<Character>();
		readFile();
		output();
		analysis();
		
		
		
	}
	
	public void readFile() throws IOException{
		
		fr = new FileReader("file.txt");
		br = new BufferedReader(fr);
		
		int line = 0;
		
		while ((line = br.read()) != -1) {
			char actualChar = (char) line;
			output += actualChar;
			if (actualChar > 33 && actualChar < 132){
				charArrayList.add(actualChar);
			}
		}

	}
	
	public static void main(String[] args) throws IOException {
		new TxtAnalyser();
	}
	
	public void output(){
		System.out.println(output);
		System.out.println(charArrayList.toString());
	}
	
	public void analysis(){
		
		for (char toAnalyse : charArrayList){
			
			int toAdd = (int) toAnalyse - 33;
			statistic[toAdd] += 1;
		}
		for (int i = 0; i < statistic.length; i++){
		    
			char temp = (char) (i + 32);
			String tempString = "";
			for (int count = 0; count < statistic[i]; count++){
				tempString += "#";
			}
			System.out.println(temp + ":" + statistic[i] + tempString);
			
		}
	}
	
	
	

}
