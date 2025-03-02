/*
* T(n) : O(n) 
* S(n) : O(1)
****************
* Sliding window
** https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 */
import static java.lang.System.*;

public class FindEquilibriumPoint {

    static int findEquilibrium(int arr[]) {
        int sum = 0; // Overall sum of the array
        int start = 0; // Starting sum

        for (int x : arr) {
            sum += x;
        }

        for (int i = 0; i < arr.length; i++) {
			// Check if strating sum == end sum
            if (start == (sum - start - arr[i])) {
                return i;
            }
            start += arr[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int A[] = {-7, 1, 5, 2, -4, 3, 0};
        out.println(findEquilibrium(A));
    }
}
