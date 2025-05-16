package Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 피자배달거리 {
    public static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int[] combination;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Point> house = new ArrayList<>();
        List<Point> pizza = new ArrayList<>();

        int[][] board = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = sc.nextInt();
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == 1){
                    house.add(new Point(i, j));
                } else if(board[i][j] == 2){
                    pizza.add(new Point(i, j));
                }
            }
        }
        combination = new int[m];

        int len = pizza.size();
        dfs(0, 0, len, m, house, pizza);
        System.out.println(answer);
    }

    public static void dfs(int L, int s, int len, int m, List<Point> house, List<Point> pizza){
        if(L == m){
            int sum = 0;
            for(Point h : house){
                int dis = Integer.MAX_VALUE;
                for(int i = 0 ; i < combination.length ; i++){
                    dis = Math.min(dis, Math.abs(h.x - pizza.get(combination[i]).x) + Math.abs(h.y - pizza.get(combination[i]).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for(int i = s ; i < len ; i++){
                combination[L] = i;
                dfs(L+1, i+1, len, m, house, pizza);
            }
        }
    }
}
