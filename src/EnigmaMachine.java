/**Models the Enigma Machine*/
public class EnigmaMachine {

	private Plugboard pb = new Plugboard();
	private BasicRotor[] slots = new BasicRotor[3];
	private Reflector currentReflector;

	/**calls add plug from plugboard*/
	public boolean addPlug(char in, char out) {
		return pb.addPlug(in, out);
	}

	/**calls clear from plugboard*/		//***NEVER USED THIS??***
	public void clearPlugboard() {
		pb.clear();
	}

	/**adds rotor in certain position in the slots array*/
	public void addRotor(BasicRotor basicRotor, int slot) {
		slots[slot] = basicRotor;
	}

	/**gets position of rotor in the slots array*/
	public Rotor getRotor(int slot) {
		return slots[slot];
	}
	
	/**Adds a reflector*/
	public void addReflector(Reflector reflector) {
		currentReflector = reflector;
	}

	/**gets the reflector name*/
	public Rotor getReflector() {
		return currentReflector;
	}

	/**sets pos of rotor in certain slot*/
	public void setPosition(int slot, int position) {
		slots[slot].setPosition(position);
	}

	/**Converts A-Z into 0-25*/
	public int encodeLetter(char letter) {
		return (int) letter - 65; // Turns ascii value into 0-25
	}
	
	/**Converts 0-25 into A-Z*/
	public char decodeLetter(int number) {
		return (char) (number + 65); // Turns ascii value into 0-25
	}

	/**Creates an EnigmaMachine that is written and read from a file*/
	public void file(String message) {
		EnigmaFile enigmaFile = new EnigmaFile();
		enigmaFile.writeToFile(start(message));
	}
	
	/**Creates an EnigmaMachine for the bombe*/
	public String Bombe(String message) {
		return start(message);	
	}
	
	/**Creates an EnigmaMachine for the encryption of a string*/
	public String eMachine(String message) {
		message = start(message);
		System.out.println(message);
		return message;
	}
	
	/**The Enigma machine core - Takes a string encodes it and returns a string*/
	public String start(String message) {
		
		StringBuilder sb = new StringBuilder();	//builds the encoded message one char at a time
		char[] letters = message.toCharArray();	//holds the plain text as an arry of chars
		char temp;								//store the temporary char being operated on
		int tempint;							//store the temporary int being operated on (This is the temp converted into an int)
		
		for (char letter : letters) {

			// Character is sent to the Plugboard and substituted then the char is converted into an int
			temp = pb.substitute(letter);
			tempint = encodeLetter(temp);

			// the int is passed between each rotor getting mapped each time
			for (int i = 0; i < slots.length; i++) {
				tempint = slots[i].substitute(tempint);
			}
			
			//the int is reflected back
			tempint = currentReflector.substitute(tempint);

			// the int is passed back between each rotor getting mapped each time
			for (int j = slots.length - 1; j >= 0; j--) {
				tempint = slots[j].substituteBack(tempint);
			}
			
			//Substituted back and turned into a char
			temp = decodeLetter(tempint);
			temp = pb.substitute(temp);
			
			sb.append(temp);
			slots[0].rotate();
		}
		return sb.toString();
	}
}
