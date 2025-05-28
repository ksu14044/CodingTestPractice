package Solutions;

import java.util.Arrays;
import java.util.Stack;

public class 표편집 {
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];
        for(int i = 0 ; i < n + 2 ; i++){
            up[i] = i - 1;
            down[i] = i + 1;
        }
        System.out.println(Arrays.toString(up));
        System.out.println(Arrays.toString(down));

        k++;
        Stack<Integer> deleted = new Stack<>();
        for(String c : cmd){
            if(c.startsWith("C")){
                deleted.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ? up[k] : down[k];
            } else if(c.startsWith("Z")){
                int restore = deleted.pop();
                up[down[restore]] = restore;
                down[up[restore]] = restore;
            } else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for(int i = 0 ; i < x ; i++){
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for(int i : deleted){
            answer[i - 1] = 'X';
        }
        System.out.println(new String(answer));

    }
}
