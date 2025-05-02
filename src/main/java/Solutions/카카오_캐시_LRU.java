package Solutions;

import java.util.Arrays;

public class 카카오_캐시_LRU {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        String[] cache = new String[cacheSize];
        Arrays.fill(cache, "1");
        int answer = 0;

        for(String city : cities) {
            int pos = -1;
            for(int i = 0 ; i < cacheSize ; i++){
                if(cache[i].equalsIgnoreCase(city)){
                    pos = i;
                }
            }
            if(pos == -1) {
                for(int i = cacheSize-1 ; i >= 1 ; i--){
                    cache[i] = cache[i-1];
                }
                answer += 5;
            } else {
                for(int i = pos ; i >= 1 ; i--){
                    cache[i] = cache[i-1];
                }
                answer += 1;
            }
            cache[0] = city;
        }
        for(String a : cache){
            System.out.println(a);
        }
        System.out.println(answer);
    }
}
