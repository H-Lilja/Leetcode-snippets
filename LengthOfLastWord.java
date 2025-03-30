public  class LengthOfLastWord {
    //assingment link: https://leetcode.com/problems/length-of-last-word

    public static int lengthOfLastWord(String s){
        // Change the string to array, splittin it with a space
        String[] ary = s.split(" ");
        // take out the last word
        String lastWord = ary[ary.length-1];
        // return the length of the last word
        return lastWord.length();
    }

    // Testing the snippet
    public static void main(String[] args) {
        // Testing using given string
        String inputSentence = "   fly me   to   the moon  "; 
        int result = lengthOfLastWord(inputSentence); 
        // Print the result int
        System.out.println(result); 
    }
}
