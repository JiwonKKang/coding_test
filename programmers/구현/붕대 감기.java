import java.util.HashMap;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        HashMap<Integer, Integer> attack = new HashMap<>();

        for (int[] attackArray : attacks) {
            attack.put(attackArray[0], attackArray[1]);
        }

        int time = 0;
        int maxHealth = health;
        int successCount = 0;

        while (time < attacks[attacks.length-1][0]) {

            time++;

            if (attack.containsKey(time)) {
                health -= attack.get(time);
                if (health <= 0) {
                    break;
                }
                successCount = 0;
                continue;
            }

            health += bandage[1];

            if (health > maxHealth) {
                health = maxHealth;
            }

            successCount++;

            if (successCount == bandage[0]) {
                health += bandage[2];
                successCount = 0;
                if (health > maxHealth) {
                    health = maxHealth;
                }
            }

        }

        if (health <= 0) {
            return -1;
        }

        return health;
    }
}
