package Solutions;

public class 징검다리건너기 {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int left = 1;
        int max = Integer.MIN_VALUE;
        for(int stone : stones){
            max = Math.max(max, stone);
        }
        int right = max;
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            if(canCross(stones, mid, k)){
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);

    }

    public static boolean canCross(int[] stones, int people, int k){
        int count = 0;
        for(int stone : stones){
            if(stone - people < 0){
                count++;
                if(count >= k) return false;
            } else count = 0;
        }
        return true;
    }
}
// 시간복잡도 실패
//    public static void main(String[] args) {
//        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
//        int k = 3;
//        int answer = 0;
//        while(able(stones, k)){
//            answer++;
//            for(int i=0; i<stones.length; i++){
//                if(stones[i] > 0) stones[i]--;
//            }
//        }
//        System.out.println(answer);
//    }
//
//    public static boolean able(int[] stones, int k){
//
//        for(int i = 0 ; i < stones.length - k; i++){
//            int count = 0;
//            for(int j = i ; j < i + k ; j++){
//                if(stones[j] == 0) count++;
//            }
//            if(count == k) return false;
//        }
//        return true;
//    }
//}
