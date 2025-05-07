package Solutions;

public class 단어변환 {
    static boolean isSuccess = false;
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        boolean[] isVisited = new boolean[words.length];
        int min = Integer.MAX_VALUE;


        for(int i = 0 ; i < words.length ; i ++){
            if(canConvert(begin, words[i])){
                min = Math.min(min, dfs(words, i, end, isVisited, 1));
            }
        }
        System.out.println(min);
    }

    public static int dfs(String[] words, int index, String target, boolean[] isVisited, int count) {

        if(words[index].equals(target)){
            return count;
        }
        isVisited[index] = true;
        int minCount = Integer.MAX_VALUE;
        for(int i = 0 ; i < words.length ;i ++){
            if(!isVisited[i] && canConvert(words[index], words[i])){
                minCount = Math.min(minCount, dfs(words, i, target, isVisited, count+1));
            }
        }
        isVisited[index] = false;
        return minCount;
    }

    public static boolean canConvert(String word1, String word2){
        int count = 0;
        for(int i = 0 ; i < word1.length() ; i ++){
            if(word1.charAt(i) != word2.charAt(i)){
                count++;
            }
        }
        return count <= 1;
    }
}
