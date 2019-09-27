package service;

import model.request.QuartersForInspectionRequest;
import model.response.IndustrialInspectionResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InspectionService {

    private static int ROW;
    private static int COL;
    private static int count;

    public IndustrialInspectionResponse inspectSpots(final QuartersForInspectionRequest quartersForInspectionRequest) {

        Integer totalArea = verifyTotalArea(quartersForInspectionRequest);
        Integer biggestSpotArea = verifyBiggestSpotArea(quartersForInspectionRequest);
        Integer numberOfSpots = verifyNumberOfSpots(quartersForInspectionRequest);
        return new IndustrialInspectionResponse(totalArea,
                numberOfSpots,
                (float) totalArea / numberOfSpots,
                biggestSpotArea);
    }

    private Integer verifyTotalArea(final QuartersForInspectionRequest quarters) {
        List<List<Integer>> validationList = new ArrayList<>();
        for (int[] quarter : quarters.getQuarters()) {
            validationList.add(Arrays.stream(quarter).boxed().collect(Collectors.toList()));
        }
        return Math.toIntExact(validationList.stream().mapToLong(e -> e.stream().filter(i -> i.equals(1)).count()).sum());
    }

    private Integer verifyNumberOfSpots(final QuartersForInspectionRequest quarters) {
        int[][] matrix = quarters.getQuarters();
        if (matrix == null || matrix.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    result++;
                    doFill(matrix, i, j);
                }
            }
        }
        return result;
    }

    private static void doFill(int[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] == 0) {
            return;
        }
        matrix[row][col] = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for (int i = 0; i < dr.length; i++) {
            doFill(matrix, row + dr[i], col + dc[i]);
        }
    }

    private Integer verifyBiggestSpotArea(final QuartersForInspectionRequest quarters) {
        ROW = quarters.getQuarters().length;
        COL = quarters.getQuarters()[0].length;
        count = 1;
        return largestRegion(quarters.getQuarters());
    }

    private static boolean isSafe(int[][] matrix, int row, int col, boolean[][] visited) {
        return ((row >= 0) &&
                (row < ROW) &&
                (col >= 0) &&
                (col < COL) &&
                (matrix[row][col] == 1 &&
                !visited[row][col]));
    }

    private static void doFillSafe(int[][] matrix, int row, int col, boolean[][] visited) {
        int[] rowNbr = {-1, 0, 0, 1};
        int[] colNbr = {0, -1, 1, 0};

        visited[row][col] = true;
        for (int k = 0; k < 4; ++k) {
            if (isSafe(matrix, row + rowNbr[k], col + colNbr[k], visited)) {
                count++;
                doFillSafe(matrix, row + rowNbr[k], col + colNbr[k], visited);
            }
        }
    }

    private static int largestRegion(int[][] M) {
        boolean[][] visited = new boolean[ROW][COL];
        int result = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    doFillSafe(M, i, j, visited);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }
}
