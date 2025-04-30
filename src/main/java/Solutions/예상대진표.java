package Solutions;

public class 예상대진표 {
    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;

        boolean flag = true;
        int round = 0;
        while(flag){
            round++;
            a = (a+1)/2;
            b = (b+1)/2;
            if(a == b){
                flag = false;
            }

        }
        System.out.println(round);

    }
}
