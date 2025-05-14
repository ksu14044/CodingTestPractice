package Solutions;

public class 평행 {
    public static void main(String[] args) {
        int answer = 0;
        int[][] dots = {{1,4}, {9,2}, {3,8}, {11, 6}};
        if(isParallel(dots[0], dots[1], dots[2], dots[3])) answer = 1;
        if(isParallel(dots[0], dots[2], dots[1], dots[3])) answer = 1;
        if(isParallel(dots[0], dots[3], dots[2], dots[1])) answer = 1;

        System.out.println(answer);
    }
    public static boolean isParallel(int[] dot1, int[] dot2, int[] dot3, int[] dot4){
        int dx1 = dot1[0] - dot2[0];
        int dy1 = dot1[1] - dot2[1];
        int dx2 = dot3[0] - dot4[0];
        int dy2 = dot3[1] - dot4[1];

        return dx1 * dy2 == dx2 * dy1;
    }
}
