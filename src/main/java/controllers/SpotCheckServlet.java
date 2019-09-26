package controllers;

import exception.InvalidMatrixFormat;
import mapper.HttpRequestMapper;
import model.request.QuartersForInspectionRequest;
import service.InspectionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "spotCheck", urlPatterns = "/spot_check")
public class SpotCheckServlet extends HttpServlet {

    private final HttpRequestMapper httpRequestMapper = new HttpRequestMapper();

    private final InspectionService inspectionService = new InspectionService();

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        try {
            QuartersForInspectionRequest quartersForInspectionRequest =
                    httpRequestMapper.httpRequestToQuartersRequest(req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));

            resp.getWriter().write(inspectionService.inspectSpots(quartersForInspectionRequest).toJson());
        } catch (InvalidMatrixFormat invalidMatrixFormat) {
            resp.getWriter().write("Invalid Matrix Format");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        resp.getWriter().write("Invalid method");
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

}