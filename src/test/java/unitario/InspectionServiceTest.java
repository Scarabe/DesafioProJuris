package unitario;

import model.request.QuartersForInspectionRequest;
import model.response.IndustrialInspectionResponse;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import service.InspectionService;

public class InspectionServiceTest {

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Test
    public void whenInspectSpotsIsValid() {
        QuartersForInspectionRequest mockQuarter = generateMockQuarter();

        InspectionService inspectionService = new InspectionService();
        IndustrialInspectionResponse ret = inspectionService.inspectSpots(mockQuarter);

        collector.checkThat(ret.getTotalArea(), CoreMatchers.equalTo(8));
        collector.checkThat(ret.getNumberOfSpots(), CoreMatchers.equalTo(2));
        collector.checkThat(ret.getSpotsAverageArea(), CoreMatchers.equalTo(4.0F));
        collector.checkThat(ret.getBiggestSpotArea(), CoreMatchers.equalTo(4));
    }

    private QuartersForInspectionRequest generateMockQuarter() {
        return new QuartersForInspectionRequest(new int[][]{{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}});
    }
}
