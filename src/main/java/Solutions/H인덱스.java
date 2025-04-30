package Solutions;

import java.util.Arrays;

public class H인덱스 {
    public static void main(String[] args) {
        int[] citations = {3, 0, 1, 5, 6};
        H인덱스 T = new H인덱스();
        System.out.println(T.getHIndex(citations));
    }
    public int getHIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for(int i = 0; i < n ; i++){
            int h = n - i;
            if(citations[i] >= h){
                return h;
            }
        }
        return 0;
    }
}
