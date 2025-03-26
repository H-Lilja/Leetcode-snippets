public  class JumpGame {
    //assingment link: https://leetcode.com/problems/jump-game/description/

    public static boolean canJump(int[] nums) {
        // set the maxreach to 0 as default
         int maxReach = 0;
                // loop through a sublist, starting from number at place 1 and goes max to the number that the first number is
                for (int i = 0; i < nums.length; i++)
                {
                    // check if the placement + number equals or is greater than the array length. The number must be greater than 0, because 0 means you can´t move
                    if (i > maxReach) {
                        return false;
                }
                // we take the larger number as our max reach
                maxReach = Math.max(maxReach, i + nums[i]);
                // if max reach is larger than the length, we get true
                if (maxReach >= nums.length - 1) {
                    return true;
                }
            }
            
            // if never get to true, return default false
            return false;
    }

    // Testing the snippet
    public static void main(String[] args) {
        // Testing using the given days and meeting intervals
        int[] nums = {1,1,1,0}; 
        boolean result = canJump(nums); 
        // Print the result boolean
        System.out.println(result); 
    }
}
