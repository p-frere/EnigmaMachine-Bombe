/**Maps each number to a different number and rotates*/
public class BasicRotor extends Rotor{
	
	public BasicRotor(String name) {
		initialise(name);
	}
	
	/**assigns a mapping based on name*/
	@Override
	public void initialise(String name) {
		switch (name) {
		case "I":
			mapping = new int[] { 4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9 };
			break;
		case "II":
			mapping = new int[]  { 0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4 };
			break;
		case "III":
			mapping = new int[]  { 1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14 };
			break;
		case "IV":
			mapping = new int[]  {4, 18, 14, 21, 15, 25, 9, 0, 24, 16, 20, 8, 17, 7, 23, 11, 13, 5, 19, 6, 10, 3, 2, 12, 22, 1 };
			break;
		case "V":
			mapping = new int[]  { 21, 25, 1, 17, 6, 8, 19, 24, 20, 15, 18, 3, 13, 7, 11, 23, 0, 22, 12, 9, 16, 14, 5, 4, 2, 10 };
			break;
		default:
			mapping = new int[] { 4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9 };
			break;
		}
	}
	
	/**maps input onto mapping*/
	@Override
	public int substitute(int input) {

		input = input - this.getPosition();
		//raps round if input goes under 0
		input = (input < 0) ? (26 + input) : input;
		
		input = mapping[input];
		
		input = input + this.getPosition();
		//raps round if input goes over 25
		input = (input > 25) ? (input - 26) : input;

		return input;

	}
	
	/**maps input onto reverse mapping*/
	public int substituteBack(int input) { //can we make this substitute?
		
		//reverses the mapping array
		int[] inverseMapping = new int[26];
		for (int i = 0; i < inverseMapping.length; i++) {
			inverseMapping[mapping[i]] = i;
		}
		
		input = input - this.getPosition();
		//raps round if input goes under 0
		input = (input < 0) ? (26 + input) : input;
		
		input = inverseMapping[input];
		
		input = input + this.getPosition();
		//raps round if input goes over 25
		input = (input > 25) ? (input - 26) : input;
		
		return input;
	}
	
	/**Rotates rotor by 1 unless it's at max when it's set back to 0*/
	public void rotate() {
		//if the position is >25 set it to 0 else add 1
		this.setPosition((this.getPosition()+1 > 25) ? (this.getPosition()+1 - 26) : this.getPosition()+1);
	}

}
