package Solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 프렌즈4블록 {
    public static void main(String[] args) {
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int m = 6;
        int n = 6;
        char[][] map = new char[m][n];
        for(int i = 0 ; i < board.length ; i ++){
            map[i] = board[i].toCharArray();
        }
        int[] dx = {0, 1, 1};
        int[] dy = {1, 0, 1};

        boolean isValid = true;
        int removedCount = 0;

        while(isValid) {
            isValid = false;
            Set<String> toRemove = new HashSet<>();
            for (int i = 0; i < map.length - 1; i++) {
                for (int j = 0; j < map[i].length - 1; j++) {
                    char t = map[i][j];
                    if (t == '0') continue;
                    int count = 1;
                    for (int k = 0; k < dx.length; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (map[nx][ny] == t) {
                            count++;
                        }
                    }
                    if (count == 4) {
                        toRemove.add(i + "," + j);
                        for (int k = 0; k < dx.length; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            toRemove.add(nx + "," + ny);
                        }
                        isValid = true;
                    }
                }
            }
            for (String pos : toRemove) {
                String[] parts = pos.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                if (map[x][y] != '0') {
                    map[x][y] = '0';
                    removedCount++;
                }
            }

            for (int j = 0; j < n; j++) {
                List<Character> temp = new ArrayList<>();
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != '0') {
                        temp.add(map[i][j]);
                    }
                }
                int index = m - 1;
                for (char c : temp) {
                    map[index--][j] = c;
                }
                while (index >= 0) {
                    map[index--][j] = '0';
                }
            }
        }
            System.out.println(removedCount);
    }
}
