package Solutions;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] ans = new String[n];

        for(int i = 0 ; i < n ; i++){
            int c = arr1[i] | arr2[i];
            String cStr = String.format("%"+n+"s", Integer.toBinaryString(c))
                    .replace('0', ' ')
                    .replace('1', '#');
            ans[i] = cStr;
            System.out.println(ans[i]);
        }
    }
}
