package com.adchallenge.blogic.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.adchallenge.blogic.MaximumSum;

public class MaximumSumTest {

	MaximumSum maxSum = null;
	@Before
	public void setup(){
		maxSum = new MaximumSum();
	}
	
	@Test
	public void trial(){
		int input[] = { 1, 2, 15, 1, 6, 8 };
		int maximumSumExclAdjucent = maxSum.maximumSumExclAdjucent(input);
		assertTrue(maximumSumExclAdjucent == 22);
	}
	
	@Test
	public void oneElement(){
		int input[] = { 1 };
		int maximumSumExclAdjucent = maxSum.maximumSumExclAdjucent(input);
		assertTrue(maximumSumExclAdjucent == 1);
	}
	@Test
	public void emptyElement(){
		int input[] = { -1,-3 };
		int maximumSumExclAdjucent = maxSum.maximumSumExclAdjucent(input);
		System.out.println(maximumSumExclAdjucent);
		assertTrue(maximumSumExclAdjucent == -1);
	}
}
