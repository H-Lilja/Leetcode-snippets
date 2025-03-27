import java.util.stream.IntStream;

public  class GasStation {
    //assingment link: https://leetcode.com/problems/gas-station/description

    public static int canCompleteCircuitp(int[] gas, int[] cost) {
        // the arrays arre summed up
            int sumA = IntStream.of(gas).sum();
            int sumB = IntStream.of(cost).sum();
            // if result is not found, -1 needs to be returned
            int result = 0;
            int gasAmount =0; 
            // if the gas is not more than cost, trip can´t be made
            if (sumA >= sumB)
            {
                // Try to find the starting station
                for (int i = 0; i < gas.length; i++) {
                    gasAmount += gas[i] - cost[i];

                    // If current gas drops below 0, reset and try the next station
                    if (gasAmount < 0) {
                        gasAmount = 0;
                        // The next station needs to be checked
                        result = i + 1; 
                    }
                
                 } 
            }
            else
            {
                // return -1 if not enough gas
                result= -1;
            }

            return result;

    }

    // Testing the snippet
    public static void main(String[] args) {
        // Testing using given numbers
        int[] gas = {1,2,3,4,5}; 
        int[] cost = {3,4,5,1,2};
        int result = canCompleteCircuitp(gas, cost); 
        // Print the result int
        System.out.println(result); 
    }
}
