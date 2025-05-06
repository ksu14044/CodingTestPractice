package Solutions;

public class 지폐접기 {
    public static void main(String[] args) {
        int[] wallet = {50, 50};
        int[] bill = {100, 241};
        int answer = 0;
        while(!isFit(wallet,bill)){
            answer++;
            int billWidth = bill[0];
            int billHeight = bill[1];
            if(billWidth >= billHeight){
                billWidth /= 2;
                bill[0] = billWidth;
            } else if(billHeight > billWidth){
                billHeight /= 2;
                bill[1] = billHeight;
            }
            if(isFit(wallet,bill)){
                break;
            }
        }
        System.out.println(answer);

    }
    public static boolean isFit(int[] wallet, int[] bill){
        int walletWidth = wallet[0];
        int walletHeight = wallet[1];
        int billWidth = bill[0];
        int billHeight = bill[1];
        int reverseBillWidth = bill[1];
        int reverseBillHeight = bill[0];
        if((walletWidth >= billWidth && walletHeight >= billHeight) || (walletWidth >= reverseBillWidth && walletHeight >= reverseBillHeight)){
            return true;
        }
        return false;
    }
}
