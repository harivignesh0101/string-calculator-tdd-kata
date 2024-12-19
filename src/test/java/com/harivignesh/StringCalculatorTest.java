package com.harivignesh;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
