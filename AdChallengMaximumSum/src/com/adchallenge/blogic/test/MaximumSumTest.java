package com.adchallenge.blogic.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.adchallenge.blogic.MaximumSum;

public class MaximumSumTest {

	MaximumSum maxSum = null;
	@Test
	public void setup(){
		maxSum = new MaximumSum();
	}
	
	public void trial(){
		int input[] = { 1, 2, 15, 1, 6, 8 };
		int maximumSumExclAdjucent = maxSum.maximumSumExclAdjucent(input);
		assertTrue(maximumSumExclAdjucent == 24);
	}
	
	public void oneElement(){
		int input[] = { 1 };
		int maximumSumExclAdjucent = maxSum.maximumSumExclAdjucent(input);
		assertTrue(maximumSumExclAdjucent == 1);
	}
	public void emptyElement(){
		int input[] = {  };
		int maximumSumExclAdjucent = maxSum.maximumSumExclAdjucent(input);
		assertTrue(maximumSumExclAdjucent == -1);
	}
}
