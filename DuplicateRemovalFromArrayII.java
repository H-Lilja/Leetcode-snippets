import java.util.Arrays;
//Link to the assignment: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

public class DuplicateRemovalFromArrayII {
    
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
         // First element is always counted
        int k = 1;
        // To track occurrences of each number
        int count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // If same as previous, we check if we've already placed 2 occurrences
                if (count < 2) {
                    nums[k] = nums[i];
                    k++;
                    // Increment the count for this numbers occurance
                    count++; 
                }
            } else {
                // If different, reset the count and place the new number
                nums[k] = nums[i];
                k++;
                count = 1;
            }
        }
        // fill out the extra numbers with -1
        Arrays.fill(nums, k, nums.length, -1);
        // After modifying in place, 'k' will be the new length of the array
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        
        // Calling the method to remove duplicates
        int k = removeDuplicates(nums);  

        // Print the modified array and the number of unique elements
        System.out.println("Modified array: " + Arrays.toString(nums));
        System.out.println(k);
    }
}
