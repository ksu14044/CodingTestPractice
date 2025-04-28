package Solutions;

public class 타겟넘버 {
    static int count = 0;
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
         타겟넘버 T = new 타겟넘버();
         T.dfs(0, 0, target, numbers);
        System.out.println(count);
    }

    public void dfs (int index, int total, int target, int[] numbers){
        if(index == numbers.length) {
            if(total == target) {
                count++;
            }
            return;
        }
        else {
            System.out.println("index = " + index);
            System.out.println("total = " + total);
            dfs(index+1, total+numbers[index], target, numbers);
            dfs(index+1, total-numbers[index], target, numbers);
        }
    }
}
