/*
* Time complexity  : O(n)
** since we are not going to have more than k+1 
** elemnts in the map at any time
* Space complexity : O(k)
***************
** https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
** Variable size window
 */

import static java.lang.System.*;
import java.util.*;

public class MaxSubstringwithKUniqueCharacters {

    static int longestkSubstr(String s, int k) {
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int n = s.length();

        while (j < n) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            // Once the map size hits the k size get the max length
            if (map.size() == k) {
                max = Math.max(max, j - i + 1); 
            }else if (map.size() > k) { // If map size exceeds k 
                while (map.size() > k) {
                    ch = s.charAt(i);

                    if (map.containsKey(ch)) {
                        int value = map.get(ch);
						// If on substracting 1 the frequency of ch becomes 0
						// Rmove it						
                        if (value - 1 == 0) { 
                            map.remove(ch); 
                        }else {
                            map.put(ch, value - 1);
                        }
                    }

                    i++;
                }
            }

            j++;
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }

    public static void main(String[] args) {
        String str = "aabacbebebe";
        int k = 3;
        out.println(longestkSubstr(str, k));
    }
}
