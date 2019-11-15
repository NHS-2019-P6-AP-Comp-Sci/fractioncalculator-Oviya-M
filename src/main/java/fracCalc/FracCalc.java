/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args)
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	//INTRODUCTION AND USER INPUT
    	System.out.print("Please enter in a equation that adds, subtracts, multiplies");
    	System.out.println("or divides 2 fractions (can be proper, improper or mixed): ");
    	Scanner userInput = new Scanner(System.in);
    	String user = userInput.nextLine();
    	
    	//CALLS, STORES AND PRINTS RETURN VALUE OF FUNCTION produceAnswer
    	String x = produceAnswer(user);
    	System.out.println(x);
    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) {
        // TODO: Implement this function to produce the solution to the input
    	//VARIABLES FOR EACH STRING
    	String operand1 = "";
    	String operator = "";
    	String operand2 = "";
    	
    	//FIND INDEX OF SPACE
    	int spcIndex = input.indexOf(" ");
    	//USE INDEX OF SPACE TO RETURN SUBSTRINGS OF THE "input" PARAMETER
    	operand1 = input.substring(0, spcIndex);
    	operator = input.substring(spcIndex+1, spcIndex+2);
    	int opIndex = input.indexOf(operator);
    	operand2 = input.substring(opIndex+2);
    	//Test
    	//System.out.println("operand1 = " + operand1);
    	//System.out.println("operator = " + operator);
    	//System.out.println("operand1 = " + operand2);
        return operand2;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

}
