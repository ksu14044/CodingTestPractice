package Solutions;

import java.util.stream.IntStream;

public class 공원 {
    public static void main(String[] args) {
        int[] mats = {2, 3, 5};
        String[][] park = {{"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};
        System.out.println(solution(mats, park));
    }

    public static int solution(int[] mats, String[][] park){
        mats = IntStream.of(mats)
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .mapToInt(Integer::intValue)
                .toArray();

        for(int mat : mats){
            if(isValid(park, mat)) return mat;
        }
        return -1;
    }

    public static boolean isValid(String[][] board, int size){

        for(int i = 0 ; i < board.length - size ; i++){
            for(int j = 0 ; j < board[i].length - size; j++){
                boolean valid = true;
                for(int k = i ; k < i + size ; k++){
                    for(int p = j ; p < j + size ; p++){
                        if(!board[k][p].equals("-1")){
                            valid = false;
                            break;
                        }
                    }
                    if(!valid) break;
                }
                if(valid) return true;
            }
        }
        return false;
    }
}
