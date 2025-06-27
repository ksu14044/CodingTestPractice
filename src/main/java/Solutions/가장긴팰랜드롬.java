package Solutions;

public class 가장긴팰랜드롬 {
    public static void main(String[] args) {
        String s = "abcdcba";
        System.out.println(solution(s));
    }
    public static int solution(String s){
        int n = s.length();
        int max = 1;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max, expand(s, i, i));
            max = Math.max(max, expand(s, i, i+1));
        }
        return max;
    }
    public static int expand(String s, int left, int right){
        int n = s.length();
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

}
