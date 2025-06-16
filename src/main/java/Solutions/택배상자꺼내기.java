package Solutions;

public class 택배상자꺼내기 {
    static int x, y;
    public static void main(String[] args) {
        int n = 22;
        int w = 6;
        int num = 8;
        System.out.println(solution(n, w, num));
    }

    public static int solution(int n, int w, int num){
        int r = (n + w - 1) / w;
        int[][] boxes = new int[r][w];
        int a = 1;
        for(int i = 0 ; i < r ; i ++){
            for(int j = 0 ; j < w ; j++){
                if(a > n) boxes[i][j] = 0;
                else boxes[i][j] = a++;
            }
            if(i % 2 == 1){
                for(int j = 0 ; j < w /2 ; j++){
                    int temp = boxes[i][j];
                    boxes[i][j] = boxes[i][w - 1 - j];
                    boxes[i][w - 1 - j] = temp;
                }
            }
        }
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < w ; j++){
                if(boxes[i][j] == num){
                    x = i;
                    y = j;
                }
            }
        }
        int answer = 0;
        for(int i = x ; i < r ; i++){
            if(boxes[i][y] != 0) answer++;
        }
        return answer;
    }
}
