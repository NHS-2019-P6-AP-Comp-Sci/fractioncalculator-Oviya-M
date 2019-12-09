/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		// INTRODUCTION AND USER INPUT
		String user = "";
		Scanner userInput = new Scanner(System.in);
		while (!user.equals("quit")) {
			System.out.print("Please enter in a equation that adds, subtracts, multiplies");
			System.out.println("or divides 2 fractions (can be proper, improper or mixed): ");

			user = userInput.nextLine();

			if (!user.equals("quit")) {

				String x = produceAnswer(user);
				System.out.println(x);
			}
		}

		// CALLS, STORES AND PRINTS RETURN VALUE OF FUNCTION produceAnswer

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		// TODO: Implement this function to produce the solution to the input
		// VARIABLES FOR EACH STRING

		String operand1 = "";
		String operator = "";
		String operand2 = "";

		// FIND INDEX OF SPACE
		int spcIndex = input.indexOf(" ");
		// USE INDEX OF SPACE TO RETURN SUBSTRINGS OF THE "input" PARAMETER
		operand1 = input.substring(0, spcIndex);

		// didn't work because after saving slash, it would use the index of previous
		// slash so i took out variable
		operator = input.substring(spcIndex + 1, spcIndex + 2);

		operand2 = input.substring(spcIndex + 3);

		// SPLIT OPERAND1 INTO INTEGERS NUMBER

		int undSc = operand1.indexOf("_");
		int slash1 = operand1.indexOf("/");
		int whole1;
		int numer1;
		int denom1;
		if (slash1 != -1) {
			// FRACTION DENOMINATOr
			int length1 = operand1.length();
			String c = operand1.substring(slash1 + 1, length1);
			denom1 = Integer.parseInt(c);

			if (undSc != -1) {
				// WHOLE NUM
				String a = operand1.substring(0, undSc);
				whole1 = Integer.parseInt(a);

				// FRACTION NUMERATOR WITH "_"
				String b = operand1.substring(undSc + 1, slash1);
				numer1 = Integer.parseInt(b);

			} else {
				// FRACTION NUMERATOR WITHOUT "_" (NO WHOLE NUM)
				whole1 = 0;
				String b = operand1.substring(0, slash1);
				numer1 = Integer.parseInt(b);

			}
		} else {
			numer1 = 0;
			denom1 = 1;
			if (undSc != -1) {
				// WHOLE NUM
				whole1 = 0;

			} else {
				// FRACTION NUMERATOR WITHOUT "_" (NO WHOLE NUM)
				int wLength1 = operand2.length();
				String a = operand1.substring(0);
				whole1 = Integer.parseInt(a);

			}
		}

		// SPLIT OPERAND2 INTO INTEGERS NUMBER

		int slash2 = operand2.indexOf("/");
		int undSc2 = operand2.indexOf("_");
		int whole2;
		int numer2;
		int denom2;
		if (slash2 != -1) {
			// FRACTION DENOMINATOR
			int length2 = operand2.length();
			String f = operand2.substring(slash2 + 1, length2);
			denom2 = Integer.parseInt(f);

			if (undSc2 != -1) {
				// WHOLE NUM
				String d = operand2.substring(0, undSc2);
				whole2 = Integer.parseInt(d);

				// FRACTION NUMERATOR
				String e = operand2.substring(undSc2 + 1, slash2);
				numer2 = Integer.parseInt(e);

			} else {
				// WHOLE WITHOUT "_"
				whole2 = 0;
				// NUMERATOR WITHOUT "_"
				String e = operand2.substring(0, slash2);
				numer2 = Integer.parseInt(e);

			}

		} else {
			numer2 = 0;
			denom2 = 1;
			if (undSc2 != -1) {
				// WHOLE WITHOUT
				whole2 = 0;
			} else {
				// WHOLE NUM
				String d = operand2.substring(0);
				whole2 = Integer.parseInt(d);

			}
		}
		if (whole1 >= 0) {
			numer1 = (denom1 * whole1) + numer1;
		}
		if (whole1 < 0) {
			numer1 = -1 * (Math.abs(denom1 * whole1) + numer1);

		}
		if (whole2 < 0) {
			numer2 = -1 * (Math.abs(denom2 * whole2) + numer2);

		}
		if (whole2 >= 0) {
			numer2 = (denom2 * whole2) + numer2;
		}

		int numerA = 0;
		int denomA = 0;
		// MULTIPLICATION
		if (operator.equals("*")) {
			numerA = numer1 * numer2;
			denomA = denom1 * denom2;
		}
		// DIVISION
		else if (operator.equals("/")) {
			numerA = numer1 * denom2;
			denomA = denom1 * numer2;
		}

		// ADDITION or SUBTRACTION

		if (operator.equals("+") || operator.contentEquals("-")) {
			numer1 *= denom2;
			denomA = denom1 * denom2;
			numer2 *= denom1;

			if (operator.equals("+")) {
				numerA = numer1 + numer2;
			} else {
				numerA = numer1 - numer2;
			}
		}
		if (numerA < 0 && denomA < 0) {
			numerA = Math.abs(numerA);
			denomA = Math.abs(denomA);
		}

		String y = "";
		int numerAbs = Math.abs(numerA);
		int denomAbs = Math.abs(denomA);
		// CHECK IF CAN BE SIMPLIFIED TO WHOLE NUMBER
		if ((numerA % denomA) == 0) {
			int ans = numerA / denomA;
			y = "" + ans + "";

		}

		// REDUCING THE FRACTIONS AND RETURN IF PROPER
		else if (numerAbs < denomAbs) {
			for (int i = numerAbs; i > 0; i--) {
				if (((numerA % i) == 0) && ((denomA % i) == 0)) {
					numerA /= i;
					denomA /= i;
				}
			}
			if (numerA < 0 || denomA < 0) {
				denomA = Math.abs(denomA);
				numerA = Math.abs(numerA);
				y = "" + numerA * -1 + "/" + denomA;
			} else {
				y = "" + numerA + "/" + denomA;
			}

		} else if (denomAbs < numerAbs) {
			for (int i = denomAbs; i > 0; i--) {
				if (((numerA % i) == 0) && ((denomA % i) == 0)) {
					numerA /= i;
					denomA /= i;
				}
			}
			// IMPROPER FRACTION to MIXED
			int wholeA = numerA / denomA;
			numerA = Math.abs(numerA % denomA);
			denomA = Math.abs(denomA);
			y = "" + wholeA + "_" + numerA + "/" + denomA;
		}

		// RETURNS
		return y;

	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
