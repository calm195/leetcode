/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-27 17:52:20
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-27 20:45:49
 * @Description: to be added
 */

import java.util.HashMap;

public class Trie {
    private class Node {
        @SuppressWarnings("unused")
        char data;
        HashMap<Character, Node> next;
        boolean isWord = false;
        
        Node(){
            data = '/';
            next = new HashMap<>();
        }

        Node(char data){
            this.data = data;
            next = new HashMap<>();
        }
    }

    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        int word_len = word.length();
        Node node = root;
        for (int i = 0; i < word_len; i++) {
            if (!node.next.containsKey(word.charAt(i))) {
                node.next.put(word.charAt(i), new Node(word.charAt(i)));
            }
            node = node.next.get(word.charAt(i));
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        int word_len = word.length();
        Node node = root;
        for (int i = 0; i < word_len; i++) {
            if (!node.next.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.next.get(word.charAt(i));
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        int prefix_len = prefix.length();
        Node node = root;
        for (int i = 0; i < prefix_len; i++) {
            if (!node.next.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.next.get(prefix.charAt(i));
        }
        return true;
    }
}
