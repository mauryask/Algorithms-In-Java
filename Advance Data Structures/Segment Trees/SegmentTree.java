/*
** Time complexity: 
* Buid tre: O(n)
* Query: O(log n)
* Update: O(log n)
** Space complexity: O(n)
*/

import static java.lang.System.*;
import java.util.*;

public class SegmentTree 
{
	int[] seg;
	int[] arr;
	int n;
	
	SegmentTree(int[] arr){
		seg = new int[4 * arr.length];
		this.arr = arr;
	}
	
	// Here seg[index] stores max value between range [start, end]
	
	void buildTree(int index, int start, int end){	    
		if(start == end){
			seg[index] = arr[start];
			return;
		}
		
		int mid = start + (end - start) / 2;		
		buildTree(2 * index + 1, start, mid);
		buildTree(2 * index + 2, mid + 1, end);
		seg[index] = Math.max(seg[2 * index + 1], seg[2 * index + 2]);
	}
	
 	// Here we are checking if the range reprsented by a node is 
	// Completly inside, Comletely outside or Overlapping 
	int getMax(int index, int start, int end, int left, int right){
		// Completely inside
		if(left <= start && end <= right)
			return seg[index];	
		
		//Completely outside
		if(right < start || end < left)
			return Integer.MIN_VALUE;
		
		//If overlapping go to left and right		
        int mid  = start + (end - start) / 2;
        int leftMax = getMax(2 * index + 1, start, mid, left, right);
        int rightMax = getMax(2 * index + 2, mid + 1, end, left, right);
        return Math.max(leftMax, rightMax);		
	}
    
    void update(int index, int start, int end, int valueIndex, int value){
		// Go to leaf node reprsenting the valueIndex, Store the new vaue over there
		if(start == end){
			// Here update the original array as well
			// start = end = valueIndex
			arr[start] = value;
			seg[index] = value;
			return;
		}
		
		int mid = start + (end- start) / 2;		
		// Go to left and right accrodingly
		if(valueIndex <= mid)
			update(2 * index + 1, start, mid, valueIndex, value);
		else
			update(2 * index + 2, mid + 1, end, valueIndex, value);
		
		//Update the new max value while backtracking
		seg[index] = Math.max(seg[2 * index + 1], seg[2 * index + 2]);
	}    
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9,10};		
		SegmentTree st = new SegmentTree(arr);
		st.buildTree(0, 0, arr.length - 1);
		int maxValue = st.getMax(0, 0, arr.length - 1, 0, 5);
		out.println(maxValue);		
		st.update(0, 0, arr.length-1, 2, 25);
		maxValue = st.getMax(0, 0, arr.length - 1, 0, 5);
		out.println(maxValue);		
	}
}