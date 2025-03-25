public class ReverseWords {
    // Link to the assingment: https://leetcode.com/problems/reverse-words-in-a-string/description

    public static String reverseWords(String s) {

        s = s.trim();  // Remove leading and trailing spaces
        s = s.replaceAll("\\s+", " ");  // Replace multiple spaces with a single space
        String regex = "[ ]";
        // splitting the word  with regex, pattern being a spave
        String[] myArray = s.split(regex);
        StringBuilder reversedString = new StringBuilder();
        // looping through the string that was made into array to rearrange it
        for (int i = myArray.length - 1; i >= 0; i--) {
            // Append the word to the StringBuilder
            reversedString.append(myArray[i]);
            if (i > 0) {
                // Adding space between words if not last
                reversedString.append(" "); 
            }
        }
        
        return reversedString.toString();
    }
    // Testing the snippet
    public static void main(String[] args) {
        // Testing with string
        String myStr = "this reverses words";
        String result = reverseWords(myStr);
        // Output the result
        System.out.println(result); 
    }
}