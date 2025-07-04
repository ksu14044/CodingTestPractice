package Solutions;

public class 미로탈출명령어 {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] ds = {"d", "l", "r", "u"};
    static String answer = "impossible";
    static boolean found = false;

    public static void main(String[] args) {
        int n = 3, m = 4, x = 2, y = 3, r = 3, c = 1, k = 5;
        System.out.println(solution(n, m, x, y, r, c, k));
    }
    public static String solution(int n, int m, int x, int y, int r, int c, int k){
        int dist = Math.abs(r - x) + Math.abs(c - y);
        if( dist > k ) return answer;
        if((k - dist) % 2 != 0) return answer;
        dfs(n, m, x, y, r, c, new StringBuilder(), k);
        return answer;
    }
    public static void dfs(int n, int m, int x, int y, int r, int c, StringBuilder sb, int k){
        if(found) return;
        int remainDist = Math.abs(r - x) + Math.abs(c - y);
        if(remainDist > k || (k - remainDist) % 2 != 0) return;
        if(k == 0){
            if(x == r && y == c){
                answer = sb.toString();
                found = true;
            }
            return;
        }
        for(int i = 0 ; i < 4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 1 && nx <= n && ny >= 1 && ny <= m){
                sb.append(ds[i]);
                dfs(n, m, nx, ny, r, c, sb, k - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
