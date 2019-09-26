package model.request;

import java.util.List;

public class QuartersForInspectionRequest {
    private final List<List<Integer>> quarters;

    public QuartersForInspectionRequest(List<List<Integer>> quarters) {
        this.quarters = quarters;
    }

    public List<List<Integer>> getQuarters() {
        return quarters;
    }
}
