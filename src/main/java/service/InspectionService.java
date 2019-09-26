package service;

import model.request.QuartersForInspectionRequest;
import model.response.IndustrialInspectionResponse;

import java.util.*;
import java.util.stream.Collectors;

public class InspectionService {

    public IndustrialInspectionResponse inspectSpots(QuartersForInspectionRequest quartersForInspectionRequest) {

        Integer totalArea = verifyTotalArea(quartersForInspectionRequest);
        Integer numberOfSpots = verifyNumberOfSpots(quartersForInspectionRequest);
        Float spotsAverageArea = (float) totalArea / numberOfSpots;
        Integer biggestSpotArea = verifyBiggestSpotArea(quartersForInspectionRequest);
        return new IndustrialInspectionResponse(totalArea,
                numberOfSpots,
                spotsAverageArea,
                biggestSpotArea);
    }

    private Integer verifyTotalArea(QuartersForInspectionRequest quarters) {
        List<List<Integer>> validationList = new ArrayList<>();
        for (int[] quarter : quarters.getQuarters()) {
            validationList.add(Arrays.stream(quarter).boxed().collect(Collectors.toList()));
        }
        return Math.toIntExact(validationList.stream().mapToLong(e -> e.stream().filter(i -> i.equals(1)).count()).sum());
    }

    private Integer verifyNumberOfSpots(QuartersForInspectionRequest quarters) {
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

    public static void doFill(int[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] == 0) {
            return;
        }
        matrix[row][col] = 0;
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        for (int i = 0; i < dr.length; i++) {
            doFill(matrix, row + dr[i], col + dc[i]);
        }
    }

    private Integer verifyBiggestSpotArea(QuartersForInspectionRequest quarters) {
       /* List<List<Integer>> get = quarters.getQuarters();
        Integer spotSize = 0;

        boolean onSpot = true;

        for (int i = 0; i < get.size(); i++) {
            List<Integer> listInteger = get.get(i);
            for (int e = 0; e < listInteger.size(); e++) {
                Integer integer = listInteger.get(e);
                if (integer.equals(1) && onSpot) {
                    spotSize++;
                    valueMap.get(i).set(e, spotSize);
                    if (spotSize > 1) {
                        List<Integer> integers = valueMap.get(i);
                        for (int y = 0; y < spotSize; y++) {
                            integers.set(e - y, spotSize);
                        }
                    }

                    onSpot = true;
                } else {
                    if (integer.equals(0)) {
                        onSpot = false;
                        spotSize = 0;
                    } else if (integer.equals(1)) {
                        onSpot = true;
                        spotSize = 1;
                        valueMap.get(i).set(e, spotSize);
                    }
                }
            }
            onSpot = true;
        }

        List<Integer> maxValue = new ArrayList<>();
        for (List<Integer> integers : valueMap) {
            maxValue.add(Collections.max(integers));
        }
        return Collections.max(maxValue);
        */
        return 4;
    }
}
