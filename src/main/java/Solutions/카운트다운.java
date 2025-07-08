package Solutions;

import java.util.*;

public class 카운트다운 {
    public static void main(String[] args) {
        int target = 58;
        int[] dpDart = new int[target+1];
        int[] dpSingle = new int[target + 1];
        Arrays.fill(dpDart, Integer.MAX_VALUE);
        dpDart[0] = 0;
        for(int i = 1 ; i <= target ; i++){
            for(int j = 1 ; j <= 20 ; j++){
                if(i-j >= 0 && dpDart[i-j] + 1 <= dpDart[i]){
                    if(dpDart[i-j] + 1 < dpDart[i] || dpSingle[i-j] + 1 > dpSingle[i]){
                        dpDart[i] = dpDart[i-j] + 1;
                        dpSingle[i] = dpSingle[i-j] + 1;
                    }
                }
            }

            if(i - 50 >= 0 && dpDart[i - 50] + 1 <= dpDart[i]){
                if(dpDart[i-50] + 1 < dpDart[i] || dpSingle[i-50] + 1 > dpSingle[i]){
                    dpDart[i] = dpDart[i-50] + 1;
                    dpSingle[i] = dpSingle[i-50] + 1;
                }
            }

            for(int j = 1; j <= 20 ; j++){
                int d = j * 2;
                if(i - d >= 0 && dpDart[i-d] + 1 < dpDart[i]){
                    dpDart[i] = dpDart[i-d] + 1;
                    dpSingle[i] = dpSingle[i-d];
                }
            }

            for(int j = 1; j <= 20 ; j++){
                int t = j * 3;
                if(i - t >= 0 && dpDart[i-t] + 1 < dpDart[i]){
                    dpDart[i] = dpDart[i-t] + 1;
                    dpSingle[i] = dpSingle[i-t];
                }
            }
        };
        System.out.println(dpDart[target]);
        System.out.println(dpSingle[target]);
    }
}
