package com.harivignesh;

import java.util.ArrayList;
import java.util.Arrays;
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
     *   <li>An empty input string returns <code>0</code>.</li>
     *   <li>The default delimiters are a comma (<code>","</code>) and a newline character (<code>"\n"</code>).</li>
     *   <li>A custom delimiter can be specified using the format <code>"//[delimiter]\n[numbers]"</code>.
     *       <ul>
     *         <li>For a single-character delimiter: <code>"//;\n1;2"</code>.</li>
     *         <li>For multi-character delimiters, enclose the delimiter in square brackets: <code>"//[***]\n1***2***3"</code>.</li>
     *       </ul>
     *   </li>
     *   <li>Ignores numbers greater than <code>1000</code>.</li>
     *   <li>If the input contains negative numbers, an {@link IllegalArgumentException} is thrown,
     *       and the exception message includes a list of the negative numbers.</li>
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
    public int add(String numbers, Integer startNumber, Integer endNumber) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\\n";
        boolean isMultiplication = false;
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            String delimiterPart = numbers.substring(2, delimiterIndex);
            if (delimiterPart.equals("*")) {
                isMultiplication = true;
            }
            if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
                String[] delimiters = delimiterPart.substring(1, delimiterPart.length() - 1).split("]\\[");
                if (delimiters.length == 1 && delimiters[0].equals("*")) {
                    isMultiplication = true;
                    delimiter = java.util.regex.Pattern.quote("*");
                } else {
                    delimiter = String.join("|", Arrays.stream(delimiters)
                            .map(java.util.regex.Pattern::quote)
                            .toArray(String[]::new));
                }
            } else {
                delimiter = java.util.regex.Pattern.quote(delimiterPart); // Single-character delimiter
            }
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] parts = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        boolean finalIsMultiplication = isMultiplication;

        int sum = Arrays.stream(parts)
                .mapToInt(Integer::parseInt)
                .peek(num -> {
                    if (num < 0) negatives.add(num);
                })
                .filter(num -> num >= 0 && num <= 1000)
                .filter(num -> startNumber == null || endNumber == null || (num >= startNumber && num <= endNumber))
                .reduce(isMultiplication ? 1 : 0, (acc, num) -> finalIsMultiplication ? acc * num : acc + num);

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }
        return sum;
    }

    public int add(String number) {
        return add(number, null, null);
    }
    // (!numbers.matches("^((//\\[.*?\\]\n)?\\d+([,\\n;]*)?)+$"))



}
