package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class RangeTest extends TestCase {
	
	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCentralValueShouldBeZero() {
	assertEquals("The central value of -1 and 1 should be 0",
	0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	@Test
	//from lab doc
	public void testGetLengthBothPositiveAndEqual() { 
	Range r1 = new Range(2, 2);
	assertEquals("getLength: Did not return the expected output", 0.0, r1.getLength());
	}
	
	@Test
	//from lab doc
	public void testGetLengthBothPositiveAndNotEqual() { 
	Range r2 = new Range(4, 9);
	assertEquals("getLength: Did not return the expected output", 5.0, r2.getLength());
	
	}
	
	@Test
	//from lab doc
	public void testGetLengthBothNegativeAndEqual() { 
	Range r3 = new Range(-99, -99);
	assertEquals("getLength: Did not return the expected output", 0.0, r3.getLength());
	}

	@Test
	//from lab doc
	public void testGetLengthBothNegativeAndNotEqual() { 
	Range r4 = new Range(-11, -4);
	assertEquals("getLength: Did not return the expected output", 7.0, r4.getLength());
	}
	
	@Test
	//from lab doc
	public void testGetLengthOnePositiveOneNegative() { 
	Range r5 = new Range(-5, 3);
	assertEquals("getLength: Did not return the expected output", 8.0, r5.getLength());
	}



}
