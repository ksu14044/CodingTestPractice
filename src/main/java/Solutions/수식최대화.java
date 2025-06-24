package Solutions;

import java.util.*;
import java.util.regex.*;

class 수식최대화 {
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        수식최대화 s = new 수식최대화();
        System.out.println(s.solution(expression));
    }
    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<String> ops = new ArrayList<>();

        Matcher m = Pattern.compile("\\d+|[^\\d]").matcher(expression);
        while(m.find()){
            String token = m.group();
            if(token.matches("\\d+")){
                numbers.add(Long.parseLong(token));
            } else {
                ops.add(token);
            }
        }

        Set<String> opSet = new HashSet<>(ops);
        List<String> opList = new ArrayList<>(opSet);

        List<List<String>> permutations = new ArrayList<>();
        permute(opList, 0, permutations);

        long max = 0;
        for(List<String> order : permutations){
            max = Math.max(max, Math.abs(calc(new ArrayList<>(numbers), new ArrayList<>(ops), order)));
        }
        return max;
    }

    private long applyOp(long a, long b, String op){
        switch(op){
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
        }
        throw new RuntimeException("Unknown Operation: " + op);
    }

    private void permute(List<String> arr, int index, List<List<String>> result){
        if(index == arr.size()){
            result.add(new ArrayList<>(arr));
            return;
        }
        for(int i = index ; i < arr.size() ; i++){
            Collections.swap(arr, i, index);
            permute(arr, index + 1, result);
            Collections.swap(arr, i, index);
        }
    }

    private long calc(List<Long> nums, List<String> ops, List<String> precedence){
        for(String op : precedence){
            for(int i = 0 ; i < ops.size() ; ){
                if(ops.get(i).equals(op)){
                    long res = applyOp(nums.get(i), nums.get(i+1), op);
                    nums.remove(i + 1);
                    nums.set(i, res);
                    ops.remove(i);
                } else {
                    i++;
                }
            }
        }
        return nums.get(0);
    }
}
