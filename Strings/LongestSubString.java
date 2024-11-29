package Strings;

import java.util.*;
//Leetcode 3
public class LongestSubString {
    public static int longest(String s) {
        int maxCount = 0; // To store maximum window size
        int l = 0; // Left pointer of the sliding window
        HashSet<Character> set = new HashSet<>();
        
        for (int r = 0; r < s.length(); r++) { // Right pointer of the sliding window
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l)); // Remove left-most character to shrink window
                l++;
            }
            set.add(s.charAt(r)); // Add the current character
            maxCount = Math.max(maxCount, r - l + 1); // Update maximum length
        }
        return maxCount;
    }
    
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(longest(s)); // Output: 3 ("wke" or "kew")
    }
}

