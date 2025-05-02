package Solutions;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {
    static List<String> dictionary = new ArrayList<>();
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        dfs("", 0);
        System.out.println(dictionary.indexOf("aaaae"));
    }

    public static void dfs(String cur, int length){
        if(length > 5) return;
        dictionary.add(cur);
        for(char c : vowels){
            dfs(cur + c, length +1);
        }
    }

}
    //    public static void main(String[] args) {
//        String[] ahdma = {"A", "E", "I", "O", "U"};
//        List<String> dict = new ArrayList<>();
//        for(int i = 0 ; i < ahdma.length; i++){
//            String a = "";
//            a += ahdma[i];
//            dict.add(a);
//            for(int j = 0 ; j < ahdma.length ; j++){
//                String b = a;
//                b += ahdma[j];
//                dict.add(b);
//                for(int k = 0 ; k < ahdma.length ; k++){
//                    String c = b;
//                    c += ahdma[k];
//                    dict.add(c);
//                    for(int p = 0 ; p < ahdma.length ; p++){
//                        String d = c;
//                        d += ahdma[p];
//                        dict.add(d);
//                        for(int q = 0 ; q < ahdma.length ;q++){
//                            String e = d;
//                            e += ahdma[q];
//                            dict.add(e);
//                        }
//                    }
//                }
//
//            }
//
//        }
//        System.out.println(dict.indexOf("I"));
//    }

