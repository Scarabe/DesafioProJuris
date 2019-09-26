package mapper;

import exception.InvalidMatrixFormat;
import model.request.QuartersForInspectionRequest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HttpRequestMapper  {

    private static final int MATRIX_SIZE = 56;

    public QuartersForInspectionRequest httpRequestToQuartersRequest(String httpRequestJson) throws InvalidMatrixFormat {
        if(httpRequestJson.length()!= MATRIX_SIZE){
            throw new InvalidMatrixFormat();
        }
        List<String> listOfElements = toListOfElements(httpRequestJson);

        List<List<String>> list = toListOfList(listOfElements);


        return new QuartersForInspectionRequest(toListOfIntegers(list));
    }

    private List<String> toListOfElements(final String request){
        return Arrays.asList(request.replace("[[","")
                .replace("[","")
                .replace("],", "]")
                .replace("]]","]")
                .replace(" ","")
                .split("]"));
    }

    private List<List<String>> toListOfList(final List<String> request){
        return request.stream().map(e-> Arrays.asList(e.split(","))).collect(Collectors.toList());
    }

    private List<List<Integer>> toListOfIntegers(final List<List<String>> request){
        return request.stream().map(e-> e.stream().map(Integer::parseInt).collect(Collectors.toList())).collect(Collectors.toList());
    }
}
