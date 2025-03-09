// Print all the LIS (Longest increasing subsequences)
// https://www.youtube.com/watch?v=3mD20VSib5E

import static java.lang.System.*;
import java.util.*;

public class LongestIncreasingSubsequence {
    // T(n) : O(n^2)
    // S(n) : O(n)

    static int[] findLISLengthAndIndex(int[] A, int n, int[] dp) {
        int maxLength = 0;
        int maxIndex = 0;

        // Bsae case
        // if(n <= 1)
         // return n;
       
        int len[] =  new int[n];
        Arrays.fill(len, 1);
               
        for(int i=1; i<n; i++){
           for(int j=0; j<i; j++){
               if(arr[i] > arr[j] && len[i] < len[j] + 1){
                   len[i] = len[j] + 1;
               }
              
			  if(maxLength < len[i]){
				 maxLength = len[i];
				 maxIndex = i;
			  }
           }
        }
               
        return new int[]{maxLength, maxIndex};
    }

    //T(n) : 𝑂(Number of LIS × 𝑛2)
    static void printLIS(int[] A, int length, int index, int[] dp, List<Integer> list) {
        list.add(0, A[index]);

        if (length == 1) {
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
    
    // https://www.geeksforgeeks.org/construction-of-longest-increasing-subsequence-using-dynamic-programming/
    static void printTingLexicoGraphicallySmallestIndexLIS
    (int[] A, int length, int index, List<Integer> list, int[] dp) {
        list.add(0, A[index]);

        if (length == 1 || index == 0) {
            out.println(list);
            return;
        }

        int minIndex = index;

        for (int i = index - 1; i >= 0; i--) {
            if(dp[i] == length - 1 && i < minIndex && A[i] < A[index]){
                minIndex = i;
            }
        }        

        printTingLexicoGraphicallySmallestIndexLIS(A, length - 1, minIndex, list, dp);
    }

    public static void main(String[] arg) {
        // int[] A = {10, 22, 42, 33, 21, 50, 41, 60, 80, 3};
        // In this example we are going to have two LIS 
        // One ends at 80 and one ends at 79
        int[] A = {10, 22, 42, 33, 21, 50, 41, 60, 80, 79};
        int n = A.length;
        int[] dp = new int[n];
        int[] lisInfo = findLISLengthAndIndex(A, n, dp);
        int lisLength = lisInfo[0];
        int lisIndex = lisInfo[1]; //This holds the firts index (i.e. ending at 80)
        // Printing LIS ending at all the indices
        // Since all the LIS going to be after first LIS index so taking it as starting index
        // for (int i = lisIndex; i < n; i++) {
        //     if (dp[i] == lisLength) {
        //         printLIS(A, lisLength, i, dp, new ArrayList<>());
        //     }
        // }

        printTingLexicoGraphicallySmallestIndexLIS(A, lisLength, lisIndex, new ArrayList<>(), dp);
    }
}
