package Solutions;

import java.util.HashSet;
import java.util.Set;

public class 불량사용자 {
    public static Set<Set<String>> result = new HashSet<>();

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};
        boolean[] used = new boolean[user_id.length];
        dfs(user_id, banned_id, 0, used, new HashSet<>());
        System.out.println(result);
        System.out.println(result.size());
    }

    public static void dfs(String[] user_id, String[] banned_id, int index, boolean[] used, Set<String> current){
        if(current.size() == banned_id.length){
            System.out.println(current);
            result.add(new HashSet<>(current));
        } else {
            for(int i = 0 ; i < user_id.length ; i++){
                if(!used[i] && isMatch(user_id[i], banned_id[index])){
                    System.out.println("i : " + i + "user_id : " + user_id[i]);
                    used[i] = true;
                    current.add(user_id[i]);
                    dfs(user_id, banned_id, index + 1, used, current);
                    used[i] = false;
                    current.remove(user_id[i]);
                }
            }
        }
    }

    public static boolean isMatch(String s, String p){
        if(s.length() != p.length()) return false;
        for(int i = 0 ; i < s.length() ; i++){
            char sc = s.charAt(i);
            char pc = p.charAt(i);
            if(pc == '*') continue;
            else if(sc != pc) return false;
        }
        return true;
    }
}
