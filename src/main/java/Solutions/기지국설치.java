package Solutions;

public class 기지국설치 {
    // 효율성 검사 통과
    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;

        int answer = 0;
        int range = 2 * w + 1;
        int prev = 1;

        for(int station : stations){
            int left = Math.max(1, station - w);
            int right = Math.min(n, station + w);
            if(prev < left) {
                answer += (int) Math.ceil((double)(left - prev) / range);
            }
            prev = right + 1;
        }

        if(prev <= n){
            answer += (int) Math.ceil((double)(n - prev + 1) / range);
        }
        System.out.println(answer);
    }
}
// 효율성 검사 실패
//    public static void main(String[] args) {
//        int N = 11;
//        int[] stations = {4, 11};
//        int W = 1;
//        List<Integer> connected = new ArrayList<>();
//        for(int station : stations) {
//            int start = station - W;
//            int end = start + 2*W;
//            for(int i = start; i <= end ;i++){
//                connected.add(i);
//            }
//        }
//        System.out.println(connected);
//        List<Integer> unconnected = new ArrayList<>();
//        for(int i = 1 ; i <= N ; i++){
//            if(!connected.contains(i)){
//                unconnected.add(i);
//            }
//        }
//        System.out.println(unconnected);
//
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> currentGroup = new ArrayList<>();
//        for(int i = 0 ; i < unconnected.size() ; i++){
//            if(currentGroup.isEmpty() || currentGroup.get(currentGroup.size()-1)+1 == unconnected.get(i)){
//                currentGroup.add(unconnected.get(i));
//            } else {
//                result.add(new ArrayList<>(currentGroup));
//                currentGroup.clear();
//                currentGroup.add(unconnected.get(i));
//            }
//        }
//        result.add(new ArrayList<>(currentGroup));
//
//        System.out.println(result);
//        int answer = 0;
//        for(int i = 0 ; i < result.size() ; i++){
//            int divide = result.get(i).size() / (2*W+1);
//            if(result.get(i).size() % (2*W+1) != 0){
//                divide++;
//            }
//            answer += divide;
//        }
//        System.out.println(answer);
//
//
//    }
//}
