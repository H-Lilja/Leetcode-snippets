
public  class IntToRoman {
    //assingment link: https://leetcode.com/problems/integer-to-roman/description

    public static String intToRoman(int num) {
        // romanstring is the output string
        String romanString = "";
        // numberstring is the int we took in string form
        String numberString = Integer.toString(num);
        //the first character is taken as string for later use
        String character = ""+ numberString.charAt(0);
        // the taken char is turned into int itself
        int y = Integer.parseInt(character);
        //mathInt is used to count any leftover numbers
        int mathInt = 0;
        //replacer string is used as a helped building the final string
        String replacerString= "";
        // These characters are set based on if we are handlind numbers between 1-9, 10-99, 100-999
        String repeatedChar1 = "A"; 
        String repeatedChar2 = "B"; 
        String repeatedChar3 = "C"; 
        int leftToProcess= numberString.length();

        for(int i=0; i<numberString.length();i++)
        {

            if((numberString.length() == 4) && (i==0))
            {
                //First set the number of thousands at the beginning. This is just the thousands times M (3000 is 3*M)
                romanString = new String(new char[y]).replace("\0", "M");
                leftToProcess=3;
            }
            else{        

                // based on how what number we are processing we choose the right characters 
            switch (leftToProcess) {
                case 1:
                // here we process 1-9
                  repeatedChar1 ="I";
                  repeatedChar2="V";
                  repeatedChar3 = "X"; 
                  break;
                case 2:
                //here we process 10-99
                    repeatedChar1 ="X";
                    repeatedChar2="L";
                    repeatedChar3 = "C"; 
                  break;
                case 3:
                //here we process 100-999
                    repeatedChar1 ="C";
                    repeatedChar2="D";
                    repeatedChar3 = "M"; 
                  break;
            }
            character = ""+ numberString.charAt(i);
            y = Integer.parseInt(character);
            if ((y!=4) && (y!=9))
            {
              // if its 5 or over, we add a D to mark 500s and for the rest we add C to mark 100 for each 100 that is left over from 500 ( 700 is formed 500 + 100 + 100)
                if(y>=5)
                {
                    romanString+=repeatedChar2;
                    mathInt= y-5;
                    //This if counts out the left over 100s needed
                    if(mathInt !=0)
                    { 
                        //Replacer string is used so the thus far built romanString is not emptied
                        replacerString = new String(new char[mathInt]).replace("\0", repeatedChar1);
                        romanString +=replacerString;
                    }
                }
                // If the y is below 300 we just repeat the 100s needed amount of times
                else
                {
                    //Replacer string is used so the thus far built romanString is not emptied
                    replacerString = new String(new char[y]).replace("\0", repeatedChar1);
                    romanString+= replacerString;
                }
            }
            else
            {
                romanString= romanString + repeatedChar1;
                // 9 is set to be IX,XC or CM and 4 is set to be IV,XL or CD
                if (y==9)
                {
                    romanString+=repeatedChar3;
                }
                else
                {
                    romanString+=repeatedChar2;
                }
            }
            leftToProcess--;
        }
        }
        return romanString;
    }

    // Testing the snippet
    public static void main(String[] args) {
        // Testing using given number
        int num = 1; 
        String result = intToRoman(num); 
        // Print the result string
        System.out.println(result); 
    }
}