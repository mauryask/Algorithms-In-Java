// Print all the LIS (Longest increasing subsequences)
// https://www.youtube.com/watch?v=3mD20VSib5E

import static java.lang.System.*;
import java.util.*;

public class LongestIncreasingSubsequence {
   // T(n) : O(n^2)
   // S(n) : O(n)
    static int[] findLISLengthAndIndex(int[] A, int n, int[] dp) {
        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            int tempMax = 0;

            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    if (tempMax < dp[j]) {
                        tempMax = dp[j];
                    }
                }
            }

            dp[i] = tempMax + 1;

            if (max < dp[i]) {
                max = dp[i];
                maxIndex = i;
            }
        }

        return new int[]{max, maxIndex};
    }
    
    //T(n) : O(Number of LIS * Length of LIS)
    static void printLIS(int[] A, int length, int index, int[] dp, List<Integer> list) {
        list.add(0, A[index]);
  
        if (length == 1 || index == 0) {
            out.println(list);
            return;
        }

        for (int i = index - 1; i >= 0; i--) {
            if (A[i] < A[index] && dp[i] == length - 1) {
                printLIS(A, length - 1, i, dp, list);
                //Remove while backtracking
                list.remove(0);
            }
        }
    }

    public static void main(String[] arg) {
        int[] A = {10, 22, 42, 33, 21, 50, 41, 60, 80, 3};
        int n = A.length;
        int[] dp = new int[n];
        int[] lisInfo = findLISLengthAndIndex(A, n, dp);
        printLIS(A, lisInfo[0], lisInfo[1], dp, new ArrayList<>());
    }
}
