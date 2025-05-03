package Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class 스킬트리 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTree = {"BACDE", "CBADF", "AECB", "BDA"};

        char[] order = skill.toCharArray();

        int count = 0;

        for(String trees : skillTree) {
            Queue<Character> q = new LinkedList<>();
            for(char c : order) {
                q.offer(c);
            }
            char[] tree = trees.toCharArray();
            boolean valid = true;
            for(char c : tree) {
                if(q.contains(c)) {
                    if(c == q.peek()){
                        q.poll();
                    } else {
                        valid = false;
                        break;
                    }
                }
            }
            if(valid) {
                count++;
            }
        }
        System.out.println(count);
    }
}
