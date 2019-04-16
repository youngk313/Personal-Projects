package q3;

import java.util.Scanner;

/**
 * <p>This program tests the MIXChar and Message classes by giving test strings
 * and MIXChar arrays.</p>
 *
 * @author Young Kwon
 * @version 1.0
 */
public class TestMIXChar {
    /** Constant value of three. */
	final static int THREE = 3;
	
	/** Constant value of four. */
	final static int FOUR = 4;
	
	/** Constant value of five. */
    final static int FIVE = 5;
    
    /** Constant value of fifty. */
    final static int FIFTY = 5;
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String userString = reader.next();
        MIXChar testChar = new MIXChar(userString.charAt(0));
        System.out.println(testChar.ordinal() + "\n");
  
        MIXChar[] charsMIX = new MIXChar[FIVE];
        char[] characterArray = new char[FIVE];
        characterArray[0] = 'A';
        characterArray[1] = 'B';
        characterArray[2] = 'C';
        characterArray[THREE] = 'D';
        characterArray[FOUR] = 'E';
        
        for (int i = 0; i < charsMIX.length; i++) {
        	charsMIX[i] = new MIXChar(characterArray[i]);
        }
        Message mess1 = new Message(charsMIX);
        
        String fiftyQuotes = "";
        for (int i = 0; i < FIFTY; i++) {
        	fiftyQuotes += '\'';
        }
        Message mess2 = new Message(fiftyQuotes);
        System.out.println(mess1.toLongs());
        System.out.println(mess1.toString() + "\n");
        System.out.println(mess2.toLongs());
        System.out.println(mess2.toString());
        reader.close();
    }
    
}
