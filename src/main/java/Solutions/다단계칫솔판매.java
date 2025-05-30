package Solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다단계칫솔판매 {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        Map<String, String> parent = new HashMap<>();
        for(int i = 0 ; i < enroll.length ; i++){
            parent.put(enroll[i], referral[i]);
        }

        Map<String, Integer> total = new HashMap<>();
        for(int i = 0 ; i < seller.length ; i++){
            String curName = seller[i];
            int money = amount[i] * 100;
            while(money > 0 && !curName.equals("-")){
                total.put(curName, total.getOrDefault(curName, 0) + money - (money / 10));
                curName = parent.get(curName);
                money /= 10;
            }
        }

        int[] answer = new int[enroll.length];
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = total.getOrDefault(enroll[i], 0);
        }

        System.out.println(Arrays.toString(answer));
    }
}
