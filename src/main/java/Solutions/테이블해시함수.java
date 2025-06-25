package Solutions;

import java.util.Arrays;

public class 테이블해시함수 {
    public static void main(String[] args) {
        int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        int answer = 0;
        Arrays.sort(data, (a, b) -> {
            if(a[col-1] == b[col-1]) return b[0] - a[0];
            return a[col-1] - b[col-1];
        });

        System.out.println(Arrays.deepToString(data));

        for(int i = row_begin ; i <= row_end ; i++){
            int[] d = data[i-1];
            int si = 0;
            for(int dd : d){
                si += dd % (i);
            }
            answer = answer^si;
        }
        System.out.println(answer);
    }
}
