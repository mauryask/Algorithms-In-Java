/*
** fixed size window
// https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
*/

// T(n) : O(n)
// S(n) : O(n)

import static java.lang.System.*;
import java.util.*;

public class CountOcuuranceOfAnagras {

   static int anagramCount(String pat, String txt) 
   {
		int n = txt.length();
		int k = pat.length();

        if(n < k){
			return -1; // Anagram is not possible 
		}

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            char ch = pat.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = map.size(); // Count of total unique charcaters in pattrern
        int ans = 0; 
        int i = 0, j = 0;


        while (j < n) {
            char ch = txt.charAt(j);

            if (map.containsKey(ch)) {
                map.replace(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    count--;
                }
            }

            if (j - i + 1 == k) {
                // If count is 0: means we got all the charcaters of pattern
				// in the current window
				if (count == 0) {
                    ans++;
                }

                // Undo the changes at index i
                ch = txt.charAt(i);

                if (map.containsKey(ch)) {
                    int value = map.get(ch);
                    map.replace(ch, value + 1);
                    // If frequency of character changes from 0 to non-zero
					// Increase the count by 1
					// That means we need to find count instances of this charcater
                    if (value == 0) {
                        count++;
                    }
                }

                i++;
            }
            
            j++;
        }

        return ans;
    }

    /**
     * T(n) = (n*k) S(n) = O(k)
     */
    static int bruteForce(String str, String pattern, int n, int k) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> m1;

        for (int i = 0; i < k; i++) {
            char ch = pattern.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int anagramCount = 0;

        for (int i = 0; i <= n - k; i++) {
            m1 = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                char ch = str.charAt(j);
                m1.put(ch, m1.getOrDefault(ch, 0) + 1);
            }

            boolean flag = true;

            for (Map.Entry<Character, Integer> m
                    : map.entrySet()) {
                char key = m.getKey();
                int value = m.getValue();

                /*
				* getOrDefault() here becasuse
				* if key is not present in m1
				* then it will retun null
				* as the resuolt null pointer exception
				* wil be thrown
                 */
                if (m1.getOrDefault(key, 0) != value) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                anagramCount++;
            }
        }

        return anagramCount;
    }

    public static void main(String[] args) {
        String str = "aababddeabaa";
        String pattern = "aaba";
        out.println(anagramCount(pattern, str));
        //out.println(bruteForce(str, pattern, n, k));
    }
}
