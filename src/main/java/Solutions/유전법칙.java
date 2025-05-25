package Solutions;

import java.util.*;

public class 유전법칙 {
    public static void main(String[] args) {
        int[][] queries = {{4,26}};
        String[] answer = new String[queries.length];
        for(int i = 0 ; i < queries.length; i++){
            answer[i] = getGene(queries[i][0], queries[i][1]);
        }
        System.out.println(Arrays.toString(answer));
    }

    public static String getGene(int generation, int position){
        if(generation == 1) return "Rr";
        int parentPos = (position + 3) / 4;
        String parentGene = getGene(generation - 1, parentPos);
        int childPos = (position - 1) % 4;

        switch(parentGene){
            case "RR":
                return "RR";
            case "rr":
                return "rr";
            case "Rr":
                if(childPos == 0) return "RR";
                else if(childPos == 1 || childPos == 2) return "Rr";
                else if(childPos == 3) return "rr";
        }
        return "";
    }
}

// 시간 복잡도 탈락
//    public static int max = Integer.MIN_VALUE;
//    public static class Dna{
//        int generation;
//        String gens;
//
//        public Dna(int generation, String gens){
//            this.generation = generation;
//            this.gens = gens;
//        }
//    }
//
//    public static void main(String[] args) {
//        int[][] queries = {{3,5}};
//        for(int[] query : queries){
//            max = Math.max(max, query[0]);
//        }
//        List<List<String>> list = new ArrayList<>();
//        for(int i = 0; i < max + 1 ; i++){
//            list.add(new ArrayList<>());
//        }
//        Queue<Dna> q = new LinkedList<>();
//        q.offer(new Dna(1, "Rr"));
//        while(q.peek().generation <= max){
//            Dna cur = q.poll();
//            list.get(cur.generation).add(cur.gens);
//            switch(cur.gens){
//                case "Rr":
//                    q.offer(new Dna(cur.generation+1, "RR"));
//                    q.offer(new Dna(cur.generation+1, "Rr"));
//                    q.offer(new Dna(cur.generation+1, "Rr"));
//                    q.offer(new Dna(cur.generation+1, "rr"));
//                    break;
//                case "rr":
//                    q.offer(new Dna(cur.generation+1, "rr"));
//                    q.offer(new Dna(cur.generation+1, "rr"));
//                    q.offer(new Dna(cur.generation+1, "rr"));
//                    q.offer(new Dna(cur.generation+1, "rr"));
//                    break;
//                case "RR":
//                    q.offer(new Dna(cur.generation+1, "RR"));
//                    q.offer(new Dna(cur.generation+1, "RR"));
//                    q.offer(new Dna(cur.generation+1, "RR"));
//                    q.offer(new Dna(cur.generation+1, "RR"));
//                    break;
//            }
//        }
//        System.out.println(list);
//        String[] answer = new String[queries.length];
//        for(int i = 0 ; i < queries.length ; i++){
//            answer[i] = list.get(queries[i][0]).get(queries[i][1] - 1);
//        }
//        System.out.println(Arrays.toString(answer));
//    }
//}
