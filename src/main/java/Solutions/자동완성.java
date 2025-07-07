package Solutions;

import java.util.HashMap;
import java.util.Map;

public class 자동완성 {
    static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }
    static TrieNode root = new TrieNode();
    public static void main(String[] args) {
        String[] words = {"go", "gone", "guild"};
        System.out.println(solution(words));
    }
    public static void insert(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.count++;
        }
    }
    public static int getMinInputLength(String word){
        TrieNode node = root;
        int depth = 0;
        for(char c : word.toCharArray()){
            node = node.children.get(c);
            depth++;
            if(node.count == 1) break;
        }
        return depth;
    }

    public static int solution(String[] words){
        for(String word : words){
            insert(word);
        }
        int answer = 0;
        for(String word : words){
            answer += getMinInputLength(word);
        }
        return answer;
    }
}
