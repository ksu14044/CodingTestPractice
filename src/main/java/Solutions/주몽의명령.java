package Solutions;

import java.util.Arrays;

public class 주몽의명령 {
    public static void main(String[] args) {
        int[] ingredients = {2,1,3,7,5,4};
        int target = 9;
        Arrays.sort(ingredients);
        int lt = 0;
        int rt = ingredients.length - 1;
        int count = 0;
        while(lt < rt){
            int sum = ingredients[lt] + ingredients[rt];
            if(sum > target){
                rt--;
            } else if(sum < target){
                lt++;
            } else {
                count++;
                rt--;
                lt++;
            }
        }
        System.out.println(count);
    }
}
