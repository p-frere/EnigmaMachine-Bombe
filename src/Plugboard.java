import java.util.ArrayList;
/**The plugboard stores the plugs*/
public class Plugboard {
	
	//list of all the plugs in use
	private ArrayList<Plug> plugsList = new ArrayList<Plug>();
	
	//create new plug
	public boolean addPlug(char end1, char end2) {
		Plug newPlug = new Plug(end1, end2);
		
		for ( Plug plug : plugsList ) {
			if (newPlug.clashesWith(plug)) {	//HAVEN't used this??
				return false;
			}	
		}
		plugsList.add(newPlug);
		return true;		
	}
	
	/**gets number of plugs*/
	public int getNumPlugs() {
		return plugsList.size(); 
	}
	
	/**clears plug list*/
	public void clear() {
		plugsList.clear();
	}
	
	/**if the input is a plug then it is encoded and returned
	else the original letter is returned */
	public char substitute(char letter) {
		for ( Plug plug : plugsList ) {			
			if ((letter == plug.getEnd1()) || (letter == plug.getEnd2())) {
				return plug.encode(letter);
			}
		}
		return letter;
	}
}
