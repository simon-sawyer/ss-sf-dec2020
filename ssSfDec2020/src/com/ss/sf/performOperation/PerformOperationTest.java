package com.ss.sf.performOperation;

import static org.junit.Assert.*;

import org.junit.Test;

public class PerformOperationTest {

	@Test
	public void refOddTest() {
		assertEquals(true, new PerformOperation().refOdd().isOdd(11));
		assertEquals(false, new PerformOperation().refOdd().isOdd(92));
		assertEquals(true, new PerformOperation().refOdd().isOdd(35));
	}
	
	@Test
	public void refPrimeTest(){
		assertEquals(true, new PerformOperation().refPrime().isPrime(11));
		assertEquals(true, new PerformOperation().refPrime().isPrime(79));
		assertEquals(false, new PerformOperation().refPrime().isPrime(49));
	}

	@Test
	public void refPalindromeTest(){
		assertEquals(true, new PerformOperation().refPalindrome().isPalindrome(11));
		assertEquals(false, new PerformOperation().refPalindrome().isPalindrome(2341));
		assertEquals(true, new PerformOperation().refPalindrome().isPalindrome(5885));
	}
}
