package Solutions;

public class 유사칸토어비트열 {
    public static void main(String[] args) {
        int n = 2;
        long l = 4;
        long r = 17;
        System.out.println(dfs(n, 1, (long)Math.pow(5, n), l, r));
    }

    public static long dfs(int n, long start, long end, long l, long r){
        if(r < start || end < l) return 0;
        if(n == 0) return 1;
        long len = (end - start + 1) / 5;
        long result = 0;
        for(int i = 0; i < 5 ; i++){
            long s = start + len * i;
            long e = s + len - 1;
            if(i == 2) continue;
            result += dfs(n-1, s, e, l, r);
        }
        return result;
    }
}
