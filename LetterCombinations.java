import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public  class LetterCombinations {
    //assingment link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

    public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();

        if (digits.length() == 0) {
            // if input empty, retunrn empty list
            return result; 
        }

        // Mapping a phone layout
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(2, new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put(3, new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put(4, new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put(5, new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put(6, new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put(7, new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        map.put(8, new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put(9, new ArrayList<>(Arrays.asList("w", "x", "y", "z")));

        // Split the digits into individual characters
        String[] splitDigit = digits.split("(?!^)");

        // Initialize the result list with the letters for the first digit
        List<String> values = map.get(Integer.parseInt(splitDigit[0]));

        // Loop through remaining digits and combine their letters
        for (int i = 1; i < splitDigit.length; i++) {
            int digit = Integer.parseInt(splitDigit[i]);
            List<String> newValues = map.get(digit);

            // Generate combinations of letters from the previous values and the current digit
            List<String> tempResult = new ArrayList<>();
            for (String value : values) {
                for (String newValue : newValues) {
                    tempResult.add(value + newValue);
                }
            }
            // Update values to the current list of combinations
            values = tempResult;  
        }

        // Add the final combinations to the result
        result.addAll(values);
        return result;
    }

    // Testing the snippet
    public static void main(String[] args) {
        // Testing inputting string
        String temp1 = "234";
        List<String> result = letterCombinations(temp1); 
        // Print the result list
        System.out.println(result);  
    }
}