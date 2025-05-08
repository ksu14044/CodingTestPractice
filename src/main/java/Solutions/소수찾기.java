package Solutions;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    public static void main(String[] args) {
        String numbers = "011";
        int answer = 0;
        char[] num = numbers.toCharArray();
        int[] number = new int[num.length];
        for(int i = 0; i < num.length; i++) {
            number[i] = Integer.parseInt(String.valueOf(num[i]));
        }
        Set<Integer> resultSet = new HashSet<>();
        dfs("", number, new boolean[number.length], resultSet);
        System.out.println(resultSet);
        for(int a : resultSet){
            if(isPrime(a)){
                answer++;
            }
        }
        System.out.println(answer);

    }

    static void dfs(String current, int[] number, boolean[] isVisited, Set<Integer> resultSet){
        if(!current.isEmpty()){
            resultSet.add(Integer.parseInt(current));
        }
        for(int i = 0 ; i < number.length; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                dfs(current + number[i], number, isVisited, resultSet);
                isVisited[i] = false;
            }
        }
    }





    public static boolean isPrime(int n){
        if(n < 2) return false;
        for(int i = 2 ; i <= Math.sqrt(n) ; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
