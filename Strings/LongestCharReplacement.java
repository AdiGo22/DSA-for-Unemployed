package Strings;

import java.util.HashMap;
//Leetcode 424 
// Longest Repeating Character Replacement
public class LongestCharReplacement {
    public static int characterReplacement(String s, int k) {
        int maxLen = 0;
        int maxFreq = 0;
        int l = 0;
        HashMap<Character, Integer> countMap = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            // Update the frequency map for the current character
            char currentChar = s.charAt(r);
            countMap.put(currentChar, countMap.getOrDefault(currentChar, 0) + 1);

            // Get the max frequency of any character in the current window
            maxFreq = Math.max(maxFreq, countMap.get(currentChar));

            // Shrink the window if needed
            if ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l);
                countMap.put(leftChar, countMap.get(leftChar) - 1);
                l++;  // Move the left pointer
            }

            // Calculate the max length of valid window
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println(characterReplacement(s1, k1));  // Output: 4

    }
}
