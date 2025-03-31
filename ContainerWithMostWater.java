public  class ContainerWithMostWater {
    //assingment link: https://leetcode.com/problems/container-with-most-water/description

    public static int maxArea(int[] height){
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        

        while (left < right) {
            // Calculate the area with the current pair of heights. X-Axis ( minus any movement) * smaller y-axis
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            
            // If the amount is bigger than the current biggest, we assing it to be the biggest.
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer corresponding to the shorter height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;

    }

    // Testing the snippet
    public static void main(String[] args) {
        // Testing using given string
        int[] inputArr = {1,8,6,2,5,4,8,3,7}; 
        int result = maxArea(inputArr); 
        // Print the result int
        System.out.println(result); 
    }
}


// Original answer. This was not time efficient enough in leetcode, so researched a more time efficient approach that ende up using.

        // Initialize Ints used. smallerNumber is smaller of the two comparable ints, that is use to count the y axis
       // of the container. The countWater is y-axis*x-axis based on the searchable distance. Multiplicand is the x- axis.
        // Minus from right is the amount we decrease the x-axis from the right side.
        // int countWater=0;
        // int maxArea=0;
        // int smallerNumber=0;
        // int multiplicand=0;
        // int minusFromRight=0;
        // outerloop goes through the array from left to right
        // for (int i = 0; i< height.length; i++)
        // {
        //     for(int t = height.length; t> 0; t--)
        //     { 
                // inner loop takes the other number from right to left
                //Smaller number is taken with comparing two ints, because the container can only be as high as the smaller number
                // smallerNumber= Math.min(height[i],height[t-1]);
                // minus from right is so that we get the right length for x-axis
                // minusFromRight = height.length -t;
                //multiplicand aka the x.axis length is counted by decreasing the size based on where the ints are positioned in an array
                // multiplicand = height.length-i-1-minusFromRight;
                // Get the count of the amount of water
                // countWater = smallerNumber* multiplicand;
                // If the amount is bigger than the current biggest, we assing it to be the biggest.
        //         if(countWater> maxArea )
        //         {
        //             maxArea=countWater;
        //         }

        //     }
        // }
        // returnn maxArea
      //  return maxArea;