package Solutions;

import java.util.Scanner;

public class 설탕배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 설탕의 무게

        int answer = -1;
        for (int i = N / 5; i >= 0; i--) {
            int remain = N - i * 5;
            if (remain % 3 == 0) {
                answer = i + (remain / 3);
                break;
            }
        }
        System.out.println(answer);
    }
}