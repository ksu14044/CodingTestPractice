package Solutions;

public class 점찍기 {
    public static void main(String[] args) {
        int k = 2;
        int d = 4;
        long answer = 0;
        for(long x = 0 ; x <= d ; x += k){
            long maxY = (long) Math.sqrt((long)d*d - x*x);
            answer += (maxY / k) + 1;
        }
        System.out.println(answer);
    }
}
