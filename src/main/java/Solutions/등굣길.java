package Solutions;

public class 등굣길 {

    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int[][] puddles = {{2, 2}};
        int[][] path = new int[n][m];

        for(int[] puddle : puddles){
            int x = puddle[0] - 1;
            int y = puddle[1] - 1;
            path[x][y] = -1;
        }
        path[0][0] = 1;

        for(int i = 0 ; i < path.length ; i++){
            for(int j = 0 ; j < path[i].length ; j++){
                if(path[i][j] == -1){
                    continue;
                }
                if(i > 0 && path[i-1][j] != -1){
                    path[i][j] += path[i-1][j];
                }
                if(j > 0 && path[i][j-1] != -1){
                    path[i][j] += path[i][j-1];
                }
                path[i][j] %= 1000000007;
            }
        }
        System.out.println(path[n-1][m-1]);
    }
}
