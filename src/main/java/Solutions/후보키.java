package Solutions;

import java.util.*;

public class 후보키 {

    public static void main(String[] args) {
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        int m = relation[0].length;
        List<List<Integer>> candidates = new ArrayList<>();
        for(int i = 1 ; i <= m ; i++){
            dfs(0, i, m, relation, new ArrayList<>(), candidates);
        }
        System.out.println(candidates.size());
    }

    public static void dfs(int start, int size, int colSize, String[][] relation, List<Integer> comb, List<List<Integer>> candidates){
        if(comb.size() == size){
            if(!isMinimal(comb, candidates)) return;
            if(isUnique(comb, relation)){
                candidates.add(new ArrayList<>(comb));
            }
            return;
        }
        for(int i = start ; i < colSize ; i++){
            comb.add(i);
            dfs(i+1, size, colSize, relation, comb, candidates);
            comb.remove(comb.size() - 1);
        }
    }

    public static boolean isUnique(List<Integer> comb, String[][] relation){
        Set<String> seen = new HashSet<>();
        for(String[] r : relation){
            StringBuilder sb = new StringBuilder();
            for(int c : comb){
                sb.append(r[c]).append(",");
            }
            seen.add(sb.toString());
        }
        return seen.size() == relation.length;
    }

    public static boolean isMinimal(List<Integer> comb, List<List<Integer>> candidates){
        for(List<Integer> key : candidates){
            if(comb.containsAll(key)) return false;
        }
        return true;
    }

}
