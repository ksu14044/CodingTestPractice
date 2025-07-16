package Solutions;

public class 택배배달과수거하기 {
    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1,0,3,1,2};
        int[] pickups = {0,3,0,4,0};
        System.out.println(solution(cap, n, deliveries, pickups));
    }
    public static long solution(int cap, int n, int[] deliveries, int[] pickups){
        long totalDist = 0;
        int dRemain = 0;
        int pRemain = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            dRemain += deliveries[i];
            pRemain += pickups[i];
            while(dRemain > 0 || pRemain > 0){
                totalDist += (i+1) *2L;
                dRemain -= cap;
                pRemain -= cap;
            }
        }
        return totalDist;
    }
}
