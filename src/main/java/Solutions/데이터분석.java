package Solutions;

import java.util.*;

public class 데이터분석 {
    public static void main(String[] args) {
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};

        List<int[]> list = new ArrayList<>();
        int index = getIndex(ext);
        for(int i = 0 ; i < data.length ; i++){
            if(data[i][index] < val_ext){
                list.add(data[i]);
            }
        }
        int[][] answer = list.toArray(new int[0][]);
        System.out.println(Arrays.deepToString(answer));
        Arrays.sort(answer, Comparator.comparingInt(row -> row[getIndex(sort_by)]));
        System.out.println(Arrays.deepToString(answer));
    }

    public static int getIndex(String key){
        Map<String, Integer> map = Map.of(
                "code",0,
                "date",1,
                "maximum",2,
                "remain",3
        );
        return map.getOrDefault(key, -1);
    }
}
//    public static void main(String[] args) {
//        String ext = "date";
//        int val_ext = 20300501;
//        String sort_by = "remain";
//        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
//        List<int[]> list = new ArrayList<>();
//        for(int i = 0 ; i < data.length ; i++){
//            switch(ext){
//                case "date":
//                    if(data[i][1] <= val_ext){
//                        list.add(data[i]);
//                    }
//                    break;
//                case "code":
//                    if(data[i][0] <= val_ext){
//                        list.add(data[i]);
//                    }
//                    break;
//                case "maximun":
//                    if(data[i][2] <= val_ext){
//                        list.add(data[i]);
//                    }
//                    break;
//                case "remain":
//                    if(data[i][3] <= val_ext){
//                        list.add(data[i]);
//                    }
//            }
//        }
//        int[][] answer = list.toArray(new int[list.size()][]);
//
//
//        System.out.println(Arrays.deepToString(answer));
//        switch(sort_by){
//            case "date":
//                Arrays.sort(answer, (a,b) -> a[1] - b[1]);
//                break;
//            case "code":
//                Arrays.sort(answer, (a,b) -> a[0] - b[0]);
//                break;
//            case "maximun":
//                Arrays.sort(answer, (a,b) -> a[2] - b[2]);
//                break;
//            case "remain":
//                Arrays.sort(answer, (a,b) -> a[3] - b[3]);
//                break;
//        }
//        System.out.println(Arrays.deepToString(answer));
//
//
//    }
//}
