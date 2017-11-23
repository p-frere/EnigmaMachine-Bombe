/**The Bombe finds missing settings using a string we know is contained inside the encoded text*/
public class Bombe {

	EnigmaMachine eMachine;
	
	private String contains;
	private String encodedMessage;
	private String output;

	private char plug1socket1;
	private char plug1socket2;
	private char plug2socket1;
	private char plug2socket2;

	private String basicRotor1;
	private String basicRotor2;
	private String basicRotor3;

	private int rotor1pos;
	private int rotor2pos;
	private int rotor3pos;
	
	//Getters and Setters
	public String getContains() {
		return contains;
	}

	public void setContains(String contains) {
		this.contains = contains;
	}

	public void setEncodedMessage(String encodedMessage) {
		this.encodedMessage = encodedMessage;
	}

	public void setPlug1socket1(char plug1socket1) {
		this.plug1socket1 = plug1socket1;
	}

	public void setPlug1socket2(char plug1socket2) {
		this.plug1socket2 = plug1socket2;
	}

	public void setPlug2socket1(char plug2socket1) {
		this.plug2socket1 = plug2socket1;
	}

	public void setPlug2socket2(char plug2socket2) {
		this.plug2socket2 = plug2socket2;
	}

	public void setBasicRotor1(String basicRotor1) {
		this.basicRotor1 = basicRotor1;
	}

	public void setBasicRotor2(String basicRotor2) {
		this.basicRotor2 = basicRotor2;
	}

	public void setBasicRotor3(String basicRotor3) {
		this.basicRotor3 = basicRotor3;
	}

	public void setRotor1pos(int rotor1pos) {
		this.rotor1pos = rotor1pos;
	}

	public void setRotor2pos(int rotor2pos) {
		this.rotor2pos = rotor2pos;
	}

	public void setRotor3pos(int rotor3pos) {
		this.rotor3pos = rotor3pos;
	}

	public void setOutput(String output) {
		this.output = output;
	}
	
	/**Creates Enigma Machine with specified variables*/
	public void createEMachine() {
		eMachine = new EnigmaMachine();

		eMachine.addPlug(plug1socket1, plug1socket2);
		eMachine.addPlug(plug2socket1, plug2socket2);
		eMachine.addRotor(new BasicRotor(basicRotor3), 2);
		eMachine.setPosition(2, rotor3pos);
		eMachine.addRotor(new BasicRotor(basicRotor2), 1);
		eMachine.setPosition(1, rotor2pos);
		eMachine.addRotor(new BasicRotor(basicRotor1), 0);
		eMachine.setPosition(0, rotor1pos);
		eMachine.addReflector(new Reflector("I"));
	}
	
	/**Cycles through all possible positions of 2 plugs missing ends*/
	public void findPlugs() {
		plug1socket2 = 'A';
		plug2socket2 = 'A';

		while (plug1socket2 <= 'Z') {
			while (plug2socket2 <= 'Z') {
				//creates an enigma machine with the new settings
				createEMachine();
				//if output meets criteria it returns it
				output = eMachine.Bombe(encodedMessage);
				if (checkContains(output)) {
					resultFound(output);
				}
				plug2socket2 = (char) (plug2socket2 + 1);
			}
			plug1socket2 = (char) (plug1socket2 + 1);
			plug2socket2 = 'A';
		}
	}
	
	/**cycles through all possible positions of the 3 rotors*/
	public void findPositions() {
		rotor1pos = 0;
		rotor2pos = 0;
		rotor3pos = 0;

		while (rotor1pos <= 25) {
			while (rotor2pos <= 25) {
				while(rotor3pos <= 25) {
					//creates an enigma machine with the new settings
					createEMachine();
					//if output meets criteria it returns it
					output = eMachine.Bombe(encodedMessage);
					if (checkContains(output)) {
						resultFound(output);
					}
					rotor3pos = rotor3pos+ 1;
				}
				rotor2pos = rotor2pos + 1;
				rotor3pos = 0;
			}
			rotor1pos = rotor1pos + 1;
			rotor2pos = 0;
		}
	}
	
	/**cycles through all possible rotor types*/
	public void findRotorType() {
		int int_basicRotor1 = 1;
		int int_basicRotor2 = 1;
		int int_basicRotor3 = 1;

		while (int_basicRotor1 <= 5) {
			while (int_basicRotor2 <= 5) {
				while(int_basicRotor3 <= 5) {
					
					basicRotor1 = ConvertToNumeral(int_basicRotor1);
					basicRotor2 = ConvertToNumeral(int_basicRotor2);
					basicRotor3 = ConvertToNumeral(int_basicRotor3);
					
					//creates an enigma machine with the new settings
					createEMachine();
					//if output meets criteria it returns it
					output = eMachine.Bombe(encodedMessage);
					if (checkContains(output)) {
						resultFound(output);
					}
					int_basicRotor3 = int_basicRotor3+ 1;
				}
				int_basicRotor2 = int_basicRotor2 + 1;
				int_basicRotor3 = 1;
			}
			int_basicRotor1 = int_basicRotor1 + 1;
			int_basicRotor2 = 1;
		}
	}
	
	/**checks the output contains a specific phrase*/
	public boolean checkContains(String output) {
		if (output.contains(contains)) {
			return true;
		}

		return false;
	}
	
	/**prints settings and matching output*/
	public void resultFound(String output) {
		System.out.println("POSSIBLE RESULT FOUND");
		System.out.println("plugs: [" + plug1socket1 + ", " + plug1socket2 + "] [" + plug2socket1 + ", " + plug2socket2 + "]");
		System.out.println("basic rotor: " + basicRotor1 + ", position " + rotor1pos);
		System.out.println("basic rotor: " + basicRotor2 + ", position " + rotor2pos);
		System.out.println("basic rotor: " + basicRotor3 + ", position " + rotor3pos);
		
		System.out.println("\nOutput: " + output);
		System.out.println("");
	}
	
	/**Convers numbers 1-5 into roman numerals*/
	public String ConvertToNumeral(int number) {
		switch (number) {
		case 1:
			return "I";
		case 2:
			return "II";
		case 3:
			return "III";
		case 4:
			return "IV";
		case 5:
			return "V";
		default:
			System.out.println(number);
			System.out.println("Error in rotor numbers");
			return null;
		}
	}

}
