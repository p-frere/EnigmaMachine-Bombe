/**Maps each number to a different number and rotates*/

public abstract class Rotor {
	private String name; 		//type of rotor as string, eg II
	private int position; 		//value of 0 -25 where it starts
	protected int[] mapping; 	//which lettes it maps to
	
	protected static final int ROTORSIZE = 26; //Is this how you do constant??********
	
	//setters and getters
	public void setPosition(int position){
		this.position = position;
	}
	
	public int getPosition() {
		return position;
	}
	
	/**Selects the mapping of the rotor*/
	public abstract void initialise(String name);
	
	/**Takes an int, maps it and returns an in*/
	public abstract int substitute(int input);
}

