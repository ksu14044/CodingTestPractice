package Solutions;

import java.util.*;

public class 순위검색 {
    static Map<String, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        System.out.println(Arrays.toString(solution(info, query)));
    }

    public static int[] solution(String[] info, String[] query){
        for(String i : info){
            String[] arr = i.split(" ");
            String[] field = Arrays.copyOfRange(arr, 0, 4);
            int score = Integer.parseInt(arr[4]);
            dfs(field, "", 0, score);
        }
        for(List<Integer> list : map.values()){
            Collections.sort(list);
        }
        int[] answer = new int[query.length];
        for(int i = 0 ; i < query.length ; i++){
            String q = query[i].replaceAll(" and ", " ");
            String[] parts = q.split(" ");
            String key = String.join("", Arrays.copyOfRange(parts, 0, 4));
            int score = Integer.parseInt(parts[4]);
            int count = 0;
            if(map.containsKey(key)){
                List<Integer> list = map.get(key);
                count = list.size() - lowerBound(list, score);
            }
            answer[i] = count;
        }
        return answer;
    }

    public static void dfs(String[] field, String cur, int depth, int score){
        if(depth == 4){
            map.computeIfAbsent(cur, k -> new ArrayList<>()).add(score);
            return;
        }
        dfs(field, cur + field[depth], depth + 1, score);
        dfs(field, cur + "-", depth + 1, score);
    }

    public static int lowerBound(List<Integer> list, int target){
        int left = 0, right = list.size();
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) < target){
                left = mid + 1;
            } else right = mid;
        }
        return left;
    }
//        효율성 검사 실패
//        int[] answer = new int[query.length];
//        for (int i = 0; i < query.length; i++) {
//            String[] q = query[i].replace(" and", "").split(" ");
//            String lang = q[0], part = q[1], career = q[2], food = q[3];
//            int score = Integer.parseInt(q[4]);
//
//            int count = 0;
//            for (String infoStr : info) {
//                String[] in = infoStr.split(" ");
//                String il = in[0], ip = in[1], ic = in[2], ifood = in[3];
//                int iscore = Integer.parseInt(in[4]);
//
//                if ((lang.equals("-") || lang.equals(il)) &&
//                        (part.equals("-") || part.equals(ip)) &&
//                        (career.equals("-") || career.equals(ic)) &&
//                        (food.equals("-") || food.equals(ifood)) &&
//                        iscore >= score) {
//                    count++;
//                }
//            }
//            answer[i] = count;
//        }
//        System.out.println(Arrays.toString(answer));

}
