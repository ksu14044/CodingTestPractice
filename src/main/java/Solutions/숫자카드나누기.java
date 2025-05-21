package Solutions;

public class 숫자카드나누기 {
    public static void main(String[] args) {
        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};
        int gcdA = getGCD(arrayA);
        int gcdB = getGCD(arrayB);

        int resultA = canDivideAll(arrayB, gcdA) ? gcdA : 0;
        int resultB = canDivideAll(arrayA, gcdB) ? gcdB : 0;
        System.out.println(Math.max(resultA, resultB));
    }

    public static int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static int getGCD(int[] arr){
        int result = arr[0];
        for(int num : arr){
            result = gcd(result, num);
        }
        return result;
    }

    public static boolean canDivideAll(int[] arr, int divisor){
        for(int num : arr){
            if(num % divisor == 0){ return false;}
        }
        return true;
    }
}
