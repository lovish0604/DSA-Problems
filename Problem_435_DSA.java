import java.util.Arrays;
import java.util.Comparator;

public class Problem_435_DSA {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>() {
            public int compare(int[] i1, int[] i2) {
                return Integer.compare(i1[1], i2[1]);
            }
        });

        int end = intervals[0][1];
        int ans = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] arr = intervals[i];

            if (arr[0] < end) {
                ans++;
            } else {
                end = arr[1];
            }
        }

        return ans;
    }
}