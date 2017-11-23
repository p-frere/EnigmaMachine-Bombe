
public class test {
	/*int[] mapping = new int[] { 4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9 };
	int pos = 5;
	int input = 2;
	
	public void go() {
		int temp = substitute(input); 
		temp = substituteBack(temp);
		System.out.println("\n"+temp);
		//substituteBack(substitute(pos)) = pos for all 0<=pos<26
	}
	
	public int substitute(int input) {
		
		System.out.println(input + " input");
		System.out.println(pos + " current shift");
		
		
		/*
		input = input + pos;
		
		input = (input > 25) ? (input - 26) : input;
		System.out.println(input + " number to map");
		
		input = mapping[input];
		
		System.out.println(input);
		*/
		
		
		/*
		input = input - pos;
		System.out.println(input + " before rap");
		input = (input < 0) ? (26 + input) : input;
		System.out.println(input + " number to map");
		
		input = mapping[input];
		
		System.out.println(input + " before adding");
		input = input + pos;
		input = (input > 25) ? (input - 26) : input;
		
		System.out.println("final number: "+ input);
		System.out.println();
		return input;
		

	}
	
	public int substituteBack(int input) { //do I have to create a sperate array?
		/*
		for (int i = 0; i < mapping.length; i++) {
			if (mapping[i] == input) {
				return substitute(i);
			}
		}*/ /*
		int[] inverseMapping = new int[26];
		for (int i = 0; i < inverseMapping.length; i++) {
			inverseMapping[mapping[i]] = i;
		}
		mapping = inverseMapping;
		return substitute(input);
	}*/


}
