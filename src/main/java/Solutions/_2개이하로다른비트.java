package Solutions;

import java.util.Arrays;

public class _2개이하로다른비트 {
    public static void main(String[] args) {
        long[] numbers = {2, 7};
        long[] answer = new long[numbers.length];

        for(int i = 0 ; i < numbers.length ; i++){
            long number = numbers[i];

            if(number % 2 == 0){
                answer[i] = number + 1;
            } else {
                long lowestZero = number & -number; // 가장 낮은 1을 찾음
                System.out.println("lowestZero: " + Long.toBinaryString(lowestZero));
                long nextNumber = number + lowestZero; // 가장 낮은 0을 1로 변경 ( 0111 + 0001 = 1000 )
                System.out.println("nextNumber: " + Long.toBinaryString(nextNumber));
                long lowestOne = (nextNumber ^ number) >> 2; // XOR 후 불필요한 비트 제거
                System.out.println("lowestOne: " + Long.toBinaryString(lowestOne));
                answer[i] = nextNumber | lowestOne; // 올바른 최종 값 계산
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
// 시간 초과
//    public static void main(String[] args) {
//        long[] numbers = {2, 7};
//        List<Long> list = new ArrayList<>();
//        for(long number : numbers){
//
//            String n = Long.toBinaryString(number);
//            boolean flag = true;
//            while(flag){
//                number++;
//                int count = 0;
//                String vs = Long.toBinaryString(number);
//
//                n = String.format("%" + vs.length() + "s", n).replace(' ', '0');
//                char[] nc = n.toCharArray();
//                char[] vsc = vs.toCharArray();
//                for(int i = 0 ; i < nc.length ; i++){
//                    if(nc[i] != vsc[i]) {
//                        count++;
//                    }
//                }
//                if(count <= 2){
//                    list.add(number);
//                    flag = false;
//                }
//            }
//        }
//        long[] answer = list.stream().mapToLong(x -> x).toArray();
//        System.out.println(Arrays.toString(answer));
//    }
//}
