package model.response;

public class IndustrialInspectionResponse {

    private final Integer totalArea;
    private final Integer numberOfSpots;
    private final Float spotsAverageArea;
    private final Integer biggestSpotArea;

    public IndustrialInspectionResponse(Integer totalArea, Integer numberOfSpots, Float spotsAverageArea, Integer biggestSpotArea) {
        this.totalArea = totalArea;
        this.numberOfSpots = numberOfSpots;
        this.spotsAverageArea = spotsAverageArea;
        this.biggestSpotArea = biggestSpotArea;
    }

    public Integer getTotalArea() {
        return totalArea;
    }

    public Integer getNumberOfSpots() {
        return numberOfSpots;
    }

    public Float getSpotsAverageArea() {
        return spotsAverageArea;
    }

    public Integer getBiggestSpotArea() {
        return biggestSpotArea;
    }

    public String toJson() {
        return "{" +
                "\"total_area\":" + totalArea +
                ",\"number_of_spots\":" + numberOfSpots +
                ",\"spots_average_area\":" + spotsAverageArea +
                ",\"biggest_spot_area\":" + biggestSpotArea +
                '}';
    }
}
