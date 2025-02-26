package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-02-25 21:00:36
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-02-26 12:50:56
 * @Description: to be added
 * 
    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

    The testcases will be generated such that the answer is unique.

    

    Example 1:

    Input: s = "ADOBECODEBANC", t = "ABC"
    Output: "BANC"
    Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
    Example 2:

    Input: s = "a", t = "a"
    Output: "a"
    Explanation: The entire string s is the minimum window.
    Example 3:

    Input: s = "a", t = "aa"
    Output: ""
    Explanation: Both 'a's from t must be included in the window.
    Since the largest window of s only has one 'a', return empty string.
    

    Constraints:

    m == s.length
    n == t.length
    1 <= m, n <= 10^5
    s and t consist of uppercase and lowercase English letters.
    

    Follow up: Could you find an algorithm that runs in O(m + n) time?
 */


public class Main{
    static int[] map = new int[52];
    public static void main(String[] args) {
        String s = "a";
        String t = "a";

        String res = minWindow(s, t);
        System.out.println(res);
    }

    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (tLen > sLen) return "";

        for (int i = 0; i < tLen; i ++){
            if (Character.isUpperCase(t.charAt(i))) {
                map[t.charAt(i) - 'A' + 26]++;
            }
            else if (Character.isLowerCase(t.charAt(i))) {
                map[t.charAt(i) - 'a']++;
            }
        }

        String res = s;
        String temp = "";
        int left = 0; 
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                map[s.charAt(i) - 'A' + 26]--;
            }
            else if (Character.isLowerCase(s.charAt(i))) {
                map[s.charAt(i) - 'a']--;
            }
            while (isComplete()) {
                temp = s.substring(left, i + 1);
                if (temp.length() < res.length()) {
                    res = temp;
                }
                if (Character.isUpperCase(s.charAt(left))) {
                    map[s.charAt(left) - 'A' + 26]++;
                }
                else if (Character.isLowerCase(s.charAt(left))) {
                    map[s.charAt(left) - 'a']++;
                }
                left ++;
            }
        }
        if (temp.isEmpty()) return "";
        return res;
    }

    private static boolean isComplete() {
        for (int item: map) {
            if (item > 0) return false;
        }
        return true;
    }
}