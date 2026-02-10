import java.util.*;

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        int n = tickets.length;

        for (int i = 0; i < n; i++) {
            q.add(i);
        }

        while (tickets[k] != 0) {
            int front = q.peek();
            tickets[front]--;

            if (tickets[front] > 0) {
                q.add(front);
            }

            q.poll();
            time++;
        }
        return time;
    }
}
