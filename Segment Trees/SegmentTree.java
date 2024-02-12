import static java.lang.System.*;
import java.util.*;

public class SegmentTree 
{
	int n;
	int[] tree;
	int[] arr;
	
	SegmentTree(int n, int[] arr)
	{
		this.n = n;
		tree = new int[4*n];
		this.arr = arr;
	}
		
	private void buildTree(int nodeIndex, int start, int end)
	{
		 if(start == end)
		 {
			tree[nodeIndex] = arr[start];
			return;
		 }
		 else 
		 {
			int mid = start + (end - start) / 2;
			buildTree(2 * nodeIndex + 1, start, mid);			
			buildTree(2 * nodeIndex + 2, mid+1, end);            
            tree[nodeIndex] = tree[2 * nodeIndex + 1] + tree[2 * nodeIndex + 2]; 			
		 }
	}
	
	private int query(int nodeIndex,  int start, int end, int left, int right)
	{
		if(start > end || end < left) // no overlap
		{
			return 0;
		}
		else if(left <= start && end <= right) // complete overlap
		{
			return tree[nodeIndex];
		}
		else // partial overlap
		{
			int mid = start + (end - start) / 2;
			int leftSum = query(2 * nodeIndex + 1, start, mid, left, right);
			int rightSum = query(2 * nodeIndex + 2, mid + 1, end, left, right);
			return  leftSum + rightSum;
		}
	}
	
	public static void main(String[] args)
	{
		int A[] = {10,5,16,3,9,11,8,12};
		int n = A.length;
		SegmentTree st = new SegmentTree(n, A);		
		st.buildTree(0, 0, n-1);	
	    int sum = st.query(0,0,n-1,1,5);
		out.println(sum);
	}
}