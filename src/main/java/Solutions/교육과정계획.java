package Solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 교육과정계획 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nes = sc.next();
        String plan = sc.next();
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for(char c : nes.toCharArray()) {
            q.offer(c);
        }
        for(char c : plan.toCharArray()) {
            if(q.contains(c)) {
                if(q.peek()==c) {
                    q.poll();
                } else {
                    answer = "NO";
                }
            }
        }
        if(!q.isEmpty()) { answer = "NO";}
        System.out.println(answer);
    }

}
