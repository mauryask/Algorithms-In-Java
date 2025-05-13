/*
** Time complexities: T(n)
* buildTree: O(n)
* rangeUpdate: O(log n)
* rangeMinimum: O(log n)
** Space complexity: S(n) = O(n)
*/
import static java.lang.System.*;
import java.util.*;

public class LazyPropagationRangeMinimum {
    int[] arr;
    int[] seg;
    int[] lazy;

    LazyPropagationRangeMinimum(int[] arr) {
        this.arr = arr;
        seg = new int[4 * arr.length];
        lazy = new int[4 * arr.length];
        buildTree(0, 0, arr.length - 1);
    }

    void buildTree(int index, int start, int end) {
        if (start == end) {
            seg[index] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;
        buildTree(2 * index + 1, start, mid);
        buildTree(2 * index + 2, mid + 1, end);
        seg[index] = Math.min(seg[2 * index + 1], seg[2 * index + 2]);
    }

    //Lazy propgation
    void rangeUpdate(int index, int start, int end, int left, int right, int delta) {
        if(left > right){
		  return;	
		}
		
		// Apply pending lazy updates
        if (lazy[index] != 0) {
            seg[index] += lazy[index];
            if (start != end) {
                lazy[2 * index + 1] += lazy[index];
                lazy[2 * index + 2] += lazy[index];
            }
            lazy[index] = 0;
        }

        // No overlap
        if (end < left || right < start) {
            return;
        }

        // Complete overlap
        if (left <= start && end <= right) {
            seg[index] += delta; // Apply delta to current node
            if (start != end) {
                lazy[2 * index + 1] += delta;
                lazy[2 * index + 2] += delta;
            }
            return;
        }

        // Partial overlap
        int mid = start + (end - start) / 2;
        rangeUpdate(2 * index + 1, start, mid, left, right, delta);
        rangeUpdate(2 * index + 2, mid + 1, end, left, right, delta);
        seg[index] = Math.min(seg[2 * index + 1], seg[2 * index + 2]);
    }

    int getMin(int index, int start, int end, int left, int right) {
		//Handle invalid range
		if(left > right){
		   return Integer.MAX_VALUE;	
		}
		
        // Apply pending lazy updates
        if (lazy[index] != 0) {
            seg[index] += lazy[index];
            if (start != end) {
                lazy[2 * index + 1] += lazy[index];
                lazy[2 * index + 2] += lazy[index];
            }
            lazy[index] = 0;
        }

        // Complete overlap
        if (left <= start && end <= right) {
            return seg[index];
        }

        // No overlap
        if (end < left || right < start) {
            return Integer.MAX_VALUE;
        }

        // Partial overlap
        int mid = start + (end - start) / 2;
        int leftMin = getMin(2 * index + 1, start, mid, left, right);
        int rightMin = getMin(2 * index + 2, mid + 1, end, left, right);
        return Math.min(leftMin, rightMin);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 7, 9};
        LazyPropagationRangeMinimum lp = new LazyPropagationRangeMinimum(arr);
        out.println("Min in range [1, 3]: " + lp.getMin(0, 0, arr.length - 1, 1, 3)); // Should print 2
        lp.rangeUpdate(0, 0, arr.length - 1, 1, 3, 5);
        out.println("Min in range [1, 3] after update: " + lp.getMin(0, 0, arr.length - 1, 1, 3)); // Should print 7
    }
}