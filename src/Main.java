import java.util.Scanner;

/**Contains the main method, creates the menus and holds the settings for test cases*/
public class Main {
	Scanner scanner = new Scanner(System.in);
	
	/**Calls main to eMachine the program*/
	public static void main(String[] args) {
		new Main();
	}
	
	/**Prints menu and allows menu selection*/
	private Main() {	
		System.out.println("WELCOME TO ENIGMA");	
		while(true) {
			printStars();
			System.out.println("Select which program to run:");
			System.out.println("1: User created EnigmaMachine");
			System.out.println("2: EnigmaMachine reading from file example");
			System.out.println("3: EnigmaMachine coursework examples");
			System.out.println("4: Bombe coursework examples");
			System.out.println("5: Exit program");
			printStars();
			
			//user input for the menu selection
			int userInput = scanner.nextInt();
			scanner.reset();
			scanner.nextLine();
			
			switch (userInput) {
			case 1:
				userSettings();
				break;
			case 2:
				fileIOEnigma();	
				break;
			case 3:
				autoSettingsEnigma();
				break;
			case 4:
				autoSettingsBombe();
				break;
			case 5:
				System.exit(0);
			default:
				break;
			}
		}
	}
	
	/**Prints a row of stars*/
	private void printStars() {	
		System.out.println("*********************************");	
	}
	
	/**Allows the user to choose which settings to run on the Enigma Machine
	 * with their own message to encrypt*/
	private void userSettings() {
		
		String message;
		int numberOfPlugs;
		int rotorpos1;
		int rotorpos2;
		int rotorpos3;
		boolean settingsComplete = false;
		EnigmaMachine EMachine = new EnigmaMachine();
		
		while (!settingsComplete) {		
			try {

				System.out.println("Enter the number of plugs required up to 14:");
		
				numberOfPlugs = scanner.nextInt();
				scanner.nextLine();
				
				if (numberOfPlugs > 14) {
					throw new Exception();
				}
				
				//Adds the number of plugs the user has specified
				for (int i = 0; i < numberOfPlugs; i++) {
					Character socket1;
					Character socket2;
					
					System.out.println("Enter the letter of the 1st socket:");
					//Makes sure the input is upper case and one character long
					socket1 = scanner.nextLine().toUpperCase().charAt(0);
					
					System.out.println("Enter the letter of the 2nd socket:");
					socket2 = scanner.nextLine().toUpperCase().charAt(0);
					
					//Checks sockets are both Alphabetic
					if (!(Character.isAlphabetic(socket1) && Character.isAlphabetic(socket2))) {
						throw new Exception();
					}	
					
					//returns true if a plug is successfully made
					if (!EMachine.addPlug(socket1, socket2)) {
						throw new Exception();
					}
				}
				
				//Adds rotor positons
				System.out.println("Enter a number for the position of the");
				System.out.println("1st rotor:");
				rotorpos1 = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("2nd rotor:");
				rotorpos2 = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("3rd rotor:");
				rotorpos3 = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Enter the text to encrypt:");
				message = scanner.nextLine().toUpperCase();
				//regex to catch any non alphabetic characters
				if (!message.matches("[A-Z]+\\.?")) {
					throw new Exception();
				}
				
				//If the program has reached this far without reeMachineing the loop the user imput is correct
				settingsComplete = true;
				
				EMachine.addRotor(new BasicRotor("I"), 0); 
				EMachine.setPosition(0, rotorpos1); 
				EMachine.addRotor(new BasicRotor("II"), 1); 
				EMachine.setPosition(1, rotorpos2); 
				EMachine.addRotor(new BasicRotor("III"), 2); 
				EMachine.setPosition(2, rotorpos3);
				EMachine.addReflector(new Reflector("I"));
				EMachine.eMachine(message);
			
			} catch (Exception e) {
				//Error message then the code goes back to the top of the loop
				System.out.println("You have entered the incorrect syntax\nPlease try again");
				scanner.nextLine();
				scanner.reset();
			}
		}		
	}
	

	/**Allows the user to choose which test to run on the Enigma Machine
	 * Each challenge has it's own settings related with it */
	private void autoSettingsEnigma() {
		
		printStars();
		System.out.println("Select which Test to run:");
		System.out.println("1: GFWIQH");
		System.out.println("2: GACIG");
		System.out.println("3: OJVAYFGUOFIVOTAYRNIWJYQWMXUEJGXYGIFT");
		printStars();
		
		String message;
		int userInput;
		EnigmaMachine EMachine = new EnigmaMachine();
		
		//Gets user input
		userInput = scanner.nextInt();
		scanner.nextLine();
		
		printStars();
		
		//Creates an Enigma Machine with the correct settings for the selection
		switch (userInput) {
		case 1:
			//Correct Answer: BADGER
			message = "GFWIQH"; 
			EMachine.addPlug('A', 'M');
			EMachine.addPlug('G', 'L'); 
			EMachine.addPlug('E', 'T'); 
			EMachine.addRotor(new BasicRotor("I"), 0); 
			EMachine.setPosition(0, 6); 
			EMachine.addRotor(new BasicRotor("II"), 1); 
			EMachine.setPosition(1,12); 
			EMachine.addRotor(new BasicRotor("III"), 2); 
			EMachine.setPosition(2, 5);
			EMachine.addReflector(new Reflector("I"));
			EMachine.eMachine(message);
			break;
			
		case 2:
			//Correct Answer: SNAKE
			message = "GACIG"; 
			EMachine.addPlug('B', 'C');
			EMachine.addPlug('R', 'I'); 
			EMachine.addPlug('A', 'F'); 
			EMachine.addPlug('S', 'M');
			EMachine.addRotor(new BasicRotor("IV"), 0); 
			EMachine.setPosition(0, 23); 
			EMachine.addRotor(new BasicRotor("V"), 1);
			EMachine.setPosition(1, 4); 
			EMachine.addRotor(new BasicRotor("II"), 2);
			EMachine.setPosition(2, 9); 
			EMachine.addReflector(new Reflector("II"));
			EMachine.eMachine(message);
			break;
			
		case 3:
			//Correct Answer: THEQUICKBROWNFOXJUMPEDOVERTHELAZYDOG
			message = "OJVAYFGUOFIVOTAYRNIWJYQWMXUEJGXYGIFT";
			EMachine.addPlug('Q', 'F');
			EMachine.addRotor(new TurnoverRotor("III", null), 2);
			EMachine.setPosition(2, 7);
			EMachine.addRotor(new TurnoverRotor("II", (TurnoverRotor) EMachine.getRotor(2)), 1);
			EMachine.setPosition(1, 11);
			EMachine.addRotor(new TurnoverRotor("I", (TurnoverRotor) EMachine.getRotor(1)), 0);
			EMachine.setPosition(0, 23);
			EMachine.addReflector(new Reflector("I"));
			EMachine.eMachine(message);
			break;
		}	
		printStars();
	}
	
	/**Allows the user to choose which challenge to run on the Bombe
	 * Each challenge has it's own settings related with it */
	private void autoSettingsBombe() {
		
		printStars();
		System.out.println("Select which Challenge to run:");
		System.out.println("1: JBZAQVEBRPEVPUOBXFLCPJQSYFJI");
		System.out.println("2: AVPBLOGHFRLTFELQEZQINUAXHTJMXDWERTTCHLZTGBFUPORNHZSLGZMJNEINTBSTBPPQFPMLSVKPETWFD");
		System.out.println("3: WMTIOMNXDKUCQCGLNOIBUYLHSFQSVIWYQCLRAAKZNJBOYWW");
		printStars();
		
		String message;
		int userInput;
		Bombe bombe = new Bombe();
		
		//Gets user input
		userInput = scanner.nextInt();
		scanner.nextLine();
		
		
		printStars();
		
		//Creates an Enigma Machine with the correct settings for the selection
		switch (userInput) {
		case 1:	
			//Correct Answer: DAISYDAISYGIVEMEYOURANSWERDO
			bombe.setContains("ANSWER");
			bombe.setEncodedMessage("JBZAQVEBRPEVPUOBXFLCPJQSYFJI");
			
			bombe.setPlug1socket1('D');
			bombe.setPlug2socket1('S');
			
			bombe.setBasicRotor1("IV");
			bombe.setBasicRotor2("III");
			bombe.setBasicRotor3("II");

			bombe.setRotor1pos(8);
			bombe.setRotor2pos(4);
			bombe.setRotor3pos(21);
			
			bombe.findPlugs();
			break;
			
		case 2:
			//Correct Answer: WELLALWAYSBETOGETHERHOWEVERFARITSEEMSWELLALWAYSBETOGETHERTOGETHERINELECTRICDREAMS
			bombe.setContains("ELECTRIC");
			bombe.setEncodedMessage("AVPBLOGHFRLTFELQEZQINUAXHTJMXDWERTTCHLZTGBFUPORNHZSLGZMJNEINTBSTBPPQFPMLSVKPETWFD");
			
			bombe.setPlug1socket1('H');
			bombe.setPlug1socket2('L');
			bombe.setPlug2socket1('G');
			bombe.setPlug2socket2('P');

			bombe.setBasicRotor1("V");
			bombe.setBasicRotor2("III");
			bombe.setBasicRotor3("II");
			
			bombe.findPositions();
			break;
			
		case 3:
			//Correct Answer: ILOVECOFFEEILOVETEAILOVETHEJAVAJIVEANDITLOVESME
			bombe.setContains("JAVA");
			bombe.setEncodedMessage("WMTIOMNXDKUCQCGLNOIBUYLHSFQSVIWYQCLRAAKZNJBOYWW");
			bombe.setPlug1socket1('M');
			bombe.setPlug1socket2('F');
			bombe.setPlug2socket1('O');
			bombe.setPlug2socket2('I');

			bombe.setRotor1pos(22);
			bombe.setRotor2pos(24);
			bombe.setRotor3pos(23);
			
			bombe.findRotorType();
			break;
		}
		printStars();
	}
	
	/**Creates EnigmaMachine with specified settings and calls EnigmaFile class to show file handling*/
	private void fileIOEnigma() {
		
		printStars();
		EnigmaMachine EMachine = new EnigmaMachine();
		EnigmaFile EFile = new EnigmaFile();
		String message = EFile.readFromFile();
		
		//Addes default settings
		EMachine.addPlug('Q', 'F');
		EMachine.addRotor(new TurnoverRotor("III", null), 2);
		EMachine.setPosition(2, 7);
		EMachine.addRotor(new TurnoverRotor("II", (TurnoverRotor) EMachine.getRotor(2)), 1);
		EMachine.setPosition(1, 11);
		EMachine.addRotor(new TurnoverRotor("I", (TurnoverRotor) EMachine.getRotor(1)), 0);
		EMachine.setPosition(0, 23);
		EMachine.addReflector(new Reflector("I"));
		EMachine.file(message);
		printStars();
	}

}
