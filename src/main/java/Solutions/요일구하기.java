package Solutions;

public class 요일구하기 {
    public static void main(String[] args) {
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int a = 5;
        int b = 24;
        int days = 0;
        for(int i = 1; i < a ; i++){
            days += month[i];
        }
        days += b - 1;
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int index = days % 7;
        System.out.println(day[index]);
    }
}
