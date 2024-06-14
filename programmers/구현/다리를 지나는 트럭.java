import java.util.*;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(truck_weights[0]);
        for (int i = 1; i < truck_weights.length; i++) {

            if (queue.size() < bridge_length  && truck_weights[i]  + queue.stream().reduce(Integer::sum).get() <= weight) {
                queue.offer(truck_weights[i]);
                time++;
            } else {
                queue.offer(0);
                time++;
                i--;
            }

            if (queue.size() == bridge_length) {
                queue.poll();
            }
        }

        return time  + bridge_length;
    }
}
