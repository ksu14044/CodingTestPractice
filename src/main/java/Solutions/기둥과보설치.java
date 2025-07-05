package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기둥과보설치 {
    static List<int[]> structure = new ArrayList<>();
    public static void main(String[] args) {
        int[][] build_frame = {
                {1, 0, 0, 1},
                {1, 1, 1, 1},
                {2, 1, 0, 1},
                {2, 2, 1, 1},
                {5, 0, 0, 1},
                {5, 1, 0, 1},
                {4, 2, 1, 1},
                {3, 2, 1, 1}
        };
        int n = 5;
        System.out.println(Arrays.deepToString(solution(n, build_frame)));
    }
    public static int[][] solution(int n, int[][] build_frame){
        for(int[] bf : build_frame){
            int x = bf[0], y = bf[1], a = bf[2], b = bf[3];
            if(b == 1){
                structure.add(new int[]{x, y, a});
                if(!isValid()){
                    structure.remove(structure.size()-1);
                }
            } else {
                int[] removeS = new int[]{x, y, a};
                structure.removeIf(s -> Arrays.equals(s, removeS));
                if(!isValid()){
                    structure.add(removeS);
                }
            }
        }
        structure.sort((o1, o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[2] - o2[2];
        });

        return structure.toArray(new int[structure.size()][]);
    }

    public static boolean isValid(){
        for(int[] s : structure){
            int x = s[0], y = s[1], a = s[2];
            if(a == 0){
                if(y == 0 || exist(x, y-1, 0) || exist(x-1, y, 1) || exist(x, y, 1)) continue;
                return false;
            } else {
                if((exist(x-1, y, 1) && exist(x+1, y, 1)) || (exist(x, y-1, 0) || exist(x+1, y-1, 0))) continue;
                return false;
            }
        }
        return true;
    }

    public static boolean exist(int x, int y, int a){
        for(int[] s : structure){
            if(s[0] == x && s[1] == y && s[2] == a){
                return true;
            }
        }
        return false;
    }

}
