/*
* Time complexity  : O(n)
* Space complexity : O(1)
*******************
** fixed size window
 */
import static java.lang.System.*;
import java.util.*;

public class FirstNegativeNumberInEachWindowOfSizeK {

    static List<Integer> firstNegativeInteger(int arr[], int k) {
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        int n = arr.length;

        int i = 0, j = 0;

        while (j < n) {
            if (arr[j] < 0) {
                q.add(arr[j]);
            }

            if (j - i + 1 == k) {
				// Once window size is hit
				// Get the first element from list
                if (!q.isEmpty()) {
                    ans.add(q.peek());

                    if (arr[i] == q.peek()) {
                        q.remove();
                    }
                } else { //If no newgative element in a window add 0 to ans list
                    ans.add(0);
                }

                i++;
            }

            j++;
        }

        return ans;
    }

    /*
	* T(n) = O(n*k)
	* S(n) = O(1)
     */
    static void bruteForce(int A[], int n, int k) {
        for (int i = 0; i <= n - k; i++) {
            boolean flag = false;

            for (int j = i; j < i + k; j++) {
                // if first -ve found 
                // print it and break the loop
                if (A[j] < 0) {
                    out.print(A[j] + " ");
                    flag = true;
                    break;
                }

            }

            // -ve number not present in the window
            // print 0
            if (!flag) {
                out.print(" * ");
            }
        }
    }

    public static void main(String[] args) {
        // int A[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int[] A = {-8, 2, 3, -6, 10};
        int k = 2; // window size

        out.println(firstNegativeInteger(A, k));
        //bruteForce(A, n, k);
    }
}
