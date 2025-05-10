package Solutions;

public class 문자열나누기 {
    public static void main(String[] args) {
        String s = "aaabbaccccabba";
        char[] c = s.toCharArray();
        int answer = 0;
        for(int i = 0 ; i < c.length ; i++){
            int startCount = 1;
            int anotherCount = 0;
            char start = c[i];
            System.out.println(i);
            for(int j = i + 1; j < c.length ; j++){
                if(c[j] == start){
                    startCount++;
                } else {
                    anotherCount++;
                }
                if(startCount == anotherCount) {
                    answer ++;
                    i = j;
                    break;
                }
            }
            if(startCount != anotherCount){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
