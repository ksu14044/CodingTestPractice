package Solutions;

import java.util.ArrayList;
import java.util.List;

public class 명예의전당 {
    public static void main(String[] args) {
       int k = 3;
       int[] score = {10, 100, 20, 150, 1, 100, 200};
       int[] answer = new int[score.length];
       List<Integer> ranks = new ArrayList<>();
       List<Integer> minValues = new ArrayList<>();
       for(int i = 0 ; i < score.length; i++) {
           int min = Integer.MAX_VALUE;
           if(i < k) {
               ranks.add(score[i]);
               for(int j = 0 ; j < ranks.size() ; j++){
                   min = Math.min(min, ranks.get(j));
               }
               minValues.add(min);
           } else {
               for(int j = 0 ; j < ranks.size() ; j++){
                   min = Math.min(min, ranks.get(j));
               }
               if(score[i] > min) {
                   ranks.remove(ranks.indexOf(min));
                   ranks.add(score[i]);
               }
               min = Integer.MAX_VALUE;
               for(int l = 0 ; l < ranks.size() ; l++){
                   min = Math.min(min, ranks.get(l));
               }
               minValues.add(min);
           }
       }
       for(int i = 0 ; i < minValues.size() ; i++) {
           answer[i] = minValues.get(i);
       }

    }
}
