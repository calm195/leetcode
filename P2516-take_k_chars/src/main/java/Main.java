/**
 * You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. 
 * Each minute, you may take either the leftmost character of s, or the rightmost character of s.
 * Return the minimum number of minutes needed for you to take at least k of each character, or return -1 
 * if it is not possible to take k of each character.
 * 
 * Input: s = "aabaaaacaabc", k = 2
 * Output: 8
 * Explanation: 
 * Take three characters from the left of s. You now have two 'a' characters, and one 'b' character.
 * Take five characters from the right of s. You now have four 'a' characters, two 'b' characters, and two 'c' characters.
 *  A total of 3 + 5 = 8 minutes is needed.
 * It can be proven that 8 is the minimum number of minutes needed.
 * 
 *  Input: s = "a", k = 1
 * Output: -1
 * Explanation: It is not possible to take one 'b' or 'c' so return -1.
 */
public class Main {
    public static void main(String[] args) {
        String test = "aabaaaacaabc";
        int k = 2;
        // 此solution时间复杂度O(n)
        Solution solution = new Solution();
        System.out.println(solution.takeCharacters(test, k));
        test = "abc";
        k = 3;
        System.out.println(solution.takeCharacters(test, k));
    }
}