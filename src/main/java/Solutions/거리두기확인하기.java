package Solutions;

import java.util.*;

public class 거리두기확인하기 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) {
        String[][] places = new String[][] {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        int[] answer = new int[places.length];
        for(int i = 0 ; i < places.length ; i++){
            if(isValid(places[i])){
                answer[i] = 1;
            } else answer[i] = 0;
        }
        System.out.println(Arrays.toString(answer));
    }

    public static boolean isValid(String[] place){
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                if(place[i].charAt(j) == 'P'){
                    if(!bfs(i, j, place)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean bfs(int x, int y, String[] place){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1], dist = cur[2];
            for(int i = 0 ; i < 4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                char next = place[nx].charAt(ny);
                if(next == 'P' && dist + 1 <= 2) return false;
                if(next == 'O' && dist + 1 < 2) q.offer(new int[]{nx, ny, dist + 1});
            }
        }
        return true;
    }
}
// 정확성 실패
//public class Solution {
//    static int[] dx = {0, 1, 0, -1};
//    static int[] dy = {1, 0, -1, 0};
//    static int m, n;
//    public static void main(String[] args) {
//        String[][] places = new String[][] {
//                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
//                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
//                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
//                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
//                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
//        };
//        m = places.length;
//        n = places[0].length;
//        int[] answer = new int[places.length];
//
//        for(int i = 0 ; i < places.length ; i++){
//            String[] place = places[i];
//            String[][] result = makeStringArr(place);
//            boolean valid = true;
//            for(int x = 0 ; x < result.length ; x++){
//                for(int y = 0 ; y < result[x].length ; y++){
//                    if(result[x][y].equals("P")){
//                        boolean[][] visited = new boolean[m][n];
//                        visited[x][y] = true;
//                        if(!dfs(result, x, y, visited, 0)){
//                            valid = false;
//                            break;
//                        }
//                    }
//                }
//                if(!valid) break;
//            }
//            answer[i] = valid ? 1 : 0;
//        }
//        System.out.println(Arrays.toString(answer));
//    }
//
//    public static String[][] makeStringArr(String[] place){
//        String[][] result = new String[place.length][place[0].length()];
//        for(int i = 0 ; i < place.length ; i++){
//            String[] temp = place[i].split("");
//            result[i] = temp;
//        }
//        return result;
//    }
//
//    public static boolean dfs(String[][] result, int x, int y, boolean[][] visited, int dist){
//        if(dist > 0 && result[x][y].equals("P") && dist <= 2) return false;
//        if(dist >= 2 || result[x][y].equals("X")) return true;
//        boolean answer = false;
//        for(int i = 0 ; i < 4 ; i++){
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//            if(nx >= 0 && nx < m && ny >= 0 && ny < n){
//                if(!visited[nx][ny]){
//                    visited[nx][ny] = true;
//                    answer = dfs(result, nx, ny, visited, dist + 1);
//                    visited[nx][ny] = false;
//                }
//            }
//        }
//        return answer;
//    }
//}
