package model.request;

import java.util.List;

public class QuartersForInspectionRequest {
    private final int[][] quarters;

    public QuartersForInspectionRequest(int[][] quarters) {
        this.quarters = quarters;
    }

    public int[][] getQuarters() {
        return quarters;
    }
}
