import java.util.Arrays;

public class ProductOfArray {
    // Link to the assingment: https://leetcode.com/problems/product-of-array-except-self/description

    public static int[] productExceptSelf(int[] nums) {
      // create an array of the same size for the new numbers. Can´t write the old one, because we need the original numbers too.  
        int[] newNumberArray = new int[nums.length];
        int n = nums.length;
        // loops through all the numbers in the array. NOTE: THUS IS THE WRONG WAY TO DO IT. It works, but is inefficient time wise.
        // for (int i=0; i< nums.length; i++)
        // {
        //     // counter is set to 1, because multiplying by one we get the original number so it does not change the outcome
        //     int counter=1;
        //     for (int t=0; t< nums.length; t++)
        //     {
        //         // All the numbers except the one in the original place (nums[i]) are multiplied to the counter 
        //         if(t != i)
        //         {
        //             counter*= nums[t];
        //         }

        //     }
        //     //the new number is written to the new number array
        //     newNumberArray[i] = counter;
        // }
        // return new number array

        // There's no element to the left of the first element
        newNumberArray[0] = 1;  
        for (int i = 1; i < n; i++) {
            newNumberArray[i] = newNumberArray[i - 1] * nums[i - 1];
        }

        // Step 2: Compute the product of all elements to the right of each index
        // There's no element to the right of the last element
        int rightProduct = 1;  
        for (int i = n - 1; i >= 0; i--) {
            // Multiply with the right product
            newNumberArray[i] = newNumberArray[i] * rightProduct;  
            // Update the right product for the next iteration
            rightProduct *= nums[i];  
        }
        return newNumberArray;
    }
    // Testing the snippet
    public static void main(String[] args) {
        // Testing with numbers
        int[] inputNums= {-1,1,0,-3,3};
        int[] nums = productExceptSelf(inputNums);
        // Output the result
        System.out.println(Arrays.toString(nums)); 
    }
}