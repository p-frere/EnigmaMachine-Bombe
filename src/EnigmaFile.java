import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

/**Handles reading and writing to files*/
public class EnigmaFile {

	/**reads message from inputFile*/
	public String readFromFile() {
		try {
			//reads the first line from the file
			BufferedReader br = new BufferedReader(new FileReader("inputFile.txt"));
			String message = br.readLine();
			br.close();
			System.out.println(message + "read from file");
			return message;
			
		} catch (Exception e) {
			//Catches error
			System.out.println("No input file");
			return "";
		}	
	}
	
	/**writes result to outputFile*/
	public void writeToFile(String decodedMessage) {
		try (PrintWriter pr = new PrintWriter(" outputFile.txt")) {
			pr.append(decodedMessage + "\n");
			System.out.println(decodedMessage + " written to file");
		} catch (FileNotFoundException e) {
			//Catches error
			System.out.println("No output file");
		}
	}
}

