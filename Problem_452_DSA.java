import java.util.Arrays;

public class Problem_452_DSA{
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> Long.compare(a[1], b[1]));

        int arrows = 1;
        long arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {

            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }

}