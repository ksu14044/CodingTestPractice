package Solutions;

public class 마법의엘리베이터 {
    public static void main(String[] args) {
        int storey = 2554;
        int count = 0;
        while(storey > 0){
            int rest = storey % 10;
            if(rest > 5){
                count += 10 - rest;
                storey += 10 - rest;
            } else if(rest < 5){
                count += rest;
            } else {
                count += 5;
                if((storey/10)%10 >=5){
                    storey += 5;
                }
            }
            storey /= 10;
        }
        System.out.println(count);
    }
}
