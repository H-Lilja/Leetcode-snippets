import java.util.Arrays;

// You can view the assignment here: https://leetcode.com/problems/rotate-array/description/
// Basic description: Rotate array by the given number(k)

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        // Ensure k is within the range of the array length
        // This handles cases where k is larger than the array length
        k = k % n;  
        
        // Reverse the entire array
        reverse(nums, 0, n - 1);
        
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        
        // Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    // Helper function to reverse a portion of the array
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        // Calling the method to rotate the array in place
        rotate(nums, k);

        // Print the rotated array
        System.out.println(Arrays.toString(nums));
    }
}

