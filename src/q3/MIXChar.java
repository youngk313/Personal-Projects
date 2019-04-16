/**
 * 
 */
package q3;

/**
 * <p> This class is a representation of a MIXChar character. It has
 * various methods for checking if a character is a MIXChar and for
 * converting between MIXChar arrays and strings. </p>
 * @author Young Kwon
 * @version 1.0
 */
public class MIXChar {
    
	/** instance variable that holds the character. */
    private char charActual;
    
    /** constant with the MIX code value of Delta. */
    private final static int VALUEDELTA = 10;
    
    /** constant with the MIX code value of Sigma. */
    private static final int VALUES = 18;
    
    /** the first MIX code value of the first number (0). */
    final static int MINMIXNUM = 30;
    
    /** the minimum single digit number. */
    final static int MINNUM = '0';
    
    /** the maximum single digit number. */
    private static final int MAXNUM = '9';
    
    /** the number of punctuation and non-alphanumeric characters in 
     * the MIX code system. */
    private static final int PUNCTSIZE = 16;
    
    /** the first MIX code value of the first non-alphanumeric 
     * character. */
    private static final int STARTPUNCT = 40;
    
    /** the base value of the MIX code value system. */
    private static final int MIXBASE = 56;
    
    /** Constant value of four. */
    private final static int FOUR = 4;
    
    /** an array that will hold the non-alphanumeric characters. */
    private static Character[] punctuation = {'.', ',', '(', ')', '+', '-', 
    		'*', '/', '=', '$', '<', '>', '@', ';', ':', '\''};
    
    /** constructor that checks to see if the input character is a MIXChar
     * character and creates the object if it is. Otherwise it will warn the 
     * user that the input character is not a MIXChar character.
     *  @throws an IllegalArgumentException with a warning.  
     * @param c
     * 	 a character 
     **/
    public MIXChar(char c) {
    	if (isMIXChar(c)) {
    		charActual = c;
    	} else {
    		throw new IllegalArgumentException("Not a MIXChar!");
    	}
    }
 
    /** a method to returns the character that the MIXChar character 
     * represents. 
     * @return a character in Java. */
    public char toChar() {
        char charJava = charActual;
        return charJava;
    }
    
    /** a method that returns the MIXChar value of the MIXChar character. 
     * @return the integer value of the MIXChar character. */
    public int ordinal() {
        int cValue = charActual;
        if (cValue >= 'A') {
            cValue -= 'A';
            if (cValue <= VALUEDELTA) {
                cValue += 1;
            } else if (cValue > VALUEDELTA && cValue < VALUES) {
                cValue += 2;
            } else if (cValue >= VALUES) {
                cValue += FOUR;
            }
        } else if (cValue >= MINNUM && cValue <= MAXNUM) {
            cValue -= MINNUM;
            cValue += MINMIXNUM;
        } else {
            int i = 0;
            boolean punctFlag = false;
            while (!punctFlag && i < PUNCTSIZE) {
                if (punctuation[i].equals(charActual)) {
                    cValue = i + STARTPUNCT;
                    punctFlag = true;
                }
               i++;
           }
            if (!punctFlag) {
                System.out.println("Not a MIX Character!");
            }
        }
       
        return cValue;
    }
    
    /** an overloaded method that is specific to the MIXChar class which returns
     * the MIXChar value of a specific character. 
     * @param c
     * 		an input character. 
     * @return the integer value of the MIXChar character. */
    private static int ordinal(char c) {
        int cValue = c;
        if (cValue >= 'A') {
            cValue -= 'A';
            if (cValue <= VALUEDELTA) {
                cValue += 1;
            } else if (cValue > VALUEDELTA && cValue < VALUES) {
                cValue += 2;
            } else if (cValue >= VALUES) {
                cValue += FOUR;
            }
        } else if (cValue >= MINNUM && cValue <= MAXNUM) {
            cValue -= MINNUM;
            cValue += MINMIXNUM;
        } else {
            int i = 0;
            boolean punctFlag = false;
            while (!punctFlag && i < PUNCTSIZE) {
                if (punctuation[i].equals(c)) {
                    cValue = i + STARTPUNCT;
                    punctFlag = true;
                }
               i++;
           }
        }       
        return cValue;
    }
    
    /** a method that checks to see if a specific character is in the MIXChar 
     * character system. 
     * @param c 
     *  the input character. 
     * @return a boolean value indicating if the character is a MIXChar 
     * or not. */
    public static boolean isMIXChar(char c) {
        boolean charFlag = false;
        int checkMIX = ordinal(c);
        if (checkMIX >= 0 && checkMIX < MIXBASE) {
            charFlag = true;
        }
        return charFlag;
    }
    
    /** a method that returns an array of MIXChar characters as a string.
     * @param m 
     *  an array of MIXChar characters.
     * @return a string of MIXChar characters. */
    public static String toString(MIXChar[] m) {
    	String stringMIX = "";
    	for (int i = 0; i < m.length; i++) {
    		stringMIX += m[i].toString();
    	}
    	return stringMIX;
    }
    
    /** a method that converts a string to an array of MIXChar characters. 
     * @param s 
     *  the input string. 
     * @return an array with MIXChar characters. */
    public static MIXChar[] toMIXChar(String s) {
    	MIXChar[] arrayMIX = new MIXChar[s.length()];
    	int count = 0;
    	while (isMIXChar(s.charAt(count)) && count < s.length()) {
    		arrayMIX[count] = new MIXChar(s.charAt(count));
    		count++;
    	}
    	return arrayMIX;
    }
    
    /** a method that gives the character represented by the MIXChar object
     * as a string. 
     * @return a string containing the MIXChar character. */
    public String toString() {
        String charJava = "" + charActual;
        return charJava;
    }
    
}
