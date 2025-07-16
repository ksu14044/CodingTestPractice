package Solutions;

import java.util.Arrays;

public class 표현가능한이진트리 {
    public static void main(String[] args) {
        int[] numbers = {7, 42, 5};
        System.out.println(Arrays.toString(solution(numbers)));
    }
    public static int[] solution(int[] numbers){
        int[] answer = new int[numbers.length];
        for(int i = 0 ; i < answer.length ; i++){
            String binary = Long.toBinaryString(numbers[i]);
            int len = binary.length();
            int fullLength = 1;
            while(fullLength - 1 < len){
                fullLength *= 2;
            }
            fullLength -= 1;
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < fullLength - len; j++){
                sb.append("0");
            }
            sb.append(binary);
            String padded = sb.toString();
            answer[i] = isValid(padded) ? 1 : 0;
        }
        return answer;
    }

    public static boolean isValid(String s){
        if(s.length() == 1) return true;
        int mid = s.length() / 2;
        char root = s.charAt(mid);
        String left = s.substring(0, mid);
        String right = s.substring(mid+1);
        if(root == '0') return !left.contains("1") && !right.contains("1");
        return isValid(left) && isValid(right);
    }

}
