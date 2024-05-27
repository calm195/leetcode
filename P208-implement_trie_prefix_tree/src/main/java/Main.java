/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-27 17:51:03
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-27 20:37:41
 * @Description: to be added
 */
public class Main {
    public static void main(String[] args) {
        Trie obj = new Trie();
        String word = "word";
        String prefixAll = "prefix";
        String prefix = "pre";
        obj.insert(word);
        obj.insert(prefixAll);
        System.out.println(obj.search(word)); // true
        System.out.println(obj.search(prefix)); // false
        System.out.println(obj.startsWith(prefix)); // true
        obj.insert(prefix);
        System.out.println(obj.search(prefix)); // true
    }
}
