package Solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카드뭉치 {
    public static void main(String[] args) {
        String[] card1 = {"i", "drink", "water"};
        String[] card2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        Queue<String> c1 = new LinkedList<>(Arrays.asList(card1));
        Queue<String> c2 = new LinkedList<>(Arrays.asList(card2));
        Queue<String> g = new LinkedList<>(Arrays.asList(goal));

        while(!g.isEmpty()){
            if(!c1.isEmpty() && g.peek().equals(c1.peek())){
                c1.poll();
                g.poll();
            } else if(!c2.isEmpty() && g.peek().equals(c2.peek())){
                c2.poll();
                g.poll();
            } else {
                break;
            }
        }
        if(g.isEmpty()){
            System.out.println("YES");
        } else System.out.println("NO");
    }
}
