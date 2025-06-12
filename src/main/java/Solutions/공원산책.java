package Solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 공원산책 {
    static char[][] board;
    static int x, y;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) {
        String[] park = {"SOO", "OOO", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};
        System.out.println(Arrays.toString(solution(park, routes)));
    }

    public static int[] solution(String[] park, String[] routes){
        board = new char[park.length][park[0].length()];
        for(int i = 0; i < park.length; i++){
            board[i] = park[i].toCharArray();
        }

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                if(board[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("E", 0);
        map.put("W", 1);
        map.put("S", 2);
        map.put("N", 3);

        for(int i = 0 ; i < routes.length ; i++){
            String[] route = routes[i].split(" ");
            int dir = map.get(route[0]);
            int dist = Integer.parseInt(route[1]);
            int tempX = x;
            int tempY = y;
            for(int j = 0 ; j < dist ; j++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length || board[nx][ny] == 'X'){
                    x = tempX;
                    y = tempY;
                    break;
                } else {
                    x = nx;
                    y = ny;
                }
            }
        }

        return new int[]{x, y};
    }
}
