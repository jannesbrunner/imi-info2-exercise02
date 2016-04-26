/**
 * 
 */
package excercise02;

import java.io.*;

/**
 * @author Jannes Brunner
 *
 */
public class TxtAnalyser {

	FileReader fr;
	BufferedReader br; 
	char[] charArray;
	
	public TxtAnalyser() throws IOException {
		readFile();
	}
	
	public void readFile() throws IOException{
		fr = new FileReader("file.txt");
		br = new BufferedReader(fr);
		br.read(charArray);
		for(char test : charArray){
			System.out.println(test);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new TxtAnalyser();
	}

}
