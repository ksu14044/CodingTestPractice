package Solutions;

import java.util.ArrayList;
import java.util.List;

public class 압축 {
    public static void main(String[] args) {
        List<Integer> answer = new ArrayList<>();

        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] dictChar = alpha.toCharArray();
        List<String> dict = new ArrayList<>();
        dict.add("0");
        for(char c : dictChar) {
            dict.add(String.valueOf(c));
        }

        String msg = "ABABABABABABABAB";
        int lt = 0;
        int rt = lt + 1;
        while(rt <= msg.length()){
            String target = msg.substring(lt, rt);
            if(dict.contains(target)){
                rt++;
            } else {
                System.out.println("lt : " + lt + " rt = " + rt);
                String tmp = msg.substring(lt, rt - 1);
                System.out.println(tmp);
                lt = rt - 1;
                answer.add(dict.indexOf(tmp));
                dict.add(target);
                System.out.println(dict);
            }
        }
        if(lt < msg.length()) {
            answer.add(dict.indexOf(msg.substring(lt)));
        }
        System.out.println(answer);


    }
}
