/**
 * 
 */
package q3;

/** <p> The Message class accepts an array of of MIXChar characters or
 * a string and encodes it into 'long' values for every 11 characters.
 * It also decodes the 'long' values to recreate the original message. 
 * </p>
 * @author Young Kwon
 * @version 1.0
 */
public class Message {
    /** constant for the maximum number of MIX characters allowed in
    * one 'long' value. */
    private final int maxChars = 11;
    
    /** The base value for the MIX character system. */
    private static final int MIXBASE = 56;
    
    /** The array that will hold the 'long' values. */
    private Long[] numChars;
    
    /** An array of all the characters of the MIX character system. */
    private final char[] mixChars = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 
    		'G', 'H', 'I', '\u0394', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
    		'Q', 'R', '\u03A3', '\u03A0', 'S', 'T', 'U', 'V', 'W', 'X', 
    		'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
    		'.', ',', '(', ')', '+', '-', '*', '/', '=', '$', '<', '>', 
    		'@', ';', ':', '\''};
    
    /** Constructor that accepts a MIXChar array and converts every 11
     * characters to a single 'long' value in base 56.
     * @param m 
     * an array with MIXChar objects. */
    public Message(MIXChar[] m) {
    	long sum;
    	int remainder = m.length % maxChars;
    	int arrayLongSize = (int) Math.ceil(m.length / (double) maxChars);
    	numChars = new Long[arrayLongSize];
        for (int i = 0; i < arrayLongSize; i++) {
        	sum = 0;
        	if (i == arrayLongSize - 1) {
        		for (int j = 0; j < remainder; j++) {
        			sum += m[i + j].ordinal() * power(MIXBASE, remainder 
        				- 1 - j);
        		}
        		numChars[i] = sum;
        	} else {
        		for (int j = 0; j < maxChars; j++) {
        			sum += m[i + j].ordinal() * power(MIXBASE, maxChars 
        				- 1 - j);
        		}
        		numChars[i] = sum;
        	}
        }
    }
    
    /** Constructor that accepts a string and converts every 11 characters 
     * in the string to a single 'long' value. 
     * @param s 
     * string with a predetermined amount of characters. */
    
    public Message(String s) {
    	long sum;
    	MIXChar currMIX;
    	int remainder = s.length() % maxChars;
    	int arrayLongSize = (int) Math.ceil(s.length() / (double) maxChars);
    	numChars = new Long[arrayLongSize];
        for (int i = 0; i < arrayLongSize; i++) {
        	sum = 0;
        	if (i == arrayLongSize - 1) {
        		for (int j = 0; j < remainder; j++) {
        			currMIX = new MIXChar(s.charAt(i + j));
        			sum += currMIX.ordinal() * power(MIXBASE, remainder 
        				- 1 - j);
        		}
        		numChars[i] = sum;
        	} else {
        		for (int j = 0; j < maxChars; j++) {
        			currMIX = new MIXChar(s.charAt(i + j));
        			sum += currMIX.ordinal() * power(MIXBASE, maxChars
        				- 1 - j);
        		}
        		numChars[i] = sum;
        	}
        }
    }
    
    /** A support method for calculating the power.
     * @param base  
     * @param exponent  
     * @return the final product or power. */
    
    private long power(int base, int exponent) {
    	long product = 1;
    	for (int i = 1; i <= exponent; i++) {
    		product *= base;
    	}
    	return product;
    }
    
    /** A support method that converts an integer to the corresponding
     * MIX character. 
     * @param valueMIX 
     * 	an integer (usually the remainder from decoding) 
     * @return the corresponding MIX character. */
    
    private char convertMIX(int valueMIX) {
    	char letterMIX = 'e';
    	int count = 0;
    	while (count < mixChars.length) {
    		if (count == valueMIX) {
    			letterMIX = mixChars[count];
    			break;
    		}
    		count++;
    	}
    	return letterMIX;
    }
    
    /** A method that decodes an array of 'long' numbers and shows the 
     * correct MIXChars in the appropriate place values. 
     * @return a string that should be the same as the original message. 
     * */
    public String toString() {
    	String finalMessage = "";
    	String finalMessRev = "";
    	int remainder;
    	long quotient;
    	for (int i = 0; i < numChars.length; i++) {
    		quotient = numChars[i];
    		while (quotient != 0) {
    			remainder = (int) (Long.remainderUnsigned(quotient, 
    				MIXBASE));
    			quotient = Long.divideUnsigned(quotient, MIXBASE);    		
    			finalMessage += convertMIX(remainder);
    		}
    	}
    	for (int i = finalMessage.length() - 1; i >= 0; i--) {
    		finalMessRev += finalMessage.charAt(i);
    	}
    	return finalMessRev;
    }
    
    /** A method that gives an array of 'long' numbers that are 
     * encoded values for every 11 MIX characters. 
     * @return an */
    public String toLongs() {
    	String encodedMess = "";
    	for (int i = 0; i < numChars.length; i++) {
    		encodedMess += numChars[i] + " ";
    	}
    	return encodedMess;
    }
}
