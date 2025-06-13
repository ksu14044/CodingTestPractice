package Solutions;

public class 붕대감기 {
    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2,10},{9,15},{10, 5},{11,5}};
        System.out.println(solution(bandage, health, attacks));
    }

    public static int solution(int[] bandage, int health, int[][] attacks){
        int maxHealth = health;
        int combo = 0;
        int idx = 0;
        int lastTime = attacks[attacks.length - 1][0];
        for(int t = 1 ; t <= lastTime ; t++){
            if(idx < attacks.length && attacks[idx][0] == t){
                health -= attacks[idx][1];
                combo = 0;
                idx++;
                if(health <= 0) return -1;
            } else {
                health += bandage[1];
                combo ++;
                if(combo == bandage[0]) {
                    health += bandage[2];
                    combo = 0;
                }
                if(health > maxHealth) health = maxHealth;
            }
        }
        return health;
    }
}
