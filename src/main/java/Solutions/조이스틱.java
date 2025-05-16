package Solutions;

public class 조이스틱 {
    public static void main(String[] args) {
        char n = 'C';
        char m = 'Y';

        int answer = 0;
        String name = "JAN";
        char[] c = name.toCharArray();
        for(char cc : c){
            int min = Math.min(((int)cc - (int)'A'), ((int)'Z' - (int)cc) + 1);
            answer += min;
        }

        int move = c.length - 1;
        for(int i = 0 ; i < c.length ; i++){
            int nextIndex = i + 1;
            while(nextIndex < c.length && c[nextIndex] == 'A'){
                nextIndex++;
            }

            int leftRight = i * 2 + (c.length - nextIndex);
            int rightLeft = (c.length - nextIndex) * 2 + i;
            move = Math.min(move, Math.min(leftRight, rightLeft));
        }
        answer += move;

        System.out.println(answer);
    }
}
