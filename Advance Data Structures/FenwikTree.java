import static java.lang.System.*;
import java.util.*;

public class FenwikTree{	
	int[] arr;
	int[] fen;
	int n;
	
	FenwikTree(int[] arr){
		this.arr = arr;
		n = arr.length;
		fen = new int[n + 1];
	}
	
	void buildTreeHelper(int index, int value){
		while(index <= n){
			fen[index] += value;
			index += (-index  & index);
		}
	}
	

	int query(int start, int end){
		if(end > start)
		  return 0;
	    int parent = end + ((~end + 1) & end);
	    return fen[end] + query(start, parent); 
	}	
	
	void buildTree(){
		for(int i=0; i<n; i++){
			buildTreeHelper(i+1, arr[i]);
		}
	}
	
	public static void main(String[] args){
		int arr[] = {3,2,-1,6,5,4,-3,3,7,2,3};
        FenwikTree ft = new FenwikTree(arr);	
        ft.buildTree();
		// int sum = ft.query(1,6);
		// out.println(sum);
	}
}