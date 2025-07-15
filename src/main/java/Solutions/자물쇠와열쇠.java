package Solutions;

public class 자물쇠와열쇠 {
    static int M, N, Length;
    public static void main(String[] args) {
        int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
        int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};
        System.out.println(solution(key, lock));
    }
    public static boolean solution(int[][] key, int[][] lock){
        M = key.length;
        N = lock.length;
        Length = N + (M - 1) * 2;
        int[][] arr = new int[Length][Length];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                arr[i+M-1][j+M-1] = lock[i][j];
            }
        }
        if(check(arr)) return true;
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j <= Length - M ; j++){
                for(int k = 0 ; k <= Length - M ; k++){
                    for(int l = 0 ; l < M ; l++){
                        for(int m = 0 ; m < M ; m++){
                            arr[l+j][k+m] += key[l][m];
                        }
                    }
                    if(check(arr)) return true;
                    for(int l = 0 ; l < M ; l++){
                        for(int m = 0; m < M ; m++){
                            arr[l+j][k+m] -= key[l][m];
                        }
                    }
                }
            }
            key = rotate(key);
        }
        return false;
    }

    public static boolean check(int[][] arr){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++) {
                if(arr[i+M-1][j+M-1] != 1) return false;
            }
        }
        return true;
    }

    public static int[][] rotate(int[][] key){
        int m = key.length;
        int n = key[0].length;
        int[][] rotate = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                rotate[i][j] = key[m-1-j][i];
            }
        }
        return rotate;
    }
}
