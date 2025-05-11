package Solutions;

import java.util.Arrays;

public class 정렬practice {
    public static void main(String[] args) {
        String[] books = {"Java Programming", "Python for Beginners", "C++ Advanced", "Data Structures", "Algorithms"};

        //사전 순 정렬
        Arrays.sort(books);
        System.out.println(Arrays.toString(books));

        //글자 수 정렬
        Arrays.sort(books, (a,b) -> (b.length()-a.length()));
        System.out.println(Arrays.toString(books));

        //마지막 글자 기준 정렬
        Arrays.sort(books, (a, b) -> Character.compare(b.charAt(b.length()-1), a.charAt(a.length()-1)));
        System.out.println(Arrays.toString(books));

        Integer[] numbers = {7, 2, 9, 1, 5};
        Arrays.sort(numbers, (a,b) -> b.compareTo(a));
        System.out.println(Arrays.toString(numbers));
    }
}
