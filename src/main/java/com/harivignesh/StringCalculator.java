package com.harivignesh;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    /**
     * Note - Incomplete method.<br/>
     * Adds the numbers provided in a string format.<br/>
     * If the input string is empty, the method returns 0.<br/>
     * The input string can specify a custom delimiter at the beginning using the format "//[delimiter]\\n[numbers]".<br/>
     * If no custom delimiter is specified, the default delimiters are a comma (",") or a newline character ("\\n").<br/>
     * The method returns the sum of the numbers in the string. If negative numbers are present, an exception is thrown.<br/>
     *
     * <b>Behavior:</b>
     * <ul>
     *   <li>Empty string returns 0.</li>
     *   <li>Default delimiters are "," and "\\n".</li>
     *   <li>Custom delimiters can be defined using "//[delimiter]\\n" syntax (e.g., "//;\\n1;2").</li>
     *   <li>If the string contains negative numbers, an {@link IllegalArgumentException} is thrown with a list of negative numbers.</li>
     * </ul>
     *
     * @param numbers the string containing the numbers to be added. May include custom or default delimiters.
     * @return the sum of the numbers as an integer, or 0 if the string is empty.
     * @throws IllegalArgumentException if the input contains negative numbers, including the list of negatives in the exception message.
     */
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",|\\n";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            delimiter = java.util.regex.Pattern.quote(delimiter); // Escape special regex characters in the delimiter
            numbers = numbers.substring(delimiterIndex + 1);
        }
        String[] parts = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num < 0) {
                negatives.add(num);
            }
            sum += num;
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }
        return sum;
    }

}
