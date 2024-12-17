import java.util.*;
import java.io.*;

public class lab09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int caseNum = 0; caseNum < t; caseNum++) {
            int n = scanner.nextInt();
            List<List<int[]>> polygons = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int m = scanner.nextInt();
                List<int[]> vertices = new ArrayList<>();

                for (int j = 0; j < m; j++) {
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    vertices.add(new int[]{x, y});
                }
                polygons.add(vertices);
            }

            if (isContour(polygons)) {
                output.append("TAK\n");
            } else {
                output.append("NIE\n");
            }
        }

        System.out.print(output);
    }

    private static boolean isContour(List<List<int[]>> polygons) {
        polygons.sort(Comparator.comparingInt(lab09::calculateArea));

        for (int i = 1; i < polygons.size(); i++) {
            List<int[]> inner = polygons.get(i - 1);
            List<int[]> outer = polygons.get(i);
            if (!isPolygonInside(inner, outer)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPolygonInside(List<int[]> inner, List<int[]> outer) {
        for (int[] vertex : inner) {
            if (!isPointInsidePolygon(vertex, outer)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPointInsidePolygon(int[] point, List<int[]> polygon) {
        int x = point[0], y = point[1];
        boolean inside = false;

        for (int i = 0, j = polygon.size() - 1; i < polygon.size(); j = i++) {
            int xi = polygon.get(i)[0], yi = polygon.get(i)[1];
            int xj = polygon.get(j)[0], yj = polygon.get(j)[1];

            boolean intersect = ((yi > y) != (yj > y)) &&
                    (x < (xj - xi) * (y - yi) / (yj - yi) + xi);
            if (intersect) {
                inside = !inside;
            }
        }

        return inside;
    }

    private static int calculateArea(List<int[]> polygon) {
        int area = 0;
        for (int i = 0, j = polygon.size() - 1; i < polygon.size(); j = i++) {
            int[] p1 = polygon.get(i);
            int[] p2 = polygon.get(j);
            area += (p1[0] * p2[1] - p2[0] * p1[1]);
        }
        return Math.abs(area) / 2;
    }
}
