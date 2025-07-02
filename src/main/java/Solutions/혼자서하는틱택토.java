package Solutions;

class 혼자서하는틱택토 {
    public static void main(String[] args) {
        String[] board = {"O.X", ".O.", "..X"};
        System.out.println(solution(board));
    }
    public static int solution(String[] board) {
        int answer = -1;
        int[] nums = count(board);
        int Onums = nums[0];
        int Xnums = nums[1];
        if(Xnums > Onums || Onums - Xnums > 1) return 0;
        if(isOFinished(board)){
            if(Onums == Xnums) return 0;
        }
        if(isXFinished(board)){
            if(Onums > Xnums) return 0;
        }
        return 1;
    }

    public static int[] count(String[] board){
        int[] num = new int[2];
        for(String b : board){
            for(int i = 0 ; i < b.length() ; i++){
                if(b.charAt(i) == 'O') num[0]++;
                else if(b.charAt(i) == 'X') num[1]++;
            }
        }
        return num;
    }
    public static boolean isOFinished(String[] board){
        String[][] s = new String[3][3];
        int idx = 0;
        for(int i = 0 ; i < s.length; i++){
            String[] b = board[i].split("");
            for(int j = 0 ; j < s[i].length ; j++){
                s[i][j] = b[j];
            }
        }
        for(String b : board){
            if(b.equals("OOO")) return true;
        }
        if(s[0][0].equals("O") && s[1][1].equals("O") && s[2][2].equals("O")) return true;
        if(s[0][2].equals("O") && s[1][1].equals("O") && s[2][0].equals("O")) return true;
        if(s[0][0].equals("O") && s[1][0].equals("O") && s[2][0].equals("O")) return true;
        if(s[0][1].equals("O") && s[1][1].equals("O") && s[2][1].equals("O")) return true;
        if(s[0][2].equals("O") && s[1][2].equals("O") && s[2][2].equals("O")) return true;
        return false;

    }
    public static boolean isXFinished(String[] board){
        String[][] s = new String[3][3];
        int idx = 0;
        for(int i = 0 ; i < s.length; i++){
            String[] b = board[i].split("");
            for(int j = 0 ; j < s[i].length ; j++){
                s[i][j] = b[j];
            }
        }
        for(String b : board){
            if(b.equals("XXX")) return true;
        }
        if(s[0][0].equals("X") && s[1][1].equals("X") && s[2][2].equals("X")) return true;
        if(s[0][2].equals("X") && s[1][1].equals("X") && s[2][0].equals("X")) return true;
        if(s[0][2].equals("X") && s[1][1].equals("X") && s[2][2].equals("X")) return true;
        if(s[0][1].equals("X") && s[1][1].equals("X") && s[2][1].equals("X")) return true;
        if(s[0][0].equals("X") && s[1][0].equals("X") && s[2][0].equals("X")) return true;
        return false;
    }
}
