package Solutions;

import java.util.*;

public class 가사검색 {
    static Map<Integer, List<String>> forwardMap = new HashMap<>();
    static Map<Integer, List<String>> backwardMap = new HashMap<>();
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        System.out.println(Arrays.toString(solution(words, queries)));
    }

    public static int[] solution(String[] words, String[] queries){
        for(String word : words){
            int len = word.length();
            forwardMap.computeIfAbsent(len, x -> new ArrayList<>()).add(word);
            backwardMap.computeIfAbsent(len, x -> new ArrayList<>()).add(new StringBuilder(word).reverse().toString());
        }

        for(int len : forwardMap.keySet()){
            Collections.sort(forwardMap.get(len));
            Collections.sort(backwardMap.get(len));
        }

        int[] answer = new int[queries.length];
        for(int i = 0 ; i < queries.length ; i++){
            String q = queries[i];
            int len = q.length();
            if(!forwardMap.containsKey(len)){
                answer[i] = 0;
                continue;
            }
            List<String> target;
            String left, right;
            if(q.charAt(0) == '?'){
                target = backwardMap.get(len);
                String reversed = new StringBuilder(q).reverse().toString();
                left = reversed.replace('?', 'a');
                right = reversed.replace('?', 'z');
            } else {
                target = forwardMap.get(len);
                left = q.replace('?', 'a');
                right = q.replace('?', 'z');
            }
            answer[i] = countByRange(target, left, right);
        }
        return answer;
    }

    public static int countByRange(List<String> list, String left, String right){
        int leftIdx = lowerBound(list, left);
        int rightIdx = upperBound(list, right);
        return rightIdx - leftIdx;
    }

    public static int lowerBound(List<String> list, String target){
        int low = 0, high = list.size();
        while(low < high){
            int mid = (low + high) / 2;
            if(list.get(mid).compareTo(target) >= 0) high = mid;
            else low = mid + 1;
        }
        return high;
    }

    public static int upperBound(List<String> list, String target){
        int low = 0, high = list.size();
        while(low < high){
            int mid = (low + high) / 2;
            if(list.get(mid).compareTo(target) > 0) high = mid;
            else low = mid + 1;
        }
        return high;
    }
}

// 효율성 검사 실패
//public class Solution {
//    public static void main(String[] args) {
//        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
//        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
//        solution(words, queries);
//    }
//
//    public static int[] solution(String[] words, String[] queries){
//        List<Integer> arr = new ArrayList<>();
//        for(int i = 0 ; i < queries.length ; i++){
//            String cur = queries[i];
//            int len = cur.length();
//            int cnt = 0;
//            for(int j = 0 ; j < words.length ; j++){
//                if(len != words[j].length()) continue;
//                boolean check = true;
//                for(int k = 0 ; k < cur.length() ; k++){
//                    if(Character.isAlphabetic(cur.charAt(k))){
//                        if(cur.charAt(k) != words[j].charAt(k)) check = false;
//                    }
//                }
//                if(check) cnt++;
//            }
//            arr.add(cnt);
//        }
//        return arr.stream().mapToInt(i -> i).toArray();
//    }
//}
