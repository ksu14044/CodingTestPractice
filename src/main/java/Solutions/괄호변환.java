package Solutions;

public class 괄호변환 {
    public static void main(String[] args) {
        String p = "(()())()";
        System.out.println(solution(p));
    }

    public static String solution(String p){
        if(p.isEmpty()) return "";

        int index = getBalancedIndex(p);
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);

        if(isCorrect(u)){
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            sb.append(reverse(u.substring(1, u.length() - 1)));
            return sb.toString();
        }
    }

    public static boolean isCorrect(String p){
        int count = 0;
        for(char ch : p.toCharArray()){
            if(ch == '(') count++;
            else {
                count --;
                if(count < 0) return false;
            }
        }
        return count == 0;
    }

    public static String reverse(String p){
        StringBuilder sb = new StringBuilder();
        for(char ch : p.toCharArray()){
            sb.append(ch == '(' ? ')' : '(');
        }
        return sb.toString();
    }

    public static int getBalancedIndex(String p){
        int count = 0;
        for(int i = 0 ; i < p.length() ; i++){
            if(p.charAt(i) == '(') count++;
            else count--;
            if(count == 0) return i;
        }
        return -1;
    }
}
