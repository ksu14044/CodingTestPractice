package Solutions;

import java.util.*;

class 수식복원하기 {
    public static void main(String[] args) {
        String[] expressions = {"14 + 3 = 17", "13 - 6 = X", "51 - 5 = 44"};
        수식복원하기 solution = new 수식복원하기();
        System.out.println(Arrays.toString(solution.solution(expressions)));
    }
    public String[] solution(String[] expressions) {

        int max = Integer.MIN_VALUE;
        for(String exp : expressions){
            String[] sexp = exp.split(" ");
            for(String se : sexp){
                if(se.equals("+") || se.equals("-") || se.equals("X") || se.equals("=")) continue;
                String[] sse = se.split("");
                for(String num : sse){
                    max = Math.max(max, Integer.parseInt(num));
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i = max + 1 ; i < 10 ; i++){
            set.add(i);
        }
        int binary = -1;
        for(String exp : expressions){
            String[] sexp = exp.split(" ");
            if(sexp[4].equals("X")) continue;
            if(sexp[1].equals("+")){
                if(Integer.parseInt(sexp[0]) + Integer.parseInt(sexp[2]) == Integer.parseInt(sexp[4])) continue;
            } else if(sexp[1].equals("-")){
                if(Integer.parseInt(sexp[0]) - Integer.parseInt(sexp[2]) == Integer.parseInt(sexp[4])) continue;
            }
            for(int i = max ; i < 10 ; i++){
                if(sexp[1].equals("+")){
                    if(convert(sexp[0], i) + convert(sexp[2], i) == convert(sexp[4], i)){
                        binary = i;
                        break;
                    }
                } else if(sexp[1].equals("-")){
                    if(convert(sexp[0], i) - convert(sexp[2], i) == convert(sexp[4], i)){
                        binary = i;
                        break;
                    }
                }
            }
        }
        List<String> answer = new ArrayList<>();
        if(binary != -1){
            for(String exp : expressions){
                String[] sexp = exp.split(" ");
                if(sexp[4].equals("X")){
                    String a = exp.substring(0, exp.length() - 1);
                    if(sexp[1].equals("+")){
                        int result = convert(sexp[0], binary) + convert(sexp[2], binary);
                        answer.add(a + convert2(result, binary));
                    } else if(sexp[1].equals("-")){
                        int result = convert(sexp[0], binary) - convert(sexp[2], binary);
                        answer.add(a + convert2(result, binary));
                    }
                }
            }
        } else {
            for(String exp : expressions){
                String[] sexp = exp.split(" ");
                if(sexp[4].equals("X")){
                    String a = exp.substring(0, exp.length() - 1);
                    Set<String> possible = new HashSet<>();
                    for(int b : set){
                        if(sexp[1].equals("+")){
                            int result = convert(sexp[0], b) + convert(sexp[2], b);
                            possible.add(convert2(result, b));
                        } else if(sexp[1].equals("-")){
                            int result = convert(sexp[0], b) - convert(sexp[2], b);
                            possible.add(convert2(result, b));
                        }
                    }
                    String[] setString = possible.toArray(new String[0]);

                    if(setString.length > 1){
                        answer.add(a + "?");
                    } else {
                        answer.add(a + setString[0]);
                    }
                }
            }
        }
        return answer.toArray(new String[0]);
    }

    public int convert(String target, int binary){
        String[] st = target.split("");
        int answer = 0;
        int multipler = 0;
        for(int i = st.length - 1 ; i >= 0 ; i--){
            answer += Integer.parseInt(st[i]) * Math.pow(binary, multipler);
            multipler++;
        }
        return answer;
    }

    public String convert2(int target, int binary){
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack();
        if(target == 0) return "0";
        while(target > 0){
            st.push(target % binary);
            target /= binary;
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
}