package Solutions;

public class n제곱배열자르기 {
    public static void main(String[] args) {
        int n = 3;
        int left = 2;
        int right = 5;

        //행 번호 = 몫 / 열 번호 = 나머지
        int[] answer = new int[right-left+1];
        int index = 0;
        for(int i = left ; i <= right ; i++){
            int row = i / n;
            int col = i % n;
            int num = Math.max(row+1,col+1);
            answer[index] = num;
            index++;
        }
        for(int a : answer){
            System.out.print(a + " ");
        }

        // 메모리 초과
//        int[][] arr = new int[n][n];
//        for(int i = 0 ; i < n ; i++){
//            for(int j = 0 ; j < n ; j++){
//                arr[i][j] = Math.max(i+1, j+1);
//            }
//        }
//        int[] newArr = new int[n*n];
//        int k = 0;
//        for(int i = 0 ; i < n ; i++) {
//            for(int j = 0 ; j < n ; j++){
//                newArr[k] = arr[i][j];
//                k++;
//            }
//        }
//        int[] ans = new int[right-left+1];
//        int ansIndex = 0;
//        for(int p = left ; p <= right ; p++) {
//            ans[ansIndex] = newArr[p];
//            ansIndex++;
//        }
//
//        for(int a : ans) {
//            System.out.print(a + " ");
//        }

    }
}
