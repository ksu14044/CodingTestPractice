package Solutions;

import java.util.*;
public class 신고결과받기 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] answer = new int[id_list.length];
        Map<String, Set<String>> user = new HashMap<>();
        for(String s : id_list){
            user.put(s, new HashSet<>());
        }
        Map<String, Integer> reported = new HashMap<>();
        for(String s : report){
            String[] sc = s.split(" ");
            Set<String> ss = user.get(sc[0]);
            ss.add(sc[1]);
            user.put(sc[0], ss);
        }
        for(String s : user.keySet()){
            Set<String> ss = user.get(s);
            for(String sss : ss){
                reported.put(sss, reported.getOrDefault(sss, 0) + 1);
            }
        }
        List<String> list = new ArrayList<>();
        for(String s : reported.keySet()){
            if(reported.get(s) >= k) list.add(s);
        }

        for(int i = 0 ; i < answer.length ; i++){
            int count = 0;
            Set<String> s = user.get(id_list[i]);
            for(String ss : list){
                if(s.contains(ss)) count++;
            }
            answer[i] = count;
        }

        System.out.println(Arrays.toString(answer));
    }
}
