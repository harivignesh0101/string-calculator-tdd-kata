package com.harivignesh;

public class StringCalculator {

    /**
     * Note - Incomplete method.<br/>
     * Adds the numbers provided in a string format.<br/>
     * If the input string is empty, the method returns 0.
     * Otherwise, it parses the string to an integer and returns the result.
     *
     * @param numbers the string containing the numbers to be added
     * @return the sum of the numbers as an integer, or 0 if the string is empty
     */
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(numbers);
    }

}
