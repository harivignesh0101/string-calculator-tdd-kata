package com.harivignesh;

public class StringCalculator {

    /**
     * Note - Incomplete method.<br/>
     * Adds the numbers provided in a string format.<br/>
     * If the input string is empty, the method returns 0.
     * Otherwise, it splits the string to list of comma stripped values and returns the sum of the parts
     * regardless of the number of Numbers.
     *
     * @param numbers the string containing the numbers to be added
     * @return the sum of the numbers as an integer, or 0 if the string is empty
     */
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",|\\n";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            delimiter = java.util.regex.Pattern.quote(delimiter);  // Escape special regex characters in the delimiter
            numbers = numbers.substring(delimiterIndex + 1);
        }
        String[] parts = numbers.split(delimiter);
        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }
        return sum;
    }

}
