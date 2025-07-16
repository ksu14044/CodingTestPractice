package Solutions;

public class 광고삽입 {
    public static void main(String[] args) {
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        String play_time = "02:03:55";
        System.out.println(solution(play_time, adv_time, logs));
    }

    public static String solution(String play_time, String adv_time, String[] logs){
        int playTime = timeToSec(play_time);
        int advTime = timeToSec(adv_time);
        long[] totalView = new long[playTime + 2];
        for(String log : logs){
            String[] times = log.split("-");
            int start = timeToSec(times[0]);
            int end = timeToSec(times[1]);
            totalView[start] += 1;
            totalView[end] -= 1;
        }
        // 1차 누적합 = 시청자 수
        for(int i = 1 ; i < totalView.length ; i++){
            totalView[i] += totalView[i-1];
        }
        // 2차 누적합 = 총 시청시간
        for(int i = 1 ; i < totalView.length ; i++){
            totalView[i] += totalView[i-1];
        }
        long maxView = totalView[advTime-1];
        int startTime = 0;
        for(int i = advTime ; i <= playTime ; i++){
            long curView = totalView[i] - totalView[i - advTime];
            if(curView > maxView){
                maxView = curView;
                startTime = i - advTime + 1;
            }
        }
        return secToString(startTime);
    }

    public static int timeToSec(String time){
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        int sec = Integer.parseInt(times[2]);
        return hour * 3600 + min * 60 + sec;
    }

    public static String secToString(int time){
        int hour = time / 3600;
        int min = (time % 3600) / 60;
        int sec = (time % 3600) % 60;
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
}

// 시간 초과
//public class Solution {
//    public static void main(String[] args) {
//        String play_time = "02:03:55";
//        String adv_time = "00:14:15";
//        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
//        System.out.println(solution(play_time, adv_time, logs));
//    }
//
//    public static String solution(String play_time, String adv_time, String[] logs){
//        int[][] timeLogs = new int[logs.length][2];
//        int playTime = timeToSec(play_time);
//        for(int i = 0 ; i < logs.length ; i++){
//            String cur = logs[i];
//            String[] startToEnd = cur.split("-");
//            timeLogs[i][0] = timeToSec(startToEnd[0]);
//            timeLogs[i][1] = timeToSec(startToEnd[1]);
//        }
//        Arrays.sort(timeLogs, (a, b) -> Integer.compare(a[0], b[0]));
//        int max = 0;
//        List<Integer> times = new ArrayList<>();
//        int advStartTime = 0;
//        times.add(advStartTime);
//        int advEndTime = 0;
//
//        for(int[] arr : timeLogs){
//            advStartTime = arr[0];
//            advEndTime = advStartTime + timeToSec(adv_time);
//            if(advEndTime > playTime) {
//                advEndTime = playTime;
//                advStartTime = advEndTime - timeToSec(adv_time);
//            }
//            int watchingTime = 0;
//            for(int i = 0 ; i < timeLogs.length ; i++){
//                int start = timeLogs[i][0], end = timeLogs[i][1];
//                if(advEndTime < start) continue;
//                if(end < advStartTime) continue;
//                if(advStartTime <= start && end <= advEndTime) watchingTime += (end - start);
//                else if(start < advStartTime && end <= advEndTime) watchingTime += (end - advStartTime);
//                else if(advStartTime <= start && advEndTime < end) watchingTime += (advEndTime - start);
//            }
//            if(max < watchingTime){
//                max = watchingTime;
//                times.add(advStartTime);
//            }
//        }
//        return secToString(times.get(times.size()-1));
//    }
//
//    public static int timeToSec(String time){
//        String[] times = time.split(":");
//        int hour = Integer.parseInt(times[0]);
//        int min = Integer.parseInt(times[1]);
//        int sec = Integer.parseInt(times[2]);
//        return hour * 3600 + min * 60 + sec;
//    }
//
//    public static String secToString(int time){
//        StringBuilder sb = new StringBuilder();
//        int hour = time / 3600;
//        int min = (time % 3600) / 60;
//        int sec = (time % 3600) % 60;
//        if(hour >= 10) {
//            sb.append(hour).append(":");
//        } else sb.append("0").append(hour).append(":");
//        if(min >= 10) {
//            sb.append(min).append(":");
//        } else sb.append("0").append(min).append(":");
//        if(sec >= 10){
//            sb.append(sec);
//        } else sb.append("0").append(min);
//        return sb.toString();
//    }
//}
