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
    // Combine() TC1
    public void testCombineBothValuesAreValid() {
		try {
		Range range1 = new Range(-1, 6);
        Range range2 = new Range(10, 20);
        Range combinedRange = Range.combine(range1, range2);
        
        assertNotNull(combinedRange); 
        assertEquals(-1.0, combinedRange.getLowerBound(), 0.0001); 
        assertEquals(20.0, combinedRange.getUpperBound(), 0.0001); 
		} catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    
    
	@Test
	//Combine() TC2, TC6
    public void testCombineRange1NullRange2Valid() {
        Range range1 = null; 
        Range range2 = new Range(10, 20); 
        Range combinedRange = Range.combine(range1, range2);
        
        assertNotNull("Combined range should not be null", combinedRange);
        assertEquals("Combined range should be equal to range2", range2, combinedRange);
    }
	@Test
	//Combine() TC3, TC7
    public void testCombineRange1ValidRange2Null() {
        Range range1 = new Range(-1, 6);
        Range range2 = null; 
        Range combinedRange = Range.combine(range1, range2);
        
        assertNotNull("Combined range should not be null", combinedRange);
        assertEquals("Combined range should be equal to range1", range1, combinedRange);
    }
	@Test
	//Combine() TC4, TC5
    public void testCombineRange1NullRange2Null() {
        Range range1 = null;
        Range range2 = null; 
        Range combinedRange = Range.combine(range1, range2);
        
        assertNull("Combined range should be null", combinedRange);
    }
	 @Test
	 //Combine() TC8
	    public void testCombineNotOverlapping() {
		 try {
	        Range range1 = new Range(-1, 6); 
	        Range range2 = new Range(10, 20); 
	        Range combinedRange = Range.combine(range1, range2);
	        
	        assertNull("Combined range should be null", combinedRange);
		 } catch (Exception e) {
	            fail("Exception thrown: " + e.getMessage());
	        }
	    } 
	@Test
	//Combine() TC9
	public void testCombineSameRange() {
        Range range1 = new Range(-1, 6); 
        Range range2 = new Range(-1, 6); 
        Range combinedRange = Range.combine(range1, range2);
        
        assertNotNull("Combined range should not be null", combinedRange);
        assertEquals("Combined range should be from -1 to 6", new Range(-1, 6), combinedRange);
    
	}  
	@Test
	//Combine() TC10
	public void testCombinePartiallyOverlapping() {
		try {
        Range range1 = new Range(-1, 6); 
        Range range2 = new Range(4, 9); 
        Range combinedRange = Range.combine(range1, range2);
        
        assertNotNull("Combined range should not be null", combinedRange);
        assertEquals("Combined range should be from -1 to 9", new Range(-1, 9), combinedRange);
		} catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    
	} 
	@Test
	//Combine() TC11
	public void testCombineBoundary() {
		try {
        Range range1 = new Range(-1, 6); 
        Range range2 = new Range(6, 10); 
        Range combinedRange = Range.combine(range1, range2);
        
        assertNotNull("Combined range should not be null", combinedRange);
        assertEquals("Combined range should be from -1 to 10", new Range(-1, 10), combinedRange);
		} catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    
	} 
	@Test
	//Combine() TC12
	public void testCombineEcompassed() {
		try {
        Range range1 = new Range(0, 10); 
        Range range2 = new Range(2, 5); 
        Range combinedRange = Range.combine(range1, range2);
        
        assertNotNull("Combined range should not be null", combinedRange);
        assertEquals("Combined range should be from 0 to 10", new Range(0, 10), combinedRange);
		} catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    
	}
	@Test
	//Constrain() TC13, TC18
	public void testConstrainInsideRange() {
	    Range range1 = new Range(-1, 6); 
	    double constrainedValue = range1.constrain(3.0); 
	    
	    assertEquals(3.0, constrainedValue, 0.0); 
	}
	@Test
	//Constrain() TC14, TC19
	public void testConstrainOutsideRangeRight() {
	    Range range1 = new Range(-1, 6); 
	    double constrainedValue = range1.constrain(20.0); 
	    
	    assertEquals(6.0, constrainedValue, 0.0); 
	}
	@Test
	//Constrain() TC15, TC20
	public void testConstrainOutsideRangeLeft() {
	    Range range1 = new Range(-1, 6); 
	    double constrainedValue = range1.constrain(-10.0); 
	    
	    assertEquals(-1.0, constrainedValue, 0.0); 
	}
	@Test
	//Constrain() TC16, TC21
	public void testConstrainBorderRight() {
	    Range range1 = new Range(-1, 6); 
	    double constrainedValue = range1.constrain(6.0); 
	    
	    assertEquals(6.0, constrainedValue, 0.0); 
	}
	@Test
	//Constrain() TC17, TC24
	public void testConstrainBorderLeft() {
	    Range range1 = new Range(-1, 6); 
	    double constrainedValue = range1.constrain(-1.0); 
	    
	    assertEquals(-1.0, constrainedValue, 0.0); 
	}
	@Test
	//Constrain() TC22
	public void testConstrainBorderRightPlusOne() {
	    Range range1 = new Range(-1, 6); 
	    double constrainedValue = range1.constrain(7.0); 
	    
	    assertEquals(6.0, constrainedValue, 0.0); 
	}
	@Test
	//Constrain() TC23
	public void testConstrainBorderRightMinusOne() {
	    Range range1 = new Range(-1, 6); 
	    double constrainedValue = range1.constrain(5.0); 
	    
	    assertEquals(6.0, constrainedValue, 0.0); 
	}
	@Test
	//Constrain() TC25
	public void testConstrainBorderLeftPlusOne() {
	    Range range1 = new Range(-1, 6); 
	    double constrainedValue = range1.constrain(0.0); 
	    
	    assertEquals(-1.0, constrainedValue, 0.0); 
	}
	@Test
	//Constrain() TC26
	public void testConstrainBorderLeftMinusOne() {
	    Range range1 = new Range(-1, 6); 
	    double constrainedValue = range1.constrain(-2.0); 
	    
	    assertEquals(-1.0, constrainedValue, 0.0); 
	}
	@Test
	//getLowerBound() TC27, TC28
	public void testgetLowerBoundWithinRange() {
	    Range range1 = new Range(-1, 6);
	    double lowerBound = -1.0;
	    double result = range1.getLowerBound(); 
	    
	    assertEquals(lowerBound, result, 0.0);
	}
	@Test
	//getUpperBound() TC29, TC30
	public void testgetUpperBoundWithinRange() {
	    Range range1 = new Range(-1, 6);
	    double upperBound = 6.0;
	    double result = range1.getUpperBound();
	    
	    assertEquals(upperBound, result, 0.0);
	}
	@Test
	//toString()TC31, TC33
    public void testToStringValid() {
        Range range = new Range(-1, 6);
        assertEquals("Range[-1,6]", range.toString());
    }
	@Test
	//toString() TC32
    public void testToStringWithNullRange() {
		try {
        Range range = null;
        range.toString(); 
		} catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }






}
