package Solutions;

public class 멀쩡한사각형 {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(solution(w,h));
    }

    public static int gcd(int w, int h){
        while(w % h != 0){
            int temp = w;
            w = h;
            h = temp % h;
        }
        return h;
    }

    public static long solution(int w, int h){
        long total = (long) w * h;
        long minus = w + h - gcd(w, h);
        return total - minus;
    }
}
