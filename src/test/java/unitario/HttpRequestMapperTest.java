package unitario;

import exception.InvalidMatrixFormat;
import mapper.HttpRequestMapper;
import model.request.QuartersForInspectionRequest;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class HttpRequestMapperTest {
    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Test
    public void whenHttpRequestToQuartersRequestIsValid() throws InvalidMatrixFormat {
        HttpRequestMapper httpRequestMapper = new HttpRequestMapper();
        final String validRequest = "[[1, 0, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1], [0, 0, 1, 1]]";
        QuartersForInspectionRequest quarters = httpRequestMapper.httpRequestToQuartersRequest(validRequest);

        collector.checkThat(quarters.getQuarters().get(0).get(0), CoreMatchers.equalTo(1));
        collector.checkThat(quarters.getQuarters().get(0).get(1), CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters().get(0).get(2), CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters().get(0).get(3), CoreMatchers.equalTo(0));

        collector.checkThat(quarters.getQuarters().get(1).get(0), CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters().get(1).get(1), CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters().get(1).get(2), CoreMatchers.equalTo(1));
        collector.checkThat(quarters.getQuarters().get(1).get(3), CoreMatchers.equalTo(0));

        collector.checkThat(quarters.getQuarters().get(2).get(0), CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters().get(2).get(1), CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters().get(2).get(2), CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters().get(2).get(3), CoreMatchers.equalTo(1));

        collector.checkThat(quarters.getQuarters().get(3).get(0), CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters().get(3).get(1), CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters().get(3).get(2), CoreMatchers.equalTo(1));
        collector.checkThat(quarters.getQuarters().get(3).get(3), CoreMatchers.equalTo(1));
    }

    @Test(expected = InvalidMatrixFormat.class)
    public void whenHttpRequestToQuartersRequestFormatIsInvalid() throws InvalidMatrixFormat {
        HttpRequestMapper httpRequestMapper = new HttpRequestMapper();
        final String invalidRequest = "invalid request";
        httpRequestMapper.httpRequestToQuartersRequest(invalidRequest);
    }

}
