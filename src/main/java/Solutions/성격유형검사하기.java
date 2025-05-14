package Solutions;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5,3,2,7,5};
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0 ; i < survey.length ;i ++){
            char[] c = survey[i].toCharArray();
            if(choices[i] > 4) {
                map.put(c[1], map.getOrDefault(c[1], 0) + choices[i] - 4);
            } else if(choices[i] < 4){
                map.put(c[0], map.getOrDefault(c[0], 0) + 4 - choices[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        char[] c = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for(int i = 0 ; i < c.length - 1 ; i += 2){
            int i1 = map.getOrDefault(c[i], 0);
            int i2 = map.getOrDefault(c[i+1], 0);
            if(i1 >= i2) {
                sb.append(c[i]);
            } else {
                sb.append(c[i+1]);
            }
        }
        System.out.println(sb.toString());
    }
}
