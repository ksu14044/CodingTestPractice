package Solutions;

import java.util.Arrays;
import java.util.Comparator;

public class 파일명정렬 {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                FileData f1 = parseFileName(o1);
                FileData f2 = parseFileName(o2);

                int headCompare = f1.head.compareToIgnoreCase(f2.head);
                if (headCompare != 0) return headCompare;

                return Integer.compare(f1.num, f2.num);
            }
        });

        System.out.println(Arrays.toString(files));
    }

    public static FileData parseFileName(String fileName) {
        String head = "";
        String num = "";
        int index = 0;

        while(index < fileName.length() && !Character.isDigit(fileName.charAt(index))) {
            head += fileName.charAt(index);
            index++;
        }
        while(index < fileName.length() && Character.isDigit(fileName.charAt(index))) {
            num += fileName.charAt(index);
            index++;
        }

        int numValue = num.isEmpty() ? 0 : Integer.parseInt(num);

        return new FileData(head, numValue);
    }

    static class FileData {
        String head;
        int num;
        public FileData(String head, int num) {
            this.head = head;
            this.num = num;
        }
    }
}

