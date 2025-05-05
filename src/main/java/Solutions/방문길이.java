package Solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 방문길이 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Set<String> paths = new HashSet<>();
        String dirs = "LULLLLLLU";
        char[] chars = dirs.toCharArray();
        int x = 0; int y = 0;
        List<Integer> indexes = new ArrayList<>();
        int move = 0;
        for(char c : chars) {
            switch(c){
                case 'L':
                    indexes.add(0);
                    break;
                case 'U':
                    indexes.add(1);
                    break;
                case 'D':
                    indexes.add(3);
                    break;
                case 'R':
                    indexes.add(2);
                    break;
            }
        }
        for(int i : indexes){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if( nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5){
                continue;
            } else {
                String forwardPath = x + "," + y + "->" + nextX + "," + nextY;
                String backwardPath = nextX + "," + nextY + "->" + x + "," + y;
                if(!paths.contains(forwardPath)){
                    paths.add(forwardPath);
                    paths.add(backwardPath);
                }
                x = nextX;
                y = nextY;
            }
        }
        System.out.println(paths.size());
    }
}
