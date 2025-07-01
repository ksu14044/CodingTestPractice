package Solutions;

public class 두원사이의정수쌍 {
    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;
        System.out.println(solution(r1, r2));
    }
    public static long solution(int r1, int r2){
        long answer = 0;
        for(int i = 1 ; i <= r2 ; i++){
            int yMax = (int)Math.floor(Math.sqrt((long)r2*r2 - (long)i * i));
            int yMin = 0;
            if(i < r1){
                yMin = (int)Math.ceil(Math.sqrt((long)r1*r1 - (long)i * i));
            }
            answer += yMax - yMin + 1;
        }
        return answer*4;
    }
}
