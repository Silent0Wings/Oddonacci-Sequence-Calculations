package L_Oddonacci;

import java.math.BigInteger;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Linear_Oddonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test2();
		// LinearTailRecursiveOddonacci_Run(200);
		// MultipleOddonacci_Run(23);
		// LinearTailRecursiveOddonacci_Run(200);
		MultipleOddonacci_Run(21);
	}

	/**
	 * Runs the MultipleOddonacci method multiple times with different inputs and
	 * records the execution time.-
	 *
	 * @param numRuns The number of runs to perform.
	 */
	public static void MultipleOddonacci_Run(int numRuns) {
		int increment = 5;
		int true_counter = 0;
		int Data_Precision = 1;
		int[] BigOInput = new int[numRuns / increment + 1];
		long[] BigO_time = new long[numRuns / increment + 1];
		BigInteger[] Oddonacci_Arr = new BigInteger[numRuns / increment + 1];

		for (int i = 0; i <= numRuns; i += increment, true_counter++) {
			System.gc();
			for (int j = 0; j < Data_Precision; j++) {
				long startTime = System.nanoTime();
				BigOInput[true_counter] = i;
				// Calculate Oddonacci number using the MultipleOddonacci function.
				Oddonacci_Arr[true_counter] = MultipleOddonacci(i, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE);
				if (j == 0) {
					BigO_time[true_counter] = System.nanoTime() - startTime;
				} else {
					BigO_time[true_counter] = Math.min(BigO_time[true_counter], System.nanoTime() - startTime);
				}
			}
			System.out.println(Oddonacci_Arr[true_counter]);

		}

		// Save the results to a file.
		ArrayToFile(BigOInput, Oddonacci_Arr, BigO_time, "MultipleOddonacci", "MultipleOddonacci.txt");
	}

	/**
	 * Runs the LinearTailRecursiveOddonacci method multiple times with different
	 * inputs and records the execution time.
	 *
	 * @param numRuns The number of runs to perform.
	 */
	public static void LinearTailRecursiveOddonacci_Run(int numRuns) {
		int increment = 5;
		int true_counter = 0;
		int Data_Precision = 10;
		int[] BigOInput = new int[(numRuns / increment) + 1];
		long[] BigO_time = new long[numRuns / increment + 1];
		BigInteger[] Oddonacci_Arr = new BigInteger[numRuns / increment + 1];

		for (int i = 0; i <= numRuns; i += increment, true_counter++) {
			System.gc();
			for (int j = 0; j < Data_Precision; j++) {
				long startTime = System.nanoTime();
				BigOInput[true_counter] = i;
				// Calculate Oddonacci number using the LinearTailRecursiveOddonacci function.
				Oddonacci_Arr[true_counter] = LinearTailRecursiveOddonacci(i, BigInteger.ONE, BigInteger.ONE,
						BigInteger.ONE);
				if (j == 0) {
					BigO_time[true_counter] = System.nanoTime() - startTime;
				} else {
					BigO_time[true_counter] = Math.min(BigO_time[true_counter], System.nanoTime() - startTime);
				}
			}
			System.out.println(Oddonacci_Arr[true_counter]);
		}
		// Save the results to a file.
		ArrayToFile(BigOInput, Oddonacci_Arr, BigO_time, "LinearTailRecursiveOddonacci", "LinearOddonacci.txt");
	}

	/**
	 * Performs a full test by calculating Oddonacci numbers for a range of inputs.
	 *
	 * @param numRuns The number of test runs to perform.
	 */
	private static void Full_Test(int numRuns) {
		System.out.println("____________-(LinearTailRecursiveOddonacci)-____________");

		for (int j = 1; j <= numRuns; j++) {
			System.out.println("i = " + j + " || "
					+ LinearTailRecursiveOddonacci(j, new BigInteger("0"), new BigInteger("0"), new BigInteger("0")));
		}

		System.out.println("____________-(MultipleOddonacci)-____________");

		for (int i = 1; i <= numRuns; i++) {
			System.gc();
			System.out.println(
					"i = " + i + " || " + MultipleOddonacci(i, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE));
		}
		System.out.println("____________--____________");
	}

	/**
	 * Computes the nth number in the Oddonacci sequence using a tail-recursive
	 * method. The function optimizes recursion by directly returning the result of
	 * the recursive call, improving memory usage.
	 *
	 * @param n Target position in the Oddonacci sequence.
	 * @param a (n-3)th number in the sequence during recursion.
	 * @param b (n-2)th number in the sequence during recursion.
	 * @param c (n-1)th number in the sequence during recursion.
	 * @return BigInteger representing the nth number in the Oddonacci sequence.
	 */
	public static BigInteger LinearTailRecursiveOddonacci(int n, BigInteger a, BigInteger b, BigInteger c)
			throws IllegalArgumentException {
		if (n < 0)
			throw new IllegalArgumentException();
		else if (n <= 3)
			return c;
		else
			return LinearTailRecursiveOddonacci(n - 1, b, c, a.add(b).add(c));
	}

	/**
	 * Calculates the nth number in the Oddonacci sequence using multiple recursion.
	 * Each call branches into three more recursive calls, creating a multi-layered
	 * recursive structure.
	 *
	 * @param n      Position in the Oddonacci sequence to compute.
	 * @param first  First number in the sequence during recursion.
	 * @param second Second number in the sequence during recursion.
	 * @param third  Third number in the sequence during recursion.
	 * @return BigInteger representing the nth number in the Oddonacci sequence.
	 */
	private static BigInteger MultipleOddonacci(int n, BigInteger first, BigInteger second, BigInteger third)
			throws IllegalArgumentException {
		// Handle base cases for the Oddonacci sequence
		if (n < 0) {
			throw new IllegalArgumentException();
		} else if (n <= 3)
			return new BigInteger("1");

		// Recursive calls for multiple recursion
		return MultipleOddonacci(n - 1, second, third, first.add(second).add(third))
				.add(MultipleOddonacci(n - 2, second, third, first.add(second).add(third)))
				.add(MultipleOddonacci(n - 3, second, third, first.add(second).add(third)));
	}

	/**
	 * Saves two arrays to a text file. Pairs of input and time are written on each
	 * line, separated by a comma.
	 *
	 * @param input    Array of input values.
	 * @param Data     Array of Oddonacci values.
	 * @param time     Array of execution times.
	 * @param FuncName Name of the function being tested.
	 * @param Path     File path to save the results.
	 */
	private static void ArrayToFile(int[] input, BigInteger[] Data, long[] time, String FuncName, String Path) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Path))) {
			writer.write("Function Input,value,Time\n"); // Write header line
			for (int i = 0; i < input.length && i < time.length; i++) {
				writer.write(FuncName + "(" + input[i] + ")" + "," + Data[i] + "," + time[i] + " ns" + "\n"); // Write
																												// //
																												// time
			}
		} catch (IOException e) {
			e.printStackTrace(); // Print the stack trace in case of an IOException
		}
	}

}