package Solutions;

import java.util.*;
// 성공 => 팩토리얼 문제 == 수학적으로 접근
public class 줄서는방법 {
    public static void main(String[] args) {
        int n = 3;
        long k = 5;
        List<Integer> numbers = new ArrayList<>();
        long fact = 1;
        for(int i = 1 ; i <= n ; i++){
            numbers.add(i);
            fact *= i;
        }
        int[] answer = new int[n];
        k--;
        for(int i = 0 ; i < n ; i++){
            fact /= (n - i);
            int index = (int)(k / fact);
            answer[i] = numbers.get(index);
            numbers.remove(index);
            k %= fact;
        }
        System.out.println(Arrays.toString(answer));
    }
}
// 효율성 검사 실패 2
//public class Solution {
//    static boolean found = false;
//    static int count = 0;
//    static List<Integer> answer;
//    public static void main(String[] args) {
//        int n = 3;
//        long k = 5;
//        boolean[] visited = new boolean[n + 1];
//        dfs(n, k, new ArrayList<>(), visited);
//        System.out.println(answer);
//    }
//
//    public static void dfs(int n, long k, List<Integer> list, boolean[] visited){
//        if(found) return;
//        if(list.size() == n){
//            count++;
//            if(count == k) {
//                answer = new ArrayList<>(list);
//                found = true;
//            }
//            return;
//        }
//        for(int i = 1 ; i <= n ; i++){
//            if(!visited[i]){
//                visited[i] = true;
//                list.add(i);
//                dfs(n, k, list, visited);
//                visited[i] = false;
//                list.remove(list.size() - 1);
//            }
//        }
//    }
//}
// 효율성 실패 1
//public class Solution {
//    static List<List<Integer>> result = new ArrayList<>();
//    public static void main(String[] args) {
//        int n = 3;
//        long k = 5;
//        boolean[] visited = new boolean[n+1];
//
//        dfs( n, visited, new ArrayList<>());
//
//        int m = result.size();
//        List<List<Integer>> list = new ArrayList<>();
//        for(List<Integer> l : result){
//            list.add(new ArrayList<>(l));
//        }
//        System.out.println(list.get((int)k-1));
//
//    }
//
//    public static void dfs( int n, boolean[] visited, List<Integer> list) {
//        if(list.size() == n){
//            result.add(new ArrayList<>(list));
//        } else {
//            for(int i = 1 ; i <= n ; i++){
//                if(!visited[i]){
//                    visited[i] = true;
//                    list.add(i);
//                    dfs(n, visited, list);
//                    list.remove(list.size()-1);
//                    visited[i] = false;
//                }
//            }
//        }
//    }
//}
