package Solutions;

public class 신규아이디추천 {
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String result = new_id.toLowerCase();
        result = result.replaceAll("[^a-zA-Z0-9-_.]", "");
        result = result.replaceAll("[.]{2,}", ".");
        result = result.replaceAll("^\\.|\\.$", "");
        if(result.isEmpty()){
            result = "a";
        }
        if(result.length() > 15){
            result = result.substring(0, 15);
            result = result.replaceAll("\\.$", "");
        }
        while(result.length() < 3){
            result += result.charAt(result.length() - 1);
        }

        System.out.println(result);
    }
}
