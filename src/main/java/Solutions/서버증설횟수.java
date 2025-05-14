package Solutions;

import java.util.Arrays;

public class 서버증설횟수 {
    public static void main(String[] args) {
        int[] players ={0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int answer = 0;
        int[] need = new int[players.length];
        int m = 3;
        int k = 5;
        for(int i = 0 ; i < players.length ; i++){
            int available = need[i] * m + (m-1);
            if(players[i] > available){
                int needServer = (players[i] - available) % m == 0 ? (players[i] - available) / m : (players[i] - available) / m + 1;
                answer += needServer;
                for(int j = i ; j < i + k ; j++){
                    if(j < need.length){
                        need[j] += needServer;
                    }
                }
            }
        }
        System.out.println(answer);
        System.out.println(Arrays.toString(need));
    }
}
