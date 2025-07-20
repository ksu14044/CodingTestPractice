package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 표병합 {
    static final int SIZE = 51;
    static int[] parent = new int[SIZE*SIZE];
    static String[] values = new String[SIZE*SIZE];

    public static void main(String[] args) {
        String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean",
                "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle",
                "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle",
                "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group",
                "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
        System.out.println(Arrays.toString(solution(commands)));
    }

    public static String[] solution(String[] commands){

        for(int i = 0 ; i < SIZE*SIZE ; i++){
            parent[i] = i;
            values[i] = "";
        }

        List<String> answer = new ArrayList<>();

        for(String command : commands){
            String[] parts = command.split(" ");
            switch (parts[0]){
                case "UPDATE" :
                    if(parts.length == 4){
                        int r = Integer.parseInt(parts[1]);
                        int c = Integer.parseInt(parts[2]);
                        String value = parts[3];
                        update(r, c, value);
                    } else if(parts.length == 3){
                        String value1 = parts[1];
                        String value2 = parts[2];
                        updateAll(value1, value2);
                    }
                    break;
                case "MERGE" :
                    int r1 = Integer.parseInt(parts[1]);
                    int c1 = Integer.parseInt(parts[2]);
                    int r2 = Integer.parseInt(parts[3]);
                    int c2 = Integer.parseInt(parts[4]);
                    merge(r1, c1, r2, c2);
                    break;
                case "UNMERGE" :
                    int r = Integer.parseInt(parts[1]);
                    int c = Integer.parseInt(parts[2]);
                    unmerge(r, c);
                    break;
                case "PRINT" :
                    r = Integer.parseInt(parts[1]);
                    c = Integer.parseInt(parts[2]);
                    answer.add(print(r, c));
                    break;
            }
        }
        return answer.toArray(new String[0]);
    }

    public static void update(int r, int c, String val){
        int idx = getIndex(r, c);
        int root = find(idx);
        values[root] = val;
    }

    public static void updateAll(String value1, String value2){
        for(int i = 0 ; i < SIZE*SIZE ; i++){
            if(parent[i] == i && values[i].equals(value1)){
                values[i] = value2;
            }
        }
    }

    public static void merge(int r1, int c1, int r2, int c2){
        int i1 = getIndex(r1, c1);
        int i2 = getIndex(r2, c2);
        int p1 = find(i1);
        int p2 = find(i2);
        if(p1 == p2) return;
        String mergedValue =  values[p1].isEmpty() ? values[p2] : values[p1];
        parent[p2] = p1;
        for(int i = 0 ; i < SIZE*SIZE ; i++){
            if(find(i) == p2){
                parent[i] = p1;
            }
        }
        values[p1] = mergedValue;
        values[p2] = "";
    }

    public static void unmerge(int r, int c){
        int idx = getIndex(r, c);
        int root = find(idx);
        String currentValue = values[root];

        List<Integer> group = new ArrayList<>();
        for(int i = 0 ; i < SIZE*SIZE ; i++){
            if(find(i) == root){
                group.add(i);
            }
        }
        for(int i : group){
            parent[i] = i;
            values[i] = "";
        }
        values[idx] = currentValue;
    }

    public static String print(int r, int c){
        int idx = getIndex(r, c);
        int root = find(idx);
        return values[root].isEmpty() ? "EMPTY" : values[root];
    }

    public static int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public static int getIndex(int r, int c){
        return (r-1) * SIZE + (c - 1);
    }
}
