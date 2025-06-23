package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 하노이의탑 {
    static List<int[]> moves = new ArrayList<>();
    public static void main(String[] args) {
        int n = 5;
        hanoi(n, 1, 3, 2);
        for(int[] i : moves){
            System.out.println(Arrays.toString(i));
        }
    }

    public static void hanoi(int n , int from, int to, int aux){
        if(n == 1){
            moves.add(new int[]{from, to});
        } else {
            hanoi(n - 1, from, aux, to);
            moves.add(new int[]{from, to});
            hanoi(n - 1, aux, to, from);
        }
    }
}
