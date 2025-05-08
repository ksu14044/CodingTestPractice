package Solutions;

import java.util.Arrays;

public class 숫자게임 {
    public static void main(String[] args) {
        int[] a = {5,1,3,7};
        int[] b = {2,2,6,8};
        Arrays.sort(a);
        Arrays.sort(b);
        int answer = 0;
        int ltA = 0;
        int ltB = 0;
        while(ltA < a.length && ltB < b.length){
            if(a[ltA] < b[ltB]){
                answer++;
                ltA++;
                ltB++;
            } else {
                ltB++;
            }
        }
        System.out.println(answer);
    }
}
