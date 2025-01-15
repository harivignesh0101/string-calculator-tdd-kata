package com.harivignesh;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StringCalculatorTest {

    /**
     * Test case for an empty string input.
     * Ensures that the add() method returns 0 for an empty string.
     */
    @Test
    public void testEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""), "Empty string should return 0");
    }

    /**
     * Test case for a single number input.
     * Verifies that the add() method returns the number itself
     * when a single number is provided as input.
     */
    @Test
    public void testSingleNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"), "Single number should return the number itself");
        assertEquals(5, calculator.add("5"), "Single number should return the number itself");
    }

    /**
     * Test case for adding two numbers.
     * Verifies that the add() method correctly returns the sum
     * of two numbers provided as a comma-separated string.
     */
    @Test
    public void testTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"), "Two numbers should return their sum");
        assertEquals(7, calculator.add("3,4"), "Two numbers should return their sum");
    }

    /**
     * Test case for adding an unknown number of numbers.
     * Verifies that the add() method correctly returns the sum
     * of multiple numbers provided as a comma-separated string.
     */
    @Test
    public void testUnknownNumberOfNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1,2,3"), "Sum of unknown number of numbers should be correct");
        assertEquals(10, calculator.add("1,2,3,4"), "Sum of unknown number of numbers should be correct");
        assertEquals(32, calculator.add("1,2,3,5,10,11"), "Sum of unknown number of numbers should be correct");
    }

    /**
     * Test case for handling new line delimiters in the input string.
     * Verifies that the add() method correctly interprets new lines
     * as valid delimiters alongside commas, ensuring the sum is calculated
     * accurately for inputs with mixed delimiters.
     */
    @Test
    public void testNewLineDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"), "New line as delimiter should work");
        assertEquals(10, calculator.add("1,2\n3,4"), "Mix of commas and new lines should work");
    }

    /**
     * Test case for handling custom delimiters in the input string.
     * Verifies that the add() method correctly interprets custom delimiters
     * specified in the format "//[delimiter]\n[numbers...]", ensuring the sum
     * is calculated accurately for inputs with custom delimiters.
     */
    @Test
    public void testCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"), "Custom delimiter should work");
        assertEquals(6, calculator.add("//|\n1|2|3"), "Custom delimiter should work");
    }

    @Test
    public void testCustomDelimiterWithAsterix() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(24, calculator.add("//*\n1*2*3*4"), "Custom delimiter should work");
        assertEquals(24, calculator.add("//[*]\n1*2*3*4"), "Custom delimiter should work");
    }

    /**
     * Test case for handling negative numbers in the input string.
     * Verifies that the add() method throws an IllegalArgumentException
     * with the correct message when negative numbers are included in the input.
     */
    @Test
    public void testNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        try {
            assertNotEquals(1, calculator.add("-1,2"), "Negative sums must not work");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed: [-1]", e.getMessage());
        }
        try {
            calculator.add("2,-4,3,-5");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed: [-4, -5]", e.getMessage());
        }
    }

    /**
     * Test case for ignoring numbers greater than 1000 in the input string.
     * Verifies that the add() method correctly excludes numbers greater than 1000
     * from the sum, while including numbers equal to or less than 1000.
     */
    @Test
    public void testIgnoreNumbersGreaterThan1000() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(2, calculator.add("1001,2"), "Numbers greater than 1000 should be ignored");
        assertEquals(1002, calculator.add("1000,2"), "Number 1000 should be included in the sum");
    }

    /**
     * Test case for handling custom delimiters of any length in the input string.
     * Verifies that the add() method correctly interprets custom delimiters
     * specified in the format "//[delimiter]\n[numbers...]", ensuring the sum
     * is calculated accurately for inputs with custom delimiters of varying lengths.
     */
    @Test
    public void testCustomDelimiterAnyLength() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[|||]\n1|||2|||3"), "Custom delimiter of any length should work");
        assertEquals(10, calculator.add("//[***]\n2***3***5"), "Custom delimiter of any length should work");
    }

    /**
     * Test case for handling new line delimiters in the input string.
     * Verifies that the add() method correctly interprets new lines
     * as valid delimiters alongside commas, ensuring the sum is calculated
     * accurately for inputs with mixed delimiters.
     */
    @Test
    public void testMultipleDelimiters() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[|][%]\n1|2%3"), "Multiple delimiters should work");
        assertEquals(10, calculator.add("//[*][#]\n4*3#3"), "Multiple delimiters should work");
    }

    /**
     * Test case for handling multiple custom delimiters of any length.
     * Verifies that the add() method correctly interprets multiple custom delimiters
     * specified in the format "//[delimiter1][delimiter2]\n[numbers...]", ensuring the sum
     * is calculated accurately for inputs with multiple delimiters of varying lengths.
     */
    @Test
    public void testMultipleDelimitersAnyLength() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[***][%%%]\n1***2%%%3"), "Multiple delimiters of any length should work");
        assertEquals(15, calculator.add("//[!!][@@@]\n5!!5@@@5"), "Multiple delimiters of any length should work");
    }


}
