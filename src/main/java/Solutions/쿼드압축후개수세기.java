package Solutions;

public class 쿼드압축후개수세기 {
    static int countZero = 0;
    static int countOne = 0;
    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int n = arr.length;
        dfs(arr, 0, 0, n);
        System.out.println(countZero);
        System.out.println(countOne);
    }

    public static void dfs(int[][] arr, int x, int y, int n){
        if(canUniform(arr, x, y, n)){
            if(arr[x][y] == 0){
                countZero++;
            } else {
                countOne++;
            }
            return;
        }
        int half = n / 2;
        dfs(arr, x, y, half);
        dfs(arr, x + half, y, half);
        dfs(arr, x, y + half, half);
        dfs(arr, x + half, y + half, half);
    }

    public static boolean canUniform(int[][] arr, int x, int y, int size){
        for(int i = x ; i < x + size ; i++){
            for(int j = y ; j < y + size ; j++){
                if(arr[i][j] != arr[x][y]){
                    return false;
                }
            }
        }
        return true;
    }
}
