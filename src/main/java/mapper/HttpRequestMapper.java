package mapper;

import exception.InvalidMatrixFormat;
import model.request.QuartersForInspectionRequest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HttpRequestMapper {

    private static final int MATRIX_SIZE = 56;

    public QuartersForInspectionRequest httpRequestToQuartersRequest(String httpRequestJson) throws InvalidMatrixFormat {
        if (httpRequestJson.length() != MATRIX_SIZE) {
            throw new InvalidMatrixFormat();
        }
        String[] listOfElements = toListOfElements(httpRequestJson);

        int[][] list = toFinalList(listOfElements);


        return new QuartersForInspectionRequest(list);
    }

    private String[] toListOfElements(final String request) {
        return request.replace("[[", "")
                .replace("[", "")
                .replace("],", "]")
                .replace("]]", "]")
                .replace(" ", "")
                .split("]");
    }

    private int[][] toFinalList(final String[] request) {
        int[][] list = new int[request.length][request[0].split(",").length];
        for (int i = 0; i < request.length; i++) {
            String[] line = request[i].split(",");
            for (int i1 = 0; i1 < line.length; i1++) {
                list[i][i1] = Integer.parseInt(line[i1]);
            }
        }
        return list;
    }
}
