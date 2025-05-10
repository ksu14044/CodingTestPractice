package Solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 모의고사 {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();

        int[] ediot1 ={1,2,3,4,5};
        int[] ediot2 = {2,1,2,3,2,4,2,5};
        int[] ediot3 = {3,3,1,1,2,2,4,4,5,5};

        for(int i : ediot1){
            q1.add(i);
        }
        for(int i : ediot2){
            q2.add(i);
        }
        for(int i : ediot3){
            q3.add(i);
        }

        int[] answers = {1,2,3,4,5};

        List<Integer> e1 = new ArrayList<>();
        List<Integer> e2 = new ArrayList<>();
        List<Integer> e3 = new ArrayList<>();

        for(int i = 0 ; i < answers.length ; i++){
            int ed1 = q1.poll();
            int ed2 = q2.poll();
            int ed3 = q3.poll();
            if(answers[i] == ed1){
                e1.add(answers[i]);
            }
            if(answers[i] == ed2){
                e2.add(answers[i]);
            }
            if(answers[i] == ed3){
                e3.add(answers[i]);
            }
            q1.add(ed1);
            q2.add(ed2);
            q3.add(ed3);
        }
        int ce1 = e1.size();
        int ce2 = e2.size();
        int ce3 = e3.size();
        int rank = Math.max(ce1, ce2);
        rank = Math.max(rank, ce3);
        List<Integer> answer = new ArrayList<>();
        if(rank == ce1 && rank == ce2 && rank == ce3){
            answer.add(1);
            answer.add(2);
            answer.add(3);
        } else if(rank == ce1 && rank == ce2){
            answer.add(1);
            answer.add(2);
        } else if(rank == ce1 && rank == ce3){
            answer.add(1);
            answer.add(3);
        } else if(rank == ce2 && rank == ce3){
            answer.add(2);
            answer.add(3);
        } else if(rank == ce1){
            answer.add(1);
        } else if(rank == ce2){
            answer.add(2);
        } else if(rank == ce3){
            answer.add(3);
        }
        System.out.println(answer);
    }
}
