package Solutions;

public class 기사단원의무기 {
    public static void main(String[] args) {
        int n = 10;
        int limit = 3;
        int power = 2;
        int[] swords = new int[n + 1];
        for(int i = 1; i <= n ; i++){
            swords[i] = divisorCount(i);
        }
        for(int i = 1; i <= n ; i++){
            if(swords[i] > limit){
                swords[i] = power;
            }
        }
        int sum = 0;
        for(int i = 1; i <= n ; i++){
            sum += swords[i];
        }
        System.out.println(sum);
    }

    public static int divisorCount(int n){
        int count = 0;
        for(int i = 1; i*i <= n ; i ++){
            if(n % i == 0){
                count++;
                if( i != n / i){
                    count++;
                }
            }
        }
        return count;
    }
}
