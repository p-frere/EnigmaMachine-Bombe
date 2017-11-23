/**Maps each number to a different number and rotates and rotates the next rotor if at the correct position*/
public class TurnoverRotor extends BasicRotor{
	
	private int turnoverPosition;
	private TurnoverRotor nextRotor;
	
	/**Constructor*/
	public TurnoverRotor(String name, TurnoverRotor nextRotor) { 
		super(name);
		this.nextRotor = nextRotor;
		
		switch (name) {
		case "I":
			turnoverPosition = 24;
			break;
		case "II":
			turnoverPosition = 12;
			break;
		case "III":
			turnoverPosition = 3;
			break;
		case "IV":
			turnoverPosition = 17;
			break;
		case "V":
			turnoverPosition = 7;
			break;
		default:
			turnoverPosition = 24;
			break;
			
		}
	}
	
	/**rotates by +1 and if in the correct turnover position and triggers next rotor to rotate*/
	@Override
	public void rotate() {
		super.rotate();
		if (this.getPosition() == turnoverPosition) {
			nextRotor.rotate();
		}
	}

}
