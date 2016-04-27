
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
	FileWriter fw;
	BufferedWriter bw;
	ArrayList<Character> charArrayList;
	String outputnative;
	String outputstatistics;
	int[] statistic;

	public TxtAnalyser() throws IOException {
		statistic = new int[94];
		outputnative = "";
		charArrayList = new ArrayList<Character>();
		readFile();
		analysis();
		output();
		fileoutput();
	

	}

	public void readFile() throws IOException {

		fr = new FileReader("file.txt");
		br = new BufferedReader(fr);

		int line = 0;

		while ((line = br.read()) != -1) {
			char actualChar = (char) line;
			outputnative += actualChar;
			if (actualChar > 33 && actualChar < 132 ) {
				charArrayList.add(actualChar);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		new TxtAnalyser();
	}

	public void output() {
		System.out.println("Input text:");
		System.out.println(outputnative);
		System.out.println(outputstatistics);
		System.out.println(charArrayList.toString());
	}

	public void analysis() {

		for (char toAnalyse : charArrayList) {

			int toAdd = (int) toAnalyse - 33;
			statistic[toAdd] += 1;
		}
		String nl = System.getProperty("line.seperator");
		this.outputstatistics = "\n Statistic for your input: \n";
		for (int i = 0; i < statistic.length; i++) {

			char temp = (char) (i + 32);
			String tempString = "";
			
			for (int count = 0; count < statistic[i]; count++) {
				tempString += "#";
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
		
		bw.close();
	}

}
