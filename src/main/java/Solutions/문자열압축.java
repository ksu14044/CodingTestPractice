package Solutions;

import java.util.ArrayList;
import java.util.List;

//public class Solution {
//    public static void main(String[] args) {
//        String s = "abcabcdede";
//        int min = s.length();
//        for(int i = 1 ; i <= s.length() / 2 ; i++){
//            String prev = s.substring(0, i);
//            StringBuilder sb = new StringBuilder();
//            int count = 1;
//            for(int j = i ; j + i <= s.length() ; j += i){
//                String cur = s.substring(j, j + i);
//                if(cur.equals(prev)){
//                    count++;
//                } else {
//                    if(count > 1) sb.append(count);
//                    sb.append(cur);
//                    prev = cur;
//                    count = 1;
//                }
//            }
//            if(count > 1) sb.append(count);
//            sb.append(prev);
//
//            int remain = s.length() % i;
//            if(remain != 0){
//                sb.append(s.substring(s.length() - remain));
//            }
//            min = Math.min(min, sb.toString().length());
//        }
//        System.out.println(min);
//    }
//}
// 한 개 차이로 실패 -> min을 Integer.MAX_VALUE 로 두었을 때 s의 길이가 1인 경우 오류;
// min = s.length()로 고친 이후 성공
public class 문자열압축 {
    public static void main(String[] args) {
        String s = "abcabcdede";
        int min = s.length();
        for(int i = 1 ; i <= s.length()/2 ; i++){
            List<String> list = new ArrayList<>();
            for(int j = 0 ; j < s.length() - i + 1 ; j += i){
                String s1 = s.substring(j, j+i);
                list.add(s1);
            }
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < list.size() ; j++){
                String cur = list.get(j);
                int count = 0;
                int temp = 0;
                for(int k = j; k < list.size() ; k++){
                    if(list.get(k).equals(cur)) {
                        count ++;
                    } else {
                        temp = k;
                        break;
                    }
                }
                if(count < 2) sb.append(cur);
                else sb.append(count).append(cur);
                if(j + count == list.size()) break;
                j = temp -1;
            }
            if(s.length() % i != 0){
                sb.append(s.substring(s.length() - s.length() % i));
            }
            min = Math.min(min, sb.toString().length());
        }
        System.out.println(min);
    }
}
