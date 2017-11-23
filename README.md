# EnigmaMachine-Bombe
Modelling of Enigma Machine and the Bombe

COMP1202: Programming 1
Enigma Machine
23/11/2017

The Enigma Machine is composed of the Plugboard, Rotors, Reflector
Basic Rotors and the Turnover Rotors

 -------How to run---------------------------------------
After opening the program, a menu will print to the screen:

*********************************
WELCOME TO ENIGMA
Select which program to run:
1: User created EnigmaMachine
2: EnigmaMachine reading from file example
3: EnigmaMachine coursework examples
4: Bombe coursework examples
5: Exit program
*********************************

Enter the integer relating to the task you want to execute:

1 - Allows the entering your own settings for the machine

2 - will run the Enigma machine incorporating the Enigma File class. 
	This will read a string from the input.txt file and write the decoding to the output.txt file. 
	
3 - Allows the user to choose a test case from the coursework they want to decode. 
	There are 3 examples taken from test 1, 2 and 3 each printed to the screen
	They decode the string of characters using the EnigmaMachine class and the settings 
	specified in the coursework to print out the correct decoding of animal name.

4 - Allows the user to choose which challenge from the coursework they want to test the Bombe on. 
	This uses the Bombe and EnigmaMachine class. 
	The strings from challenge 1, 2 and 3 are presented and when one is selected 
	it is processed and the result is printed to the screen as well as the successful settings.
	
5 - Exits program

The inputs required in this process are always ints, chars or Strings
There is very basic error catching implemented, if they program ever pauses press Enter to continue
