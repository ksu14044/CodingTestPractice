package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 간단한유니온파인드알고리즘구현하기 {
    static int[] parent;

    public static void main(String[] args) {
        int[][] operation = {{0,0,1}, {1,1,2}, {0,1,2}, {1,0,2}};
        int k = 3;
        parent = new int[k];
        for(int i = 0 ; i < k ; i++){
            parent[i] = i;
        }
        List<Boolean> answer = new ArrayList<>();
        for(int[] o : operation){
            if(o[0] == 0){
                System.out.println(Arrays.toString(parent));
                union(o[1], o[2]);
            } else if(o[0] == 1){
                System.out.println(Arrays.toString(parent));
                answer.add(find(o[1]) == find(o[2]));
            }
        }
        System.out.println(answer);
    }

    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int x, int y){
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
}
