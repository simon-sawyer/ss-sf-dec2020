package com.ss.sf.line;

import static org.junit.Assert.*;

import org.junit.Test;

public class LineTest {
	Line test1 = new Line(1,2,5,2);
	Line test2 = new Line(3, 3, 6, 3);
	Line test3 = new Line(1, 2, 3, 4);
	
	@Test
	public void getSlopeTest(){
		assertEquals(0.0, test1.getSlope(), .0001);
		assertEquals(0.0, test2.getSlope(), .0001);
		assertEquals(1.0, test3.getSlope(), .0001);
		assertNotEquals(2.0, test3.getSlope(), .0001);
	}
	@Test
	public void getDistanceTest(){
		assertEquals(4.0, test1.getDistance(), .0001);
		assertEquals(3.0, test2.getDistance(), .0001);
		assertEquals(2.828427, test3.getDistance(), .0001);
		assertNotEquals(4.0, test2.getDistance(), .0001);
	}
	@Test
	public void getParallelToTest(){
		assertEquals(true, test1.parallelTo(test2));
		assertEquals(true, test2.parallelTo(test1));
		assertNotEquals(true, test3.parallelTo(test2));
		assertEquals(false, test3.parallelTo(test1));
		assertEquals(true, test3.parallelTo(test3));		
	}
}
