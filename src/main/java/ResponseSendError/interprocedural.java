package ResponseSendError;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class interprocedural {

    HttpServletRequest request;
    HttpServletResponse response;

    //10 Tests - 7bad + 3 good
//bad
    void doGetOneLayer() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Single(requestParameter);
        response.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameter);
    }
    //good
    void doGetOneLayerSafe() throws IOException {
        String requestParameter =  StringEscapeUtils.escapeEcmaScript(request.getParameter("page"));
        requestParameter = transmissionMethod1Single(requestParameter);
        response.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameter);
    }
    //bad
    void doGetTwoLayer() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Chain2(requestParameter);
        response.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameter);
    }
    //good
    void doGetTwoLayerSafe() throws IOException {
        String requestParameter = StringEscapeUtils.escapeEcmaScript(request.getParameter("page"));
        requestParameter = transmissionMethod1Chain2(requestParameter);
        response.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameter);
    }
    //bad
    void doGetTreeLayer() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Chain3(requestParameter);
        response.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameter);
    }

    //good
    void doGetTreeLayerSafe() throws IOException {
        String requestParameter = StringEscapeUtils.escapeEcmaScript(request.getParameter("page"));
        requestParameter = transmissionMethod1Chain3(requestParameter);
        response.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameter);
    }


// call positions
//bad
    void doGetTreeLayerPositionOne() throws IOException {

        String afterTransmission  = transmissionMethod1Chain3(request.getParameter("URL"));
        response.sendError(HttpServletResponse.SC_NOT_FOUND, afterTransmission);
    }
    //bad
    void doGetTreeLayerPositionTwo() throws IOException {
        String requestParameter = request.getParameter("page");
        response.sendError(HttpServletResponse.SC_NOT_FOUND, transmissionMethod1Chain3(requestParameter));
    }
    //bad
    void doGetTreeLayerPositionTree() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Chain3(requestParameter);
        response.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameter);
    }
    //bad
    void doGetTreeLayerPositionFour() throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, transmissionMethod1Chain3(request.getParameter("URL")));
    }


    //helper Methods

    static String transmissionMethod1Single(String userInput) {
        String intermediateVariable1 = userInput;
        return intermediateVariable1;
    }

    static String transmissionMethod1Chain2(String userInput) {
        String intermediateVariable1 = userInput;
        return transmissionMethod2Single(intermediateVariable1);
    }

    static String transmissionMethod1Chain3(String userInput) {
        String intermediateVariable1 = userInput;
        return transmissionMethod2Chain(intermediateVariable1);
    }


    static String transmissionMethod2Single(String userInput) {
        String intermediateVariable1 = userInput;
        String intermediateVariable2 = intermediateVariable1;
        return intermediateVariable2;
    }

    static String transmissionMethod2Chain(String userInput) {
        String intermediateVariable1 = userInput;
        String intermediateVariable2 = intermediateVariable1;
        return transmissionMethod3Chain(intermediateVariable2);
    }

    static String transmissionMethod3Chain(String userInput) {
        String intermediateVariable1 = userInput;
        String intermediateVariable2 = intermediateVariable1;
        String intermediateVariable3 = intermediateVariable2;
        return intermediateVariable3;
    }


}

