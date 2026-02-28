package com.mort.airthmethic;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 最多可参加的会议数目 {
    public int maxEvents(int[][] events) {
        int max = 0;
        int ans = 0;
        for (int i = 0; i < events.length; i++) {
            max = Math.max(max, events[i][1]);
        }

        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0, j = i; i < max; i++) {
            while (j < events.length && events[j][0] <= i) {
                pq.offer(events[j][1]);
                j++;
            }
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            while (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }

        }
        return ans++;

    }
}
