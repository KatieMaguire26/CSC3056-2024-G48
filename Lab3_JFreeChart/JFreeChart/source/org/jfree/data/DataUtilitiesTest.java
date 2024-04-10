package org.jfree.data;
import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest {
    private Values2D values2D;

    @Before
    public void setUp() {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
        values2D = testValues;
        testValues.addValue(1, 0, 0);
        testValues.addValue(4, 1, 0);
    }

    @After
    public void tearDown() {
        values2D = null;
    }

    
    

    
    @Test
    // TC 1: Valid (Not-null) data and valid column index
    public void testCalculateColumnTotal_ValidDataAndColumn() {
        assertEquals("Incorrect sum for valid data and column", 5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
    }

   
    
    @Test
    // TC 2: Null data and valid column index
    public void testCalculateColumnTotal_NullData() {
        try {
            // Create a Values2D object with null data
            Values2D data = null;
            DataUtilities.calculateColumnTotal(data, 0);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // The exception is expected, so the test should pass
            assertTrue(true);
        } catch (Exception e) {
            // Unexpected exception, fail the test
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    // TC 3: Valid (Not-null) data and invalid column index
    public void testCalculateColumnTotal_InvalidColumn() {
        try {
            DataUtilities.calculateColumnTotal(values2D, -1);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
 // TC 4: Null data and invalid column index
 public void testCalculateColumnTotal_NullDataAndInvalidColumn() {
     try {
         DataUtilities.calculateColumnTotal(null, -1);
         fail("Expected IllegalArgumentException was not thrown");
     } catch (IllegalArgumentException e) {
         assertTrue(true);
     } catch (Exception e) {
         fail("Unexpected exception: " + e.getMessage());
     }
 }
        
        

    
    //Boundary Value Analysis Tests
    
    @Test
    // TC 5: Sum of values in the first column
    public void testCalculateColumnTotal_ValidFirstColumn() {
        int column = 0;
        double expected = 5.0; 
        assertEquals(expected, DataUtilities.calculateColumnTotal(values2D, column), 0.0001);
    }

    @Test
    // TC 6: Sum of values in the last column
    public void testCalculateColumnTotal_ValidLastColumn() {
        int column = values2D.getColumnCount() - 1;
        double expected = 7.0; 
        assertEquals(expected, DataUtilities.calculateColumnTotal(values2D, column), 0.0001);
    }

    

    @Test
 // TC 7: Null data
 public void testCalculateColumnTotal_NullData1() {
     try {
         values2D = null;
         int column = 0;
         DataUtilities.calculateColumnTotal(values2D, column);
         fail("Expected IllegalArgumentException was not thrown");
     } catch (IllegalArgumentException e) {
         assertTrue(true);
     } catch (Exception e) {
         fail("Unexpected exception: " + e.getMessage());
     }
 }

 @Test
 // TC 8: Negative column index
 public void testCalculateColumnTotal_NegativeColumnIndex() {
     try {
         int column = -1; 
         DataUtilities.calculateColumnTotal(values2D, column);
         fail("Expected IllegalArgumentException was not thrown");
     } catch (IllegalArgumentException e) {
         assertTrue(true);
     } catch (Exception e) {
         fail("Unexpected exception: " + e.getMessage());
     }
 }

 @Test
 // TC 9: Out of bounds column index
 public void testCalculateColumnTotal_OutOfBoundsColumnIndex() {
     try {
         int column = values2D.getColumnCount(); 
         DataUtilities.calculateColumnTotal(values2D, column);
         fail("Expected IllegalArgumentException was not thrown");
     } catch (IllegalArgumentException e) {
         assertTrue(true);
     } catch (Exception e) {
         fail("Unexpected exception: " + e.getMessage());
     }
 }

    
    @Test
    // Test case 10: Valid (Not-null) data and valid row index
    public void testCalculateRowTotal_ValidDataAndRow() {
        assertEquals("Incorrect sum for valid data and row", 1.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
    }

    
    
  @Test
 // Test case 11: Null data and valid row index
 public void testCalculateRowTotal_NullData() {
     try {
         DataUtilities.calculateRowTotal(null, 0);
         fail("Expected IllegalArgumentException was not thrown");
     } catch (IllegalArgumentException e) {
         assertTrue(true);
     } catch (Exception e) {
         fail("Unexpected exception: " + e.getMessage());
     }
 }

 @Test
 // Test case 12: Valid (Not-null) data and invalid row index
 public void testCalculateRowTotal_InvalidRow() {
     try {
         DataUtilities.calculateRowTotal(values2D, -1);
         fail("Expected IllegalArgumentException was not thrown");
     } catch (IllegalArgumentException e) {
         assertTrue(true);
     } catch (Exception e) {
         fail("Unexpected exception: " + e.getMessage());
     }
 }

 @Test
 // Test case 13: Null data and invalid row index
 public void testCalculateRowTotal_NullDataAndInvalidRow() {
     try {
         DataUtilities.calculateRowTotal(null, -1);
         fail("Expected IllegalArgumentException was not thrown");
     } catch (IllegalArgumentException e) {
         assertTrue(true);
     } catch (Exception e) {
         fail("Unexpected exception: " + e.getMessage());
     }
 }

    
    
    //Boundary Value Analysis Tests
    
 // TC14: Valid (Non-null, 1+ rows, 1+ columns), column index = 0
    @Test
    public void testCalculateRowTotal_FirstRow() {
        assertEquals("Sum of values in first row should be 1", 1.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
    }

    // TC15: Valid (Non-null, 1+ rows, 1+ columns), column index = numRows - 1
    @Test
    public void testCalculateRowTotal_LastRow() {
        assertEquals("Sum of values in last row should be 4", 4.0, DataUtilities.calculateRowTotal(values2D, values2D.getRowCount() - 1), 0.0000001d);
    }

    
    
    
    @Test
 // TC17: Valid (Non-null, 1+ rows, 1+ columns), invalid column index = -1
 public void testCalculateRowTotal_InvalidRowIndex_Negative() {
     try {
         DataUtilities.calculateRowTotal(values2D, -1);
         fail("Expected IllegalArgumentException was not thrown");
     } catch (IllegalArgumentException e) {
         assertTrue(true);
     } catch (Exception e) {
         fail("Unexpected exception: " + e.getMessage());
     }
 }

 @Test
 // TC18: Valid (Non-null, 1+ rows, 1+ columns), invalid column index = numRows
 public void testCalculateRowTotal_InvalidRowIndex_OutOfBounds() {
     try {
         DataUtilities.calculateRowTotal(values2D, values2D.getRowCount());
         fail("Expected IllegalArgumentException was not thrown");
     } catch (IllegalArgumentException e) {
         assertTrue(true);
     } catch (Exception e) {
         fail("Unexpected exception: " + e.getMessage());
     }
 }


    @Test
    /*createNumberArray Function Valid 
     * TC 19
     */
    public void testCreateNumberArray() {
        double[] data = {1.0, 2.0, 3.0, 4.0, 5.0};
        Number[] result = DataUtilities.createNumberArray(data);
        assertNotNull("Resulting array should not be null", result);
        assertEquals("Resulting array length should match input data", data.length, result.length);
        // Add assertions to check the contents of the resulting array
        for (int i = 0; i < data.length; i++) {
            assertEquals("Element at index " + i + " does not match", data[i], result[i].doubleValue(), 0.0);
        }
    }

 // TC19, TC21: Valid (Not-null, 1+ elements)
    @Test
    public void testCreateNumberArray_ValidData() {
        double[] data = {1.0, 2.0, 3.0, 4.0, 5.0};
        Number[] result = DataUtilities.createNumberArray(data);

        assertNotNull("Resulting array should not be null", result);
        assertEquals("Resulting array length should match input data", data.length, result.length);

        // Verify that each element in the result array corresponds to the same value as in the data array
        for (int i = 0; i < data.length; i++) {
            assertEquals("Element at index " + i + " does not match", data[i], result[i].doubleValue(), 0.0);
        }
    }

    @Test
 // TC20, TC22: Null data
 public void testCreateNumberArray_NullData() {
     try {
         DataUtilities.createNumberArray(null);
         fail("Expected IllegalArgumentException was not thrown");
     } catch (IllegalArgumentException e) {
         assertTrue(true);
     } catch (Exception e) {
         fail("Unexpected exception: " + e.getMessage());
     }
 }

    
    
    
 // TC23, TC25: Valid (Not-null, 1+ elements)
    @Test
    public void testCreateNumberArray2D_ValidData() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0},
            {7.0, 8.0, 9.0}
        };
        Number[][] result = DataUtilities.createNumberArray2D(data);

        assertNotNull("Resulting array should not be null", result);
        assertEquals("Resulting array length should match input data", data.length, result.length);

        // Verify that each element in the result array corresponds to the same value as in the data array
        for (int i = 0; i < data.length; i++) {
            assertEquals("Inner array length should match input data", data[i].length, result[i].length);
            for (int j = 0; j < data[i].length; j++) {
                assertEquals("Element at index [" + i + "][" + j + "] does not match", 
                             data[i][j], result[i][j].doubleValue(), 0.0);
            }
        }
    }

    @Test
 // TC24, TC26: Null data
 public void testCreateNumberArray2D_NullData() {
     try {
         DataUtilities.createNumberArray2D(null);
         fail("Expected IllegalArgumentException was not thrown");
     } catch (IllegalArgumentException e) {
         assertTrue(true);
     } catch (Exception e) {
         fail("Unexpected exception: " + e.getMessage());
     }
 }

    

    // TC27, TC29: Valid (Not-null)
    @Test
    public void testGetCumulativePercentages_ValidData() {
        DefaultKeyedValues keyvalues = new DefaultKeyedValues();
        keyvalues.addValue((Comparable)0.0, 5.0);
        keyvalues.addValue((Comparable)1.0, 9.0);
        keyvalues.addValue((Comparable)2.0, 2.0);

        KeyedValues result = DataUtilities.getCumulativePercentages(keyvalues);

        assertNotNull("Resulting KeyedValues should not be null", result);
        assertEquals("Cumulative percentage for key 0 should be 0.3125", 0.3125, result.getValue(0).doubleValue(), 0.0000001d);
        assertEquals("Cumulative percentage for key 1 should be 0.875", 0.875, result.getValue(1).doubleValue(), 0.0000001d);
        assertEquals("Cumulative percentage for key 2 should be 1.0", 1.0, result.getValue(2).doubleValue(), 0.0000001d);
    }

    // TC28, TC30: Invalid (Null)
    @Test(expected = IllegalArgumentException.class)
    public void testGetCumulativePercentages_NullData() {
        DataUtilities.getCumulativePercentages(null);
    }
    
    
    //TC31
    @Test 
    public void testCalculateColumnTotal_ValidDataWithNonNullValues() {
        try {            
            DefaultKeyedValues2D data = new DefaultKeyedValues2D();
            data.addValue(0, 0, 10); 
            data.addValue(1, 0, 20);            
            double total = DataUtilities.calculateColumnTotal(data, 0);            
            assertEquals(30.0, total, 0.001); 
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    //TC32
    @Test
    public void testCalculateColumnTotal_NullData11() {
        try {            
            double total = DataUtilities.calculateColumnTotal(null, 0);            
            assertEquals(0.0, total, 0.001);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    //TC33
    @Test
    public void testCalculateColumnTotal_InvalidColumnIndex() {
        try {            
            DefaultKeyedValues2D data = new DefaultKeyedValues2D();
            data.addValue(0, 0, 10);            
            double total = DataUtilities.calculateColumnTotal(data, -1);            
            assertEquals(0.0, total, 0.001);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    //TC34
    @Test
    public void testCalculateColumnTotal_DataWithNullValues() {
        try {            
            DefaultKeyedValues2D data = new DefaultKeyedValues2D();
            data.addValue(0, 0, 10); 
            data.addValue(1, 0, null);           
            double total = DataUtilities.calculateColumnTotal(data, 0);            
            assertEquals(10.0, total, 0.001);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    //TC35
    @Test
    public void testCalculateColumnTotal_WithNullValue() {
        try {            
            DefaultKeyedValues2D data = new DefaultKeyedValues2D();
            data.addValue(0, 0, null);            
            double total = DataUtilities.calculateColumnTotal(data, 0);            
            assertEquals(0.0, total, 0.001);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }



    
    //TC36
    @Test
    public void testCalculateRowTotal_ValidDataWithNonNullValues() {
        try {           
            DefaultKeyedValues2D data = new DefaultKeyedValues2D();
            data.addValue(0, 0, 10); 
            data.addValue(0, 1, 20);             
            double total = DataUtilities.calculateRowTotal(data, 0);            
            assertEquals(30.0, total, 0.001); 
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    
    //TC37
    @Test
    public void testCalculateRowTotalNullData() {
        try {          
            double total = DataUtilities.calculateRowTotal(null, 0);            
            assertEquals(0.0, total, 0.001);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    
    //TC38
    @Test
    public void testCalculateRowTotal_InvalidRowIndex() {
        try {            
            DefaultKeyedValues2D data = new DefaultKeyedValues2D();
            data.addValue(0, 0, 10);             
            double total = DataUtilities.calculateRowTotal(data, -1);            
            assertEquals(0.0, total, 0.001);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    
    //TC39
    @Test
    public void testCalculateRowTotal_DataWithNullValues() {
        try {          
            DefaultKeyedValues2D data = new DefaultKeyedValues2D();
            data.addValue(0, 0, 10); 
            data.addValue(0, 1, null); 
            double total = DataUtilities.calculateRowTotal(data, 0);
            assertEquals(10.0, total, 0.001);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    
    //TC40
    @Test
    public void testCalculateRowTotal_WithNullValue() {
        try {
            DefaultKeyedValues2D data = new DefaultKeyedValues2D();
            data.addValue(0, 0, null); 
            double total = DataUtilities.calculateRowTotal(data, 0);
            assertEquals(0.0, total, 0.001);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    
}
 





