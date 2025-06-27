package Solutions;

import java.util.Arrays;

public class 셔틀버스 {
    public static void main(String[] args) {
        int n = 2;
        int t = 10;
        int m = 2;
        String[] timetable = {"09:10", "09:09", "08:00"};

        int[] times = new int[timetable.length];
        for(int i = 0 ; i < times.length ; i++){
            String[] time = timetable[i].split(":");
            int hour = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);
            times[i] = 60*hour + min;
        }
        Arrays.sort(times);
        System.out.println(Arrays.toString(times));

        int bustime = 540;
        int idx = 0;
        int last = 0;

        for(int i = 0 ; i < n ; i++){
            int board = 0;
            while(idx < times.length && times[idx] <= bustime && board < m){
                last = times[idx];
                idx++;
                board++;
            }
            if(i == n - 1){
                if(board < m){
                    last = bustime;
                } else last -= 1;
            }
            bustime += t;
        }
        System.out.println(last);
        int hour = last / 60;
        int min = last % 60;
        System.out.println(String.format("%02d:%02d", hour, min));
    }
}
