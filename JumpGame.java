public  class JumpGame {
    //assingment link: https://leetcode.com/problems/jump-game/description/

    public static boolean canJump(int[] nums) {
        // set the maxreach to 0 as default
         int maxReach = 0;
                for (int i = 0; i < nums.length; i++)
                {
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
        // Testing using given numbers
        int[] nums = {1,1,1,0}; 
        boolean result = canJump(nums); 
        // Print the result boolean
        System.out.println(result); 
    }
}
