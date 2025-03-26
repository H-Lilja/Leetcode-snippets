public  class JumpGameII {
    //assingment link: https://leetcode.com/problems/jump-game-ii/description/

    public static int jump(int[] nums) {
        //keep records of times jumped, max reach and current number
        int timeJumped= 0;
        int maxReach = 0;
        int currentNum = 0;
        // No jump needed if array has only one element
        if (nums.length == 1) return 0; 

            for (int i = 0; i < nums.length; i++)
            {
                maxReach = Math.max(maxReach,i + nums[i]);
                //We know we can always get to the last number so if the number + its place does not get 
                if (i == currentNum) {
                    timeJumped++;
                    currentNum= maxReach;
                    
                    // If the currentNum reaches or exceeds the last index, break
                    if (currentNum >= nums.length - 1) {
                        break;
                    }
                }
            }
            
            // return times jumped
            return timeJumped;
    }

    // Testing the snippet
    public static void main(String[] args) {
        // Testing using nums
        int[] nums = {2,3,1,1,4}; 
        int result = jump(nums); 
        // Print the result int
        System.out.println(result); 
    }
}
