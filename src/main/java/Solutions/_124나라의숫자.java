package Solutions;

public class _124나라의숫자 {
    public static void main(String[] args) {
        int n = 5;
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            int remain = n % 3;
            n /= 3;
            if(remain == 0){
                sb.append("4");
                n--;
            } else if(remain == 1){
                sb.append("1");
            } else {
                sb.append("2");
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
