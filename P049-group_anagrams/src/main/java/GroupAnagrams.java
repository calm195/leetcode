import java.util.*;

/**
 * @author wjx
 * @date 4/1/2024 12:46 PM
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(strs).toString());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuilder buffer = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    buffer.append((char)('a' + i));
                    buffer.append(counts[i]);
                }
            }
            String key = buffer.toString();
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }
        System.out.println(map.keySet());
        return new ArrayList<>(map.values());
    }
}
