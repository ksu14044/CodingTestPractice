package Solutions;

public class 옹알이2 {
    public static void main(String[] args) {
        String[] set = {"aya", "ye", "woo", "ma"};
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        int answer = 0;
        for(String b : babbling){
            if(dfs(set, b, 0)) answer++;
        }
        System.out.println(answer);
    }

    public static boolean dfs(String[] set, String babbling, int start){
        if(start == babbling.length()) return true;
        for(int i = 0; i < set.length; i++){
            int n = set[i].length();
            try{
                String s = babbling.substring(start, start + n);
                if(s.equals(set[i])){
                    return dfs(set, babbling, start + n);
                }
            } catch(Exception e){
                continue;
            }
        }
        return false;
    }
}
