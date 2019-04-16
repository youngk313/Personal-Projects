package q1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * <p>This is a program will calculate the mean and standard deviation based 
 * on a given set of integers.</p>
 *
 * @author Young Kwon
 * @version 1.0
 */
public class Statistics {
 
    /** This method will calculate the mean of the given data. 
     * @param numbers 
     * 	the array of data
     * @param counter 
     * 	the number of data entries
     * @return average */
    private static float calculateMean(int[] numbers, int counter) {
        float average = 0;
        int sum = 0;
        int index = 0;
        while (index < counter) {
            sum += numbers[index];
            index++;
        }
        average = (float) sum / index;
        return average;
    }
    
    /** This method calculates the standard deviation of the given data. 
     * @param numbers 
     *  the array of data  
     * @param counter 
     * 	the number of entries  
     * @param mean 
     * the mean of the entries 
     * @return std, the standard deviation */
    private static float calculateStd(int[] numbers, int counter, float mean) {
        float std = 0;
        float sum = 0;
        int index = 0;
        while (index < counter) {
            sum += Math.pow((numbers[index] - mean), 2);
            index++;
        }
        std = (float) Math.sqrt(sum / (index - 1));
        return std;
    }
    
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args 
     * 	command line arguments.
     */
    public static void main(String[] args) {
        final int maxArray = 50;
        int[] data = new int[maxArray];
        DecimalFormat formatter = new DecimalFormat("0.00");
        float mean;
        float std;
        Scanner reader = new Scanner(System.in);
        int count = 0;
        while (reader.hasNextInt()) {
            try {
                data[count] = reader.nextInt();
            } catch (ArrayIndexOutOfBoundsException err) {
                System.out.println("You can't add any more data!");
                break;
            }
            count++;
        }
        mean = calculateMean(data, count);
        std = calculateStd(data, count, mean);
        System.out.println("Mean: " + formatter.format(mean));
        System.out.println("Standard Deviation: " + formatter.format(std));
        reader.close();
    }

};
