package Solutions;

import java.util.HashMap;
import java.util.Map;

public class 오픈채팅방 {
    public static void main(String[] args) {
        String[] records = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        int answerCount = 0;
        Map<String, String> map = new HashMap<>();
        for(String record : records){
            String[] splited = record.split(" ");
            if(map.containsKey(splited[1]) && (splited[0].equals("Change") || splited[0].equals("Enter"))){
                map.replace(splited[1], splited[2]);
            } else if (!map.containsKey(splited[1])) {
                map.put(splited[1], splited[2]);
            }
            if(splited[0].equals("Leave") || splited[0].equals("Enter")){
                answerCount++;
            }
        }
        String[] answer = new String[answerCount];
        int idx = 0;
        for(int i = 0 ; i < records.length ; i++){
            String[] splited = records[i].split(" ");
            if(splited[0].equals("Enter")){
                answer[idx] = map.get(splited[1]) + "님이 들어왔습니다.";
                idx++;
            } else if (splited[0].equals("Leave")) {
                answer[idx] = map.get(splited[1]) + "님이 나갔습니다.";
                idx++;
            }
        }

        for(String s : answer){
            System.out.println(s);
        }
    }
}
