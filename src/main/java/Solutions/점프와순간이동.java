package Solutions;

public class 점프와순간이동 {
    public static void main(String[] args) {
        int n = 5000;
        int ans = 0;
        int distance = 0;
        int total = 0;
        while(total != n){
            if(distance == 0){
                distance++;
                ans++;
            } else {
                while(total + distance <= n) {
                    distance *= 2;
                }
                total += distance/2;
                distance =0;
            }
            System.out.println("distance: " + distance);
            System.out.println("total: " + total);
            System.out.println("ans: " + ans);
        }
        System.out.println(ans);
    }
}
