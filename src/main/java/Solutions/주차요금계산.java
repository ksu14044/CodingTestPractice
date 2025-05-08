package Solutions;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 주차요금계산 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime end = LocalTime.parse("23:59", dateFormat);

        String[][] splits = new String[records.length][3];
        for(int i = 0 ; i < records.length ; i++){
            for(int j = 0 ; j < 3 ; j++){
                String[] temp = records[i].split(" ");
                splits[i][j] = temp[j];
            }
        }
        Map<String, LocalTime> parkIn = new HashMap<>();
        Map<String, Long> parkedMin = new HashMap<>();

        for(int i = 0 ; i < splits.length ; i++){
            if(splits[i][2].equals("IN")){
                parkIn.put(splits[i][1], LocalTime.parse(splits[i][0], dateFormat));
            } else if(splits[i][2].equals("OUT")){
                parkedMin.put(splits[i][1], parkedMin.getOrDefault(splits[i][1], 0L) + Duration.between(parkIn.get(splits[i][1]), LocalTime.parse(splits[i][0], dateFormat)).toMinutes());
                parkIn.remove(splits[i][1]);
            }
        }
        if(!parkIn.isEmpty()){
            for(String s : parkIn.keySet()){
                parkedMin.put(s, parkedMin.getOrDefault(s, 0L) + Duration.between(parkIn.get(s), end).toMinutes());
                parkIn.remove(s);
            }
        }

        Map<String, Integer> result = new HashMap<>();
        for(String s : parkedMin.keySet()){
            result.put(s, Math.toIntExact(parkedMin.get(s)));
        }

        for(String s : result.keySet()){
            int fee = result.get(s);
            if(fee >= fees[0]) {
                if((fee-fees[0]) % fees[2] != 0){
                    fee = fees[1] + (((fee-fees[0]) / fees[2]) + 1) * fees[3];
                } else {
                    fee = fees[1] + ((fee - fees[0]) / fees[2]) * fees[3];
                }
            } else {
                fee = fees[1];
            }
            result.replace(s, fee);
        }
        String[] carNumbers = result.keySet().toArray(new String[0]);
        Arrays.sort(carNumbers);

        int[] answer = new int[carNumbers.length];
        for(int i = 0 ; i < carNumbers.length ; i++){
            answer[i] = result.get(carNumbers[i]);
        }
    }
}
