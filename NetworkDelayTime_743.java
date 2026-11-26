import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime_743 {
    public int[] dijkstra(int src, int n,
            ArrayList<ArrayList<int[]>> adj) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        int time[] = new int[n + 1];

        Arrays.fill(time, Integer.MAX_VALUE);

        time[src] = 0;

        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {

            int pair[] = pq.poll();

            int u = pair[0];
            int d = pair[1];

            if (d > time[u]) {
                continue;
            }

            for (int neighbour[] : adj.get(u)) {

                int v = neighbour[0];
                int w = neighbour[1];

                if (d + w < time[v]) {

                    time[v] = d + w;

                    pq.offer(new int[]{v, time[v]});
                }
            }
        }

        return time;
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int time[] : times) {

            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new int[]{v, w});
        }

        int minTime[] = dijkstra(k, n, adj);

        int res = 0;

        for (int i = 1; i <= n; i++) {

            if (minTime[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, minTime[i]);
        }
        return res;
    }
}
