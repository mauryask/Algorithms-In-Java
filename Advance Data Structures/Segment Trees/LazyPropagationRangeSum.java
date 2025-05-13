import static java.lang.System.*;
import java.util.*;

public class LazyPropagationRangeSum{
	int[] arr;
	int[] seg;
	int[] lazy;
	
	LazyPropagationRangeSum(int[] arr){
	   this.arr = arr;
	   seg = new int[4*arr.length];
	   lazy = new int[4*arr.length];
	   buildTree(0, 0, arr.length-1);
	}
	
	void buildTree(int index, int start, int end){
		if(start == end){
			seg[index] = arr[start];
			return;
		}
		
		int mid = start + (end-start)/2;
		buildTree(2*index+1, start, mid);
		buildTree(2*index+2, mid+1, end);
		seg[index] = seg[2*index+1] + seg[2*index+2];
	}
	
	//Lazy propagation
	void rangeUpdate(int index, int start, int end, int left, int right, int delta){
		//Handle invalid range
		if(left > right){
			return;
		}
		
		if(lazy[index] != 0){
			seg[index] += lazy[index] * (end - start + 1);
			if(start != end){
				lazy[2*index+1] += lazy[index];
				lazy[2*index+2] += lazy[index];
			}			
			lazy[index] = 0;
		}
		
		//Completely outside
        if(start > right || end < left){
			return;
		}		
		
		//Complete overlap
		if(left <= start && end <= right){
			seg[index] += delta * (end - start + 1);
			if(start != end){
				lazy[2*index+1] += delta;
				lazy[2*index+2] += delta;
			}
			return;
		}
		
		int mid = start + (end - start) / 2;		
		rangeUpdate(2*index+1, start, mid, left, right, delta);
		rangeUpdate(2*index+2, mid+1, end, left, right, delta);
		seg[index] = seg[2*index+1] + seg[2*index+2];
	}
	
	int getSum(int index, int start, int end, int left, int right){
		if(left > right){
			return Integer.MIN_VALUE;			
		}
		
		if(lazy[index] != 0){
			seg[index] += lazy[index] * (end - start + 1);
			if(start != end){
				lazy[2*index+1] += lazy[index];
				lazy[2*index+2] += lazy[index];
			}			
			lazy[index] = 0;
		}
		
		//Completely outside
		if(right < start || end < left){
			return 0;
		}
		
        //Complete overlap
        if(left <= start && end <= right){
		   return seg[index];
		}
		
		int mid = start + (end - start) / 2;
		int leftSum = getSum(2*index+1, start, mid, left, right);
		int rightSum = getSum(2*index+2, mid+1, end, left, right);
		return leftSum + rightSum;
	}
	
	public static void main(String[] args){
		int[] arr = {1,3,4,5,6,-1};
		LazyPropagationRangeSum lp = new LazyPropagationRangeSum(arr);		
		out.println("Sum before update: "+ lp.getSum(0, 0, arr.length-1, 1, 4));
		lp.rangeUpdate(0, 0, arr.length-1, 1, 4, 6);
		out.println("Sum after update: "+ lp.getSum(0, 0, arr.length-1, 0, 2));
	}
}