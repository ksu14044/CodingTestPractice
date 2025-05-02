package Solutions;

public class 덧칠하기 {
    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = {2,3,6};

        int count = 0;
        int lastPainted = 0;
        for(int s : section){
            if(s >= lastPainted){
                count++;
                lastPainted = s + m;
            }
        }
        System.out.println(count);
    }
}
