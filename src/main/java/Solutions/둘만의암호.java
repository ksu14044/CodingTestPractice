package Solutions;

import java.util.HashSet;
import java.util.Set;

public class 둘만의암호 {
    
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        StringBuilder answer = new StringBuilder();

        Set<Character> skipSet = new HashSet<>();
        for(char skipChar : skip.toCharArray()){
            skipSet.add(skipChar);
        }

        for(char c : s.toCharArray()){
            int count = 0;
            while(count < index){
                c = (char)('a' + (c - 'a' + 1) % 26);
                if(!skipSet.contains(c)){
                    count++;
                }
            }
            answer.append(c);
        }
        System.out.println(answer);

    }
}
