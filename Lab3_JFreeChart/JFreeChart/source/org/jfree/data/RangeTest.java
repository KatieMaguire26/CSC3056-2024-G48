package org.jfree.data;

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
	
	//BALCK BOX TESTING - LAB2
	
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
	
	//WHITE BOX TESTING - LAB3
	

	@Test 
	//intersects() TC34
    public void testIntersectsTrueIfLowerEqualsThisLower() {
        Range rangeObjectUnderTest = new Range(-1, 1);
        assertTrue(rangeObjectUnderTest.intersects(-1, 15));
    }

    @Test
    //intersects() TC35
    public void testIntersectsFalseIfLowerGreaterThanThisLower() {
        Range rangeObjectUnderTest = new Range(-1, 1);
        assertFalse(rangeObjectUnderTest.intersects(2, 9));
    }

    @Test
    //intersects() TC36
    public void testIntersectsTrueIfLowerLessThanThisLowerUpperLessThanThisUpper() {
        Range rangeObjectUnderTest = new Range(-1, 1);
        assertTrue(rangeObjectUnderTest.intersects(-2, 0));
    }

    @Test
    //intersects() TC37
    public void testIntersectsFalseIfLowerLessThanThisLowerUpperGreaterThanOrEqualToThisUpper() {
        Range rangeObjectUnderTest = new Range(-1, 1);
        assertFalse(rangeObjectUnderTest.intersects(-2, 1));
    }

    @Test
    //intersects() TC38
    public void testIntersectsTrueIfLowerLessThanThisLowerUpperGreaterThanThisLower() {
        Range rangeObjectUnderTest = new Range(-1, 1);
        assertTrue(rangeObjectUnderTest.intersects(-2, 0));
    }

    @Test
    //intersects() TC39
    public void testIntersectsTrueIfLowerGreaterThanThisLowerUpperLessThanThisUpper() {
        Range rangeObjectUnderTest = new Range(-1, 1);
        assertTrue(rangeObjectUnderTest.intersects(0, 1));
    }

    @Test
    //intersects() TC40
    public void testIntersectsFalseIfLowerGreaterThanThisLowerUpperGreaterThanOrEqualToThisUpper() {
        Range rangeObjectUnderTest = new Range(-1, 1);
        assertFalse(rangeObjectUnderTest.intersects(0, 1));
    }

    @Test
    //intersects() TC41
    public void testIntersectsFalseBoundaryLowerEqualsThisLowerUpperEqualsThisLower() {
        Range rangeObjectUnderTest = new Range(-1, 1);
        assertFalse(rangeObjectUnderTest.intersects(-1, -1));
    }

    @Test
    //intersects() TC42
    public void testIntersectsFalseBoundaryLowerEqualsThisUpperUpperEqualsThisUpper() {
        Range rangeObjectUnderTest = new Range(-1, 1);
        assertFalse(rangeObjectUnderTest.intersects(1, 1));
    }

    @Test
    //intersects() TC43
    public void testIntersectsTrueBoundaryLowerEqualsThisLowerUpperEqualsThisUpper() {
        Range rangeObjectUnderTest = new Range(-1, 1);
        assertTrue(rangeObjectUnderTest.intersects(-1, 1));
    }
    
    @Test
    //intersects() TC44
    public void testIntersectsTrueIfUpperLessThanThisUpperUpperGreaterThanOrEqualToLower() {
        Range rangeObjectUnderTest = new Range(-1, 1);
        assertTrue(rangeObjectUnderTest.intersects(-2, 0));
    }

    @Test
    //intersects() TC45
    public void testIntersectsFalseIfUpperGreaterThanOrEqualToThisUpper() {
        Range rangeObjectUnderTest = new Range(-1, 1);
        assertFalse(rangeObjectUnderTest.intersects(-2, 2));
    }
    
    @Test
    //intersects() TC46
    public void testIntersectsFalseIfLowerEqualToThisLowerUpperEqualToThisUpper() {
        Range rangeObjectUnderTest = new Range(-1, 1);
        assertTrue(rangeObjectUnderTest.intersects(-1, 1));
    }

    @Test
    //expandToInclude() TC47
    public void testExpandToIncludeLessThanLowerBound() {
        Range rangeObjectUnderTest = new Range(0, 10);
        Range result = Range.expandToInclude(rangeObjectUnderTest, -5.0);
        assertEquals(new Range(-5.0, 10.0), result);
    }

    @Test
    //expandToInclude() TC48
    public void testExpandToIncludeGreaterThanUpperBound() {
        Range rangeObjectUnderTest = new Range(0, 10);
        Range result = Range.expandToInclude(rangeObjectUnderTest, 15.0);
        assertEquals(new Range(0.0, 15.0), result);
    }

    @Test
    //expandToInclude() TC49
    public void testExpandToIncludeWithinRange() {
        Range rangeObjectUnderTest = new Range(0, 10);
        Range result = Range.expandToInclude(rangeObjectUnderTest, 5.0);
        assertEquals(rangeObjectUnderTest, result);
    }
    @Test
    //expandToInclude() TC50
    public void testExpandToIncludeNullRange() {
        Range result = Range.expandToInclude(null, 5.0);
        assertEquals(new Range(5.0, 5.0), result);
    }

    @Test
    //range() TC53
    public void testRangeValid() {
        Range rangeObjectUnderTest = new Range(0, 10);
        assertEquals(0.0, rangeObjectUnderTest.getLowerBound(), 0.0);
        assertEquals(10.0, rangeObjectUnderTest.getUpperBound(), 0.0);
    }

    @Test
    //range() TC54
    public void testRangeSameBounds() {
        Range rangeObjectUnderTest = new Range(5, 5);
        assertEquals(5.0, rangeObjectUnderTest.getLowerBound(), 0.0);
        assertEquals(5.0, rangeObjectUnderTest.getUpperBound(), 0.0);
    }
    
    
    @Test
    //getLength() TC55
    public void testGetLengthPositive() {
        Range rangeObjectUnderTest = new Range(0, 10);
        assertEquals(10.0, rangeObjectUnderTest.getLength(), 0.0);
    }

    @Test
    //getLength() TC56
    public void testGetLengthZeroLength() {
        Range rangeObjectUnderTest = new Range(5, 5);
        assertEquals(0.0, rangeObjectUnderTest.getLength(), 0.0);
    }

    @Test
    //getLength() TC57
    public void testGetLengthWithNegative() {
        Range rangeObjectUnderTest = new Range(-5, 5);
        assertEquals(10.0, rangeObjectUnderTest.getLength(), 0.0);
    }

    @Test
    //getLength() TC58
    public void testGetLengthLowerNegative() {
        Range rangeObjectUnderTest = new Range(-10, 10);
        assertEquals(20.0, rangeObjectUnderTest.getLength(), 0.0);
    }

    @Test
    //getLength() TC59
    public void testGetLengthUpperNegative() {
    	try {
        Range rangeObjectUnderTest = new Range(10, -10); 
        assertEquals(20.0, rangeObjectUnderTest.getLength(), 0.0);
    	} catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    //getCentralValue() TC60
    public void testGetCentralValuePositive() {
        Range rangeObjectUnderTest = new Range(0, 10);
        assertEquals(5.0, rangeObjectUnderTest.getCentralValue(), 0.0);
    }
    @Test
    //getCentralValue() TC61
      public void testGetCentralValueNegative() {
          Range rangeObjectUnderTest = new Range(-5, 5);
          assertEquals(0.0, rangeObjectUnderTest.getCentralValue(), 0.0);
      }

    @Test
    //getCentralValue() TC62
    public void testGetCentralValueZeroLength() {
        Range rangeObjectUnderTest = new Range(5, 5);
        assertEquals(5.0, rangeObjectUnderTest.getCentralValue(), 0.0);
    }


    @Test
    //getCentralValue() TC63
    public void testGetCentralValueWithNegativeLowerBound() {
        Range rangeObjectUnderTest = new Range(-10, 10);
        assertEquals(0.0, rangeObjectUnderTest.getCentralValue(), 0.0);
    }

    @Test
    //getCentralValue() TC64
    public void testGetCentralValueWithNegativeUpperBound() {
    	try {
        Range rangeObjectUnderTest = new Range(10, -10);
        assertEquals(0.0, rangeObjectUnderTest.getCentralValue(), 0.0);
    	} catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    } 
    
    @Test
    //expand() TC65
    public void testExpandValid() {
        Range rangeObjectUnderTest = new Range(0, 10);
        Range result = Range.expand(rangeObjectUnderTest, 0.1, 0.2);
        assertEquals(new Range(-1.0, 13.0), result);
    }

    @Test
    //expand() TC66
    public void testExpandNull() {
    	try {
        Range result = Range.expand(null, 0.1, 0.2); 
    	} catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    //expand() TC67
    public void testExpandZero() {
        Range rangeObjectUnderTest = new Range(0, 10);
        Range result = Range.expand(rangeObjectUnderTest, 0.0, 0.0);
        assertEquals(rangeObjectUnderTest, result);
    }

    @Test
    //expand() TC68
    public void testExpandNegative() {
        Range rangeObjectUnderTest = new Range(0, 10);
        Range result = Range.expand(rangeObjectUnderTest, -0.1, -0.2);
        assertEquals(new Range(1.0, 9.0), result);
    }

    @Test
    //expand() TC69
    public void testExpandGreaterThanOne() {
        Range rangeObjectUnderTest = new Range(0, 10);
        Range result = Range.expand(rangeObjectUnderTest, 1.0, 2.0);
        assertEquals(new Range(-10.0, 30.0), result);
    }
    
    

    @Test
    //shift() TC70
    public void testShiftWithNullRange() {
    	try {
        Range result = Range.shift(null, 5.0);
        assertNull(result);
    	} catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    //shift() TC71
    public void testShiftPositiveDeltaAllowZeroCrossingTrue() {
        Range rangeObjectUnderTest = new Range(0, 10);
        Range result = Range.shift(rangeObjectUnderTest, 5.0, true);
        assertEquals(new Range(5.0, 15.0), result);
    }

    @Test
    //shift() TC72
    public void testShiftNegativeDeltaAllowZeroCrossingTrue() {
        Range rangeObjectUnderTest = new Range(0, 10);
        Range result = Range.shift(rangeObjectUnderTest, -5.0, true);
        assertEquals(new Range(-5.0, 5.0), result);
    }

    @Test
    //shift() TC73
    public void testShiftZeroDeltaAllowZeroCrossingTrue() {
        Range rangeObjectUnderTest = new Range(0, 10);
        Range result = Range.shift(rangeObjectUnderTest, 0.0, true);
        assertEquals(rangeObjectUnderTest, result);
    }

    @Test
    //shift() TC74
    public void testShiftNullRangeAllowZeroCrossingTrue() {
    	try {
        Range result = Range.shift(null, 5.0, true);
        assertNull(result);
    	} catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    //shift() TC75
    public void testShiftPositiveDeltaAllowZeroCrossingFalse() {
        Range rangeObjectUnderTest = new Range(0, 10);
        Range result = Range.shift(rangeObjectUnderTest, 5.0, false);
        assertEquals(new Range(5.0, 15.0), result);
    }

    @Test
    //shift() TC76
    public void testShiftNegativeDeltaAllowZeroCrossingFalse() {
        Range rangeObjectUnderTest = new Range(0, 10);
        Range result = Range.shift(rangeObjectUnderTest, -5.0, false);
        assertEquals(new Range(0.0, 10.0), result);
    }

    @Test
    //shift() TC77
    public void testShiftZeroDeltaAllowZeroCrossingFalse() {
        Range rangeObjectUnderTest = new Range(0, 10);
        Range result = Range.shift(rangeObjectUnderTest, 0.0, false);
        assertEquals(rangeObjectUnderTest, result);
    }

   @Test
   //shift() TC78
    public void testShiftWithNullRangeAllowZeroCrossingFalse() {
	   try {
       Range result = Range.shift(null, 5.0, false);
        assertNull(result);
	   } catch (Exception e) {
           fail("Exception thrown: " + e.getMessage());
       }
   }
    
    @Test
    //equals() TC79
    public void testEqualsSameRange() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(0, 10);
        assertTrue(range1.equals(range2));
    }

    @Test
    //equals() TC80
    public void testEqualsDifferentRanges() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(5, 15);
        assertFalse(range1.equals(range2));
    }

    @Test
    //equals() TC81
    public void testEqualsDifferentLoweR() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(5, 10);
        assertFalse(range1.equals(range2));
    }

    @Test
    //equals() TC82
    public void testEqualsDifferentUpper() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(0, 15);
        assertFalse(range1.equals(range2));
    }

    @Test
    //equals() TC83
    public void testEqualsNull() {
        Range range = new Range(0, 10);
        assertFalse(range.equals(null));
    }
    
    @Test
    //hashCode()TC84
    public void testHashCodeSameRange() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(0, 10);
        assertEquals(range1.hashCode(), range2.hashCode());
    }

    @Test
    //hashCode()TC85
    public void testHashCodeDifferentRanges() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(5, 15);
        assertNotEquals(range1.hashCode(), range2.hashCode());
    }

    @Test
    //hashCode()TC86
    public void testHashCodeDifferentLower() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(5, 10);
        assertNotEquals(range1.hashCode(), range2.hashCode());
    }

    @Test
    //hashCode()TC87
    public void testHashCodeDifferentUpper() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(0, 15);
        assertNotEquals(range1.hashCode(), range2.hashCode());
    }







}
