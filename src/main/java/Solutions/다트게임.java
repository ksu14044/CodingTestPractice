package Solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 다트게임 {
    public static void main(String[] args) {
        String dartResult = "1D2S3T*";
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        char[] dart = dartResult.toCharArray();
        for(int i = 0 ; i < dart.length - 1; i ++){
            if(Character.isDigit(dart[i])){
                if(dart[i] == '1' && dart[i+1] == '0'){
                    q.offer(10);
                    i++;
                } else {
                    q.offer(Integer.parseInt(dart[i]+""));
                }
            }
        }
        int answer = 0;

        for(int i = 0 ; i < dart.length; i++){
            if(dart[i] == 'S'){
                int a = q.poll();
                s.push(a);
            } else if (dart[i] == 'D'){
                int a = q.poll();
                s.push(a*a);
            } else if (dart[i] == 'T'){
                int a = q.poll();
                s.push(a*a*a);
            } else if (dart[i] == '*'){
                if(s.size() >= 2){
                    int a = s.pop();
                    int b= s.pop();
                    s.push(b*2);
                    s.push(a*2);
                } else {
                    int a = s.pop();
                    s.push(a*2);
                }
            } else if(dart[i] == '#'){
                int a = s.pop();
                s.push(a*(-1));
            }
        }
        while(!s.isEmpty()){
            answer += s.pop();
        }
        System.out.println(answer);
    }
}
