package Solutions;

public class N퀸 {
    static int N;
    static boolean[] width;
    static boolean[] diagonal1;
    static boolean[] diagonal2;

    private static int getAns(int y){
        int ans = 0;
        if( y == N ){
            ans++;
        } else {
            for(int i = 0 ; i < N ; i++){
                if(width[i] || diagonal1[i + y] || diagonal2[i - y + N]) continue;
                width[i] = diagonal1[i + y] = diagonal2[i - y + N] = true;
                ans += getAns(y + 1);
                width[i] = diagonal1[i + y] = diagonal2[i - y + N] = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        N = 4;
        width = new boolean[N];
        diagonal1 = new boolean[N * 2];
        diagonal2 = new boolean[N * 2];
        int answer = getAns(0);
        System.out.println(answer);
    }
}
