package Solutions;

public class 키패드누르기 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        StringBuilder sb = new StringBuilder();
        String answer = "";
        int[][] keyPad = {{1,2,3}, {4,5,6}, {7,8,9},{-1,0,-2}};
        int[] rp = {3,2};
        int[] lp = {3,0};
        for(int i = 0 ; i < numbers.length ; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] ==7){
                lp = findPosition(keyPad, numbers[i]);
                sb.append("L");
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                rp = findPosition(keyPad, numbers[i]);
                sb.append("R");
            } else {
                int[] p = findPosition(keyPad, numbers[i]);
                int l = Math.abs(p[0] - lp[0]) + Math.abs(p[1] - lp[1]);
                int r = Math.abs(p[0] - rp[0]) + Math.abs(p[1] - rp[1]);
                if(l > r) {
                    rp = p;
                    sb.append("R");
                } else if(l < r){
                    lp = p;
                    sb.append("L");
                } else {
                    if(hand.equals("right")){
                        rp = p;
                        sb.append("R");
                    } else {
                        lp = p;
                        sb.append("L");
                    }
                }
            }
        }
        answer = sb.toString();
        System.out.println(answer);
    }
    public static int[] findPosition(int[][] keypad, int target){
        int[] result = new int[2];
        for(int i = 0 ; i < keypad.length ; i++){
            for(int j = 0 ;j < keypad[i].length ; j++){
                if(keypad[i][j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
