package Strings;

import java.util.HashMap;
//Leetcode 3
public class LongestSubString2 {
    //optimised version of Longest SubStrig solution

    public static int Longest(String s) {
        int l = 0,maxCount =0;
        HashMap<Character,Integer>map = new HashMap<>();
        for(int r=0;r<s.length();r++){
            char current = s.charAt(r);
            if(map.containsKey(current)){
                //if duplicate found
                //move the l pointer
                l = Math.max(map.get(current)+1 ,l);
            }
            map.put(current,r);
            maxCount=Math.max(r-l+1,maxCount);
        }
        return maxCount;
    }
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(Longest(s));
    }
}
