import static java.lang.System.*;
import java.util.*;

public class WordSearch2 
{
	static class TrieNode 
	{
		char ch;
		int we;
		String word;
		TrieNode child[] = new TrieNode[26];
	}
	
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
				temp.ch = ch;
				root.child[ch-'a'] = temp;
				root = temp;
			}
		}
		
		root.we += 1;
		root.word = str;
	}
	
	static void solve(char[][] grid, TrieNode root 
	,int i, int j, int m, int n, List<String> rslt, boolean[][] visited)
	{	    
		if(root.child[grid[i][j]-'a'] == null)
           return;			
		
		root = root.child[grid[i][j] - 'a'];
		if(root.we>0)
		{
			rslt.add(root.word);
			root.we -= 1;
		}
	   
        if(!(i<m && i>=0 && j<n && j>=0 && !visited[i][j]))
		    return;
	   
	    visited[i][j] = true;
        
		solve(grid, root, i-1, j, m, n, rslt, visited);		
        solve(grid, root, i, j-1, m, n, rslt, visited);		
        solve(grid, root, i+1, j, m, n, rslt, visited);		
        solve(grid, root, i, j+1, m, n, rslt, visited);	
        
		visited[i][j] = false;		
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
	   boolean[][] visited = new boolean[m][n];
	   
	   for(int i=0; i<m; i++)
	   {
		   for(int j=0; j<n; j++)
		   {
			   if(root.child[grid[i][j]] != null)
			   	 solve(grid, root, i, j, m, n, rslt, visited);
		   }
	   }
	   
	   for(String str : rslt)
		   out.println(str);
	}
}