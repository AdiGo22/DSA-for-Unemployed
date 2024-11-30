package Strings;

import java.util.HashMap;


public class MinimumWindowSubstring {
    //Leetcode 76
    public static String MinimumWindow(String s, String t) {
    //using HashMap
    HashMap<Character,Integer> map  = new HashMap<>();
    for(char c:t.toCharArray()) {
        map.put(c,map.getOrDefault(c, 0)+1); //frequency plotting for characters of t
    }
    int count =t.length();
    int start=0;int end=0; int startIndex = 0;
    int minLen = Integer.MAX_VALUE;

    //sliding window approah
    while(end<s.length()) {
        char endChar = s.charAt(end);
        if(map.containsKey(endChar++)) {
            //if there is any key of endchar present in the map
            //reduce the frequency of the character found and reduce the length of t
            map.put(endChar,map.get(endChar)-1); 
            if(map.get(endChar) >= 0) {
                count--; // decrement if its not exhausted
            }
        }

        //now the window is valid
        while(count == 0 ) {
            if(end-start < minLen){
                startIndex = start;
                minLen = end-start;
            }
            char startChar = s.charAt(start++);
             if(map.containsKey(startChar)) {
                //move the window
                map.put(startChar,map.get(startChar)+1); 
                 if(map.get(startChar) >= 0) {
                    count++;
                 }
             }
        }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
}
public static void main(String[] args) {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    System.out.println(MinimumWindow(s, t));
}
}