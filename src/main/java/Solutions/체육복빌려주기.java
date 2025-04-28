package Solutions;

import java.util.Arrays;

public class 체육복빌려주기 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};

        int[] dy = new int[n+1];
        Arrays.fill(dy,1);
        for(int i = 0 ; i < reserve.length ; i++){
            dy[reserve[i]]++;
        }
        for(int i = 0 ; i < lost.length ; i++){
            dy[lost[i]]--;
        }
        for(int i = 1; i < dy.length ; i++) {
            if(dy[i] == 0 && dy[i-1] == 2){
                dy[i] = 1;
                dy[i-1] = 1;
            } else if (dy[i] == 0 && dy[i+1] == 2) {
                dy[i] = 1;
                dy[i+1] = 1;
            }
        }
        int count = 0;
        for(int i = 1; i < dy.length ; i++) {
            if(dy[i] >= 1){
                count++;
            }
        }
    }
}
