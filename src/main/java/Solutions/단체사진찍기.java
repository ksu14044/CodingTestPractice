package Solutions;

import java.util.*;

class 단체사진찍기 {
    static char[] arr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visited = new boolean[8];
    static List<List<Character>> list = new ArrayList<>();

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        int answer = solution(n, data);
        System.out.println(answer);
    }
    public static int solution(int n, String[] data) {
        int answer = 0;
        makeList(new ArrayList<>());
        for(int i = 0 ; i < list.size() ; i++){
            List<Character> cur = list.get(i);
            boolean valid = true;
            for(String d : data){
                if(!isValid(d, cur)) {
                    valid = false;
                    break;
                }
            }
            if(valid) answer++;
        }
        return answer;
    }

    public static void makeList(List<Character> cur){
        if(cur.size() == 8){
            list.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0 ; i < 8 ; i++){
            if(!visited[i]){
                visited[i] = true;
                cur.add(arr[i]);
                makeList(cur);
                cur.remove(cur.size()-1);
                visited[i] = false;
            }
        }
    }

    public static boolean isValid(String data, List<Character> list){
        char first = data.charAt(0);
        char second = data.charAt(2);
        char cdt = data.charAt(3);
        int dist = Integer.parseInt(data.substring(4)) ;
        int firstIdx = -1;
        int secondIdx = -1;
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i) == first) firstIdx = i;
            else if(list.get(i) == second) secondIdx = i;
        }
        int d = Math.abs(secondIdx - firstIdx);
        if(cdt == '=') return d == 1;
        else if(cdt == '>') return d > dist + 1;
        else if(cdt == '<') return d < dist + 1;
        return false;
    }
}
