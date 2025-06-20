package Solutions;

public class 풍선터트리기 {
    public static void main(String[] args) {
        int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        int answer = 0;
        int[] leftMin = new int[a.length];
        leftMin[0] = a[0];
        for(int i = 1 ; i < leftMin.length ; i++){
            if(a[i] < leftMin[i-1]){
                leftMin[i] = a[i];
            } else leftMin[i] = leftMin[i-1];
        }
        int[] rightMin = new int[a.length];
        rightMin[a.length-1] = a[a.length-1];
        for(int i = rightMin.length - 2 ; i >= 0 ; i--){
            if(a[i] < rightMin[i+1]){
                rightMin[i] = a[i];
            } else {
                rightMin[i] = rightMin[i+1];
            }
        }
        for(int i = 1 ; i < a.length - 1 ; i++){
            if(a[i] <= leftMin[i-1] || a[i] <= rightMin[i+1]) answer++;
        }
        System.out.println(answer+2);
    }
}
