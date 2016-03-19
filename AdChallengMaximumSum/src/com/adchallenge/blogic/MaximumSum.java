package com.adchallenge.blogic;

/**
 * This class will find the maximim of the sum
 * 
 * @author hvanparx
 * 
 */
public class MaximumSum {

	/**
	 * This method will take input array as an input and it will print the
	 * output with the maximum of the sum
	 * 
	 * @param input
	 *            array wich contains the input
	 * @return it will return the sum of the elements,
	 */
	public int maximumSumExclAdjucent(int[] input) {
		/**
		 * if the length of the array will be zero then the method will return
		 * the -1 value.
		 */
		if (input.length <= 0) {
			return -1;
		}
		/**
		 * If the length of the input is one then the same element will provide
		 * the maximum sum.
		 */
		if (input.length == 1) {
			return input[0];
		}

		int maxSumIncElement = input[0];
		int maxSumExeElement = Integer.MIN_VALUE;

		/**
		 * Array starts form one , as for one element we return the value as the
		 * same number.
		 */
		for (int i = 1; i < input.length; i++) {
			int maximumSumExclTmp;
			if ((maxSumIncElement > maxSumExeElement)) {
				maximumSumExclTmp = maxSumIncElement;
			} else {
				maximumSumExclTmp = maxSumExeElement;
			}

			maxSumIncElement = maxSumExeElement + input[i];
			maxSumExeElement = maximumSumExclTmp;
			// System.out.println(i);
			// System.out.println("Inc" + maxSumIncElement);
			// System.out.println("Exec " + maxSumExeElement);
			// System.out.println("==========");
		}

		if (maxSumIncElement > maxSumExeElement) {
			return maxSumIncElement;
		} else {
			return maxSumExeElement;
		}
	}

	public static void main(String args[]) {
		int input[] = { 1, 2, 15, 1, 6, 8 };
		MaximumSum max = new MaximumSum();

		System.out.println(max.maximumSumExclAdjucent(input));
	}
}
