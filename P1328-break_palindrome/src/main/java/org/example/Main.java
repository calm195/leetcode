package org.example;

/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-05 14:12:40
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-07 14:06:06
 * @Description: to be added
    Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.
    Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.
    A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.

    Example 1:
    Input: palindrome = "abccba"
    Output: "aaccba"
    Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
    Of all the ways, "aaccba" is the lexicographically smallest.

    Example 2:
    Input: palindrome = "a"
    Output: ""
    Explanation: There is no way to replace a single character to make "a" not a palindrome, so return an empty string.
    
    Constraints:
    1 <= palindrome.length <= 1000
    palindrome consists of only lowercase English letters.
 */

public class Main {
    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(breakPalindrome(s));
    }

    public static String breakPalindrome(String s) {
        int len = s.length();
        if (len == 1) return "";

        int left = ( len >> 1 ) - 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= left; i++) {
            if (s.charAt(i) != 'a') {
                sb.append("a");
                for (int j = i + 1; j < len; j ++){
                    sb.append(s.charAt(j));
                }
                return sb.toString();
            }
            else sb.append(s.charAt(i));
        }
        left++;
        if ((len & 1) == 1) sb.append(s.charAt(left++));
        for (int i = left; i < len - 1; i ++) {
            sb.append(s.charAt(i));
        }
        sb.append("b");
        return sb.toString();
    }

    public static String breakPalindrome2(String s) {
        if (s.length() == 1) return "";
        int len = s.length();
        char[] words = s.toCharArray();
        boolean flag = false;
        int left = len >> 1;
        for (int i = 0; i < left; i ++) {
            if (words[i] != 'a') {
                words[i] = 'a';
                flag = true;
                break;
            }
        }
        if (!flag) words[len - 1] = 'b';
        return new String(words);
    }
}