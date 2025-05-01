package Solutions;

import java.util.*;

public class 연속부분수열합의갯수 {
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        Set<Integer> ans = new HashSet<Integer>();
        int n = elements.length;
        for(int count = 1; count <= n ; count++){
            for(int i = 0 ; i < n ; i++){
                int sum = 0;
                for(int j = 0 ; j < count ; j++){
                    sum += elements[(i+j)%n];
                }
                ans.add(sum);
            }
        }
        System.out.println(ans);


    }
}
