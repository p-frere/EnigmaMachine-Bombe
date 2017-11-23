/**The plug maps one value to a diffrent one*/
public class Plug {
	
	private char end1;
	private char end2;
	
	//constructor class set ends
	public Plug(char end1, char end2) {
		setEnd1(end1);
		setEnd2(end2);
	}
	
	//getters and setters
	public char getEnd1(){
		return end1;
	}
	public char getEnd2() {
		return end2;
	}
	public void setEnd1(char end1) {
		this.end1 = end1;
	}
	public void setEnd2(char end2) {
		this.end2 = end2;
	}
	
	/**returns letter on other end of plug*/
	public char encode(char letterIn) {
		if (letterIn == end1) {
			return end2;
		} else if (letterIn == end2) {
			return end1;
		} else {
			return letterIn;
		}
	}
	
	/**check if plug can be added or if there is a clash*/
	public boolean clashesWith(Plug plugin){
		if ((plugin.getEnd1() == end1)||
			(plugin.getEnd2() == end2)||
			(plugin.getEnd1() == end1)||
			(plugin.getEnd2() == end2)) {
			return true;
		} else {
			return false;
		}
	}
	
}
