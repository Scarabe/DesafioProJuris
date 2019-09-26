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

        collector.checkThat(quarters.getQuarters()[0][0], CoreMatchers.equalTo(1));
        collector.checkThat(quarters.getQuarters()[0][1], CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters()[0][2], CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters()[0][3], CoreMatchers.equalTo(0));

        collector.checkThat(quarters.getQuarters()[1][0], CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters()[1][1], CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters()[1][2], CoreMatchers.equalTo(1));
        collector.checkThat(quarters.getQuarters()[1][3], CoreMatchers.equalTo(0));

        collector.checkThat(quarters.getQuarters()[2][0], CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters()[2][1], CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters()[2][2], CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters()[2][3], CoreMatchers.equalTo(1));

        collector.checkThat(quarters.getQuarters()[3][0], CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters()[3][1], CoreMatchers.equalTo(0));
        collector.checkThat(quarters.getQuarters()[3][2], CoreMatchers.equalTo(1));
        collector.checkThat(quarters.getQuarters()[3][3], CoreMatchers.equalTo(1));
    }

    @Test(expected = InvalidMatrixFormat.class)
    public void whenHttpRequestToQuartersRequestFormatIsInvalid() throws InvalidMatrixFormat {
        HttpRequestMapper httpRequestMapper = new HttpRequestMapper();
        final String invalidRequest = "invalid request";
        httpRequestMapper.httpRequestToQuartersRequest(invalidRequest);
    }

}
