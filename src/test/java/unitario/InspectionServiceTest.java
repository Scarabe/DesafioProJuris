package unitario;

import model.request.QuartersForInspectionRequest;
import model.response.IndustrialInspectionResponse;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import service.InspectionService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<List<Integer>> mock = new ArrayList<>();

        List<Integer> lineOne = Arrays.asList(1, 1, 0, 0);
        List<Integer> lineTwo = Arrays.asList(1, 1, 0, 0);
        List<Integer> lineThree = Arrays.asList(0, 0, 1, 1);
        List<Integer> lineFour = Arrays.asList(0, 0, 1, 1);
        mock.add(lineOne);
        mock.add(lineTwo);
        mock.add(lineThree);
        mock.add(lineFour);
        return new QuartersForInspectionRequest(mock);
    }
}
