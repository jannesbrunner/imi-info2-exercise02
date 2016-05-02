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
	FileWriter fw;
	BufferedWriter bw;
	ArrayList<Character> charArrayList;
	String outputnative;
	String outputstatistics;
	int[] statistic;
	int highest;
	String filename;
	String horizontalData;

	public TxtAnalyser(String filename) throws IOException {
		this.filename = filename;
		highest = 0;
		statistic = new int[94];
		outputnative = "";
		charArrayList = new ArrayList<Character>();
		readFile(filename);
		analysis();
		output();
		fileoutput();
		
	

	}

	public void readFile(String filename) throws IOException {

		fr = new FileReader(filename);

		br = new BufferedReader(fr);

		int line = 0;

		while ((line = br.read()) != -1) {
			char actualChar = (char) line;
			outputnative += actualChar;
			if (actualChar > 32 && actualChar < 132 ) {
				charArrayList.add(actualChar);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		new TxtAnalyser(args[0]);
	}

	public void output() {
	
		System.out.println("Input text:");
		System.out.println();
		System.out.println(outputnative);
		System.out.println(outputstatistics);
		horizontal();
		
	}
	
	public void horizontal(){
		 
		int x = statistic.length;
		
		int[] data = statistic;
		String horizontal = "";
		System.out.println("Vertical statistic for your input: \n");
		for(int y = highest; y > 0; y--){
			
			for(int c = 0; x > c; c++){
				
				if (data[c] >= y){
					horizontal += "|";
				}
				else {
					horizontal += " ";
					
				}
			}
			
		horizontal += "\n";
		
		}
		String scala = "";
		for (int i = 0; i < statistic.length; i++){
			char temp = (char) (i + 32);
			scala += temp;
			
		}
		
		horizontalData = horizontal + scala; 
		System.out.println(horizontalData);
		
	}

	public void analysis() {

		for (char toAnalyse : charArrayList) {

			int toAdd = (int) toAnalyse - 33;
			statistic[toAdd] += 1;
		}
		String nl = System.getProperty("line.seperator");
		this.outputstatistics = "Vertical statistic for your input: \n\n";
		for (int i = 0; i < statistic.length; i++) {

			char temp = (char) (i + 32);
			String tempString = "";
			
			for (int count = 0; count < statistic[i]; count++) {
				tempString += "-";
			}
			
			if(statistic[i] > highest){
				highest = statistic[i];
			}
			
			this.outputstatistics += (temp + ":" + statistic[i] + tempString +"\n");

		}
	}
	
	public void fileoutput() throws IOException {
		File outputfile = new File("output.txt");
		fw = new FileWriter(outputfile);
		bw = new BufferedWriter(fw);
		
		bw.write("Input was: \n");
		bw.newLine();
		bw.write(outputnative);
		bw.newLine();
		bw.write(outputstatistics);
		bw.newLine();
		bw.write(horizontalData);
		
		bw.close();
	}

}
