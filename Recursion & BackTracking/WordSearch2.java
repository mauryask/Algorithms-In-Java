/*
* https://leetcode.com/problems/word-search-ii/
* T(n) : O(m x n x 4^L) : L is length of longest word in the word list
*/
import static java.lang.System.*;
import java.util.*;

public class WordSearch2 
{
	static class TrieNode 
	{
		int we;
		String word;
		TrieNode child[] = new TrieNode[26];
	}
	
	// O(number of words * max word length)
	static void createTrie(String str, TrieNode root)
	{
		for(int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);			
			if(root.child[ch-'a'] != null)
				root = root.child[ch-'a'];
			else
			{
				TrieNode temp = new TrieNode();
				root.child[ch-'a'] = temp;
				root = temp;
			}
		}
		
		root.we += 1;
		root.word = str;
	}
	
	static void solve(char[][] grid, TrieNode root 
	,int i, int j, int m, int n, List<String> rslt)
	{	
        if(!(i<m && i>=0 && j<n && j>=0 && grid[i][j] != '$'))
		    return;
    
		if(root.child[grid[i][j]-'a'] == null)
           return;			
		
		root = root.child[grid[i][j] - 'a'];
		if(root.we>0)
		{
			rslt.add(root.word);
			root.we -= 1;
		}
	   	   

        char ch = grid[i][j];
		grid[i][j] = '$';
		solve(grid, root, i-1, j, m, n, rslt);		
        solve(grid, root, i, j-1, m, n, rslt);		
        solve(grid, root, i+1, j, m, n, rslt);		
        solve(grid, root, i, j+1, m, n, rslt);	
		grid[i][j] = ch;	
	}
	
	public static void main(String [] args)
	{
	   TrieNode root = new TrieNode();
       char grid[][] = {{'o','a','a','n'},
	                  {'e','t','a','e'},
					  {'i','h','k','r'},
					  {'i','f','l','v'}};	
	   String words[] = {"oath","pea","eat","rain"};
       int m =	grid.length;
       int n = grid[0].length;
	   
	   for(String str : words)
        createTrie(str, root);	   
	   
	   List<String> rslt = new ArrayList<>();
	   
	   for(int i=0; i<m; i++)
	   {
		   for(int j=0; j<n; j++)
		   {
			   if(root.child[grid[i][j]-'a'] != null)
			   	 solve(grid, root, i, j, m, n, rslt);
		   }
	   }
	   
	   for(String str : rslt)
		   out.println(str);
	}
}