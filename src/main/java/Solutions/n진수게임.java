package Solutions;

import java.util.ArrayList;
import java.util.List;

public class n진수게임 {
    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        List<Character> list = new ArrayList<>();
        for(int i = 0 ; i <= 100000 ; i++){
            String num = Integer.toString(i, n);
            char[] numChars = num.toCharArray();
            for(int j = 0 ; j < numChars.length ; j++){
                list.add(numChars[j]);
            }
        }
        StringBuilder answer = new StringBuilder();
        int index = p-1;
        while(answer.length() < t){
            answer.append(list.get(index));
            index += m;
        }

        System.out.println(answer);
    }
}
