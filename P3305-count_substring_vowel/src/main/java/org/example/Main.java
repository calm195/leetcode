package org.example;

import java.util.ArrayDeque;
import java.util.Arrays;

/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-12 14:12:56
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-12 20:42:45
 * @Description: to be added
    You are given a string word and a non-negative integer k.

    Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.
    
    Example 1:
    Input: word = "aeioqq", k = 1
    Output: 0
    Explanation:
    There is no substring with every vowel.

    Example 2:
    Input: word = "aeiou", k = 0
    Output: 1
    Explanation:
    The only substring with every vowel and zero consonants is word[0..4], which is "aeiou".

    Example 3:
    Input: word = "ieaouqqieaouqq", k = 1
    Output: 3
    Explanation:
    The substrings with every vowel and one consonant are:
    word[0..5], which is "ieaouq".
    word[6..11], which is "qieaou".
    word[7..12], which is "ieaouq".
    
    Constraints:
    5 <= word.length <= 250
    word consists only of lowercase English letters.
    0 <= k <= word.length - 5
 */

public class Main {
    public static void main(String[] args) {
        String s = "iqeaouqi";
        int k = 2;
        System.out.println(countOfSubstrings(s, k));
    }

    public static int countOfSubstrings(String word, int k){
        String vowel = "aeiou";
        int tempk = 0;
        int[] isContained = new int[5];
        int res = 0;
        int len = word.length();
        ArrayDeque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < len; i ++) {
            String ii = word.substring(i, i + 1);
            deque.offer(ii);
            System.out.println(Arrays.toString(deque.toArray()));
            if (vowel.contains(ii)) {
                isContained[vowel.indexOf(word.charAt(i))] ++;
            } else {
                tempk++;
            }
            if (tempk == k) {
                while (all(isContained) && tempk == k) {
                    res ++;
                    String temp = deque.pollFirst();
                    if (vowel.contains(temp)) {
                        isContained[vowel.indexOf(temp)] --;
                    } else {
                        tempk --;
                    }
                }
            }
            while (tempk > k) {
                String temp = deque.pollFirst();
                if (vowel.contains(temp)) {
                    isContained[vowel.indexOf(temp)] --;
                } else {
                    tempk --;
                }
                if (all(isContained) && tempk == k) res ++;
            }
        }

        return res;
    }

    private static boolean all(int[] isContained) {
        for (int elem : isContained) {
            if (elem < 1) return false;
        }
        return true;
    }
}