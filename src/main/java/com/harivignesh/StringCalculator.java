package com.harivignesh;

public class StringCalculator {

    /**
     * Note - Incomplete method.<br/>
     * Adds the numbers provided in a string format.<br/>
     * If the input string is empty, the method returns 0.
     * Otherwise, it splits the string to list of comma stripped values and returns the single number
     * if only one part is there or else returns the sum of 1st and 2nd index.
     *
     * @param numbers the string containing the numbers to be added
     * @return the sum of the numbers as an integer, or 0 if the string is empty
     */
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] parts = numbers.split(",");
        if (parts.length == 1) {
            return Integer.parseInt(parts[0]);
        }
        return Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
    }

}
