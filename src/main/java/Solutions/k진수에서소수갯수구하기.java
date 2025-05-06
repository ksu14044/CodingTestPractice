package Solutions;

public class k진수에서소수갯수구하기 {
    public static void main(String[] args) {
        int n = 110011;
        int k = 10;
        int answer = 0;
        String[] converted = Integer.toString(n, k).split("0");
        for(String a : converted) {
            if(!a.isEmpty()){
                int num = Integer.parseInt(a);
                if( num > 1 && isPrime(num)){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean isPrime(int n) {
        if(n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
