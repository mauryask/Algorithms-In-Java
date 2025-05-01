/*
** Time compelxities
* buildTree: O(n log n)
* update: O(log n) => for one update for n updates O(n* log n)
* getPrefixSum: O(log n)
* getRangeSum: O(log n)
** Space complexities
* S(n) = O(n)
*/
import static java.lang.System.*;
import java.util.*;

public class FenwickTree {    
    int[] arr; 
    int[] fen; 
    int n;

    FenwickTree(int[] arr) {
		//If original array is immutable 
		// Do deep copy of original array if you don't want to modify the original array 
        // this.arr = arr.clone(); 
		// else if the original array is mutable
		this.arr = arr;
        n = arr.length;
        fen = new int[n + 1];
    }

    void updateUtil(int index, int value) {
        index++; // Fenwick Tree uses 1-based indexing
        while (index <= n) {
            fen[index] += value;
            index += index & (-index); // Move to next relevant index
        }
    }

    void buildTree() {
        for (int i = 0; i < n; i++) {
            updateUtil(i, arr[i]);
        }
    }

    void update(int index, int value) {
        if (index < 0 || index >= n) {
            out.println("Index out of bound in update()!!");
			return;
        }
        // Calculate delta before updating arr[index]
        int delta = value - arr[index];
        arr[index] = value; // Update the array
        updateUtil(index, delta); // Update Fenwick Tree
    }

    // Get prefix sum from index 0 to index (inclusive)
    int getPrefixSum(int index) {
        if (index < 0 || index >= n) {
            out.println("Index out of bound in getPrefixSum()!!");
			exit(1);
        }
		
        index++; // Fenwick Tree uses 1-based indexing
        int sum = 0;
        while (index > 0) {
            sum += fen[index];
            index -= index & (-index); // Move to parent
        }
        return sum;
    }
	
	int getRangeSum(int start, int end){
		if(end < start || start < 0 || end >= n) {
            out.println("Index out of bound in getRangeSum()!!");
			exit(1);
        }
		
		// Sum from 0 to index (start - 1)  
		int sum1 = (start == 0) ? 0 : getPrefixSum(start - 1); // Handle start == 0 explicitly
		// Sum from 0 to end
        int sum2 = getPrefixSum(end);
        return sum2 - sum1;		
	}

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};
        FenwickTree ft = new FenwickTree(arr);
        ft.buildTree();

        // Original prefix sum up to index 2
        int sum = ft.getPrefixSum(2);
        out.println("Prefix sum up to index 2 (original): " + sum); // Should print 4 (3 + 2 + (-1))

        // Replace value at index 2 with -2
        ft.update(2, -2);
        sum = ft.getPrefixSum(2);
        out.println("Prefix sum up to index 2 (after update): " + sum); // Should print 3 (3 + 2 + (-2))
		
		int rangeSum = ft.getRangeSum(2, 6);
		out.println("The range sum is: "+ rangeSum);
    }
}