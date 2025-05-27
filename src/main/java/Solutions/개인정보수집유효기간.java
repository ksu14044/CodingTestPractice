package Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 개인정보수집유효기간 {
    public static void main(String[] args) {
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        String[] terms = {"A 6", "B 12", "C 3"};
        String today = "2022.05.19";
        Map<String, Integer> map = new HashMap<>();
        for(String term : terms) {
            map.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }
        int todayDate = convertToDays(today);

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < privacies.length ; i++){
            String[] split = privacies[i].split(" ");
            String d = split[0]; String t = split[1];
            int cd = convertToDays(d) + (map.get(t) * 28) - 1;
            if(cd < todayDate){
                list.add(i + 1);
            }
        }
        System.out.println(list);


    }

    public static int convertToDays(String date){
        String[] split = date.split("\\.");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        return day + month * 28 + year * 12 * 28;
    }
}
