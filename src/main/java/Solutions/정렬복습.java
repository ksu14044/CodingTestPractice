package Solutions;

import java.util.Arrays;

public class 정렬복습 {
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 3, 4, 1};
        bubbleSort(arr1);

        String num = "2143";
        selectionSort(num);
    }

    public static int[] bubbleSort(int[] arr){
        for(int i = 0 ; i < arr.length - 1 ; i++){
            for(int j = 0 ; j <arr.length - 1 - i ; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("버블 정렬 = " + Arrays.toString(arr));
        return arr;
    }

    public static int[] selectionSort(String num){
        int[] arr = new int[num.length()];
        for(int i = 0 ; i < num.length() ; i++){
            arr[i] = Integer.parseInt(num.substring(i,i+1));
        }
        for(int i = 0 ; i < arr.length ; i++){
            int max = i;
            for(int j = i+1 ;j < arr.length ; j++){
                if(arr[j] > arr[max]){
                    max = j;
                }
            }
            if(arr[i] < arr[max]){
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }
        System.out.println("선택정렬" + Arrays.toString(arr));
        return arr;
    }
}
