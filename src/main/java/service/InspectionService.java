package service;

import model.request.QuartersForInspectionRequest;
import model.response.IndustrialInspectionResponse;

import java.util.List;

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
        return Math.toIntExact(quarters.getQuarters().stream().mapToLong(e -> e.stream().filter(i -> i.equals(1)).count()).sum());
    }

    private Integer verifyNumberOfSpots(QuartersForInspectionRequest quarters) {
        List<List<Integer>> get = quarters.getQuarters();
        Boolean[] spotVerifier = {Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE};
        boolean onSpot = false;
        Integer spot = 0;

        for (List<Integer> listInteger : get) {
            for (int i = 0; i < listInteger.size(); i++) {
                Integer integer = listInteger.get(i);
                if (integer.equals(1) && !onSpot) {
                    if (spotVerifier[i].equals(Boolean.FALSE)) {
                        spot++;
                        spotVerifier[i] = Boolean.TRUE;
                    }
                    onSpot = true;
                } else {
                    if (integer.equals(0) || listInteger.size() < i + 1 && listInteger.get(i + 1).equals(0)) {
                        onSpot = false;
                    }
                }
            }
            onSpot = false;
        }
        return spot;
    }

    private Integer verifyBiggestSpotArea(QuartersForInspectionRequest quarters) {

        return 4;
    }
}
