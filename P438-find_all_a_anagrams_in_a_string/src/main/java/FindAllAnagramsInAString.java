import java.util.*;

/**
 * @author wjx
 * @date 4/10/2024 7:25 PM
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        FindAllAnagramsInAString test = new FindAllAnagramsInAString();
        System.out.println(test.findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] p_num = new int[26];
        int target_len = p.length();
        for (int i = 0; i < target_len; i++) {
            p_num[p.charAt(i) - 'a'] ++;
        }
        int len = s.length();
        int begin = 0;
        int[] test = new int[26];
        for (int i = 0; i <= len; i++) {
            if (i == len){
                if (i - begin == target_len){
                    result.add(begin);
                }
                break;
            }
            if (i - begin == target_len){
                result.add(begin);
                test[s.charAt(begin) - 'a'] --;
                begin ++;
            }
            int current_index = s.charAt(i) - 'a';
            if (p_num[current_index] != 0 && test[current_index] < p_num[current_index]){
                test[current_index]++;
            } else if (p_num[current_index] == 0) {
                test = new int[26];
                begin = i + 1;
            } else if (test[current_index] >= p_num[current_index]) {
                test[current_index]++;
                while (test[current_index] > p_num[current_index]) {
                    test[s.charAt(begin) - 'a'] --;
                    begin++;
                }
            }
        }

        return result;
    }
}
