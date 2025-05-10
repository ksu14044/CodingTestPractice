package Solutions;

import java.util.ArrayList;
import java.util.List;

public class 최고의집합 {
    public static void main(String[] args) {
        int n = 2;
        int s = 9;
        List<Integer> answer = new ArrayList<>();
        for(int i = n ; i >= 1 ; i--){
            int k = s/i;
            s -= k;
            answer.add(k);
        }
        System.out.println(answer);
    }
}
