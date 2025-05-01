package Solutions;

public class 행렬의곱셈 {
    public static void main(String[] args) {
        int[][] arr1 = {{2,3,2},{4,2,4},{3,1,4}};
        int[][] arr2 = {{5,4,3},{2,4,1},{3,1,1}};
        // return {{22,22,11},{36,28,18},{29,20,14}};
        int[][] answer = new int[arr1.length][arr2[0].length];

//        2 3 2   5 4 3
//        4 2 4   2 4 1
//        3 1 4   3 1 1
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0 ; j < arr2[0].length ; j++){
                int sum = 0;
                for(int k = 0 ; k < arr1[0].length ; k++){
                    sum += arr2[k][j] * arr1[i][k];
                }
                answer[i][j] = sum;
            }
        }

        for(int[] a : answer){
            for(int a1 : a){
                System.out.print(a1 + " ");
            }
        }

    }
}
