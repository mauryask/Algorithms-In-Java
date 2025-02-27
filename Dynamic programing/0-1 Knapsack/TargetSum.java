
/**
 * How many different ways are there we can assign either
 *  +ve or -ve to each element to produce the given sum(taget sum)
 */

import static java.lang.System.*;

public class TargetSum {
public static void main(String[] args) {
        int set[] = {1, 2, 4, 7, 8};
        int target_sum = 16;
        int n = set.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += set[i];
        }

        // (sum - target_sum) <= 0 => this part depends upaon values of N
		// for examp,e N >= 0
		// (sum - target_sum) % 2 == 1 ==> this part can not be odd else 
		// (sum - target_sum) /2 will be a floating point value
		// Which can never be achieved from s integer subset sum

        if((sum - target_sum) <= 0 || (sum - target_sum) % 2 == 1)
		{
			System.err.println("Count: "+ 0);
			return;
		}
     

        int t_sum = (sum - target_sum) / 2;

        out.println(solve(set, n, t_sum));
    }

    static int solve(int set[], int n, int s) //bottom up approach
    {
        int dp[][] = new int[n + 1][s + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s + 1; j++) {
                if (set[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - set[i - 1]] + dp[i - 1][j]; 
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][s];
    }
}

// Best approach 
// T(n) : O(N * S)
// S(n) : O(S) 
// Here S is number of unique sums in the map
// 	class Solution {
//     public int findTargetSumWays(int[] nums, int target) {  
//         // Main DP map      
//         Map<Integer, Integer> dp = new HashMap<>();
//         dp.put(0, 1);
//         for(int num : nums){
//             // nextDp map stores the sum (received after adding current element by taking it 
//             // either as +ve or -ve) and how many ways this sum can we achieved.
//              Map<Integer, Integer> nextDp = new HashMap<>();
//              for(int sum : dp.keySet()){
//                 int count = dp.get(sum); //Number ways the sum can be achieved
//                 // Take the number as +ve 
//                 nextDp.put(sum + num, nextDp.getOrDefault(sum + num, 0)/*How many ways the sum
//                 has bee achieved + current way count*/  + count);
//                 nextDp.put(sum - num, nextDp.getOrDefault(sum - num, 0) + count);
//              }
//             // Update main dp map
//              dp = nextDp;
//         }
//         // Return the number of ways if target is found else 0
//         return dp.getOrDefault(target, 0);         
//     }
// }
