package ServerSideRequest;

import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class interprocedural {

    HttpServletRequest request;


    //10 Tests - 7bad + 3 good

    void doGetOneLayer() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Single(requestParameter);
        URL interProz = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) interProz.openConnection();
    }

    void doGetOneLayerSafe() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Single(requestParameter);
        if(validate(requestParameter)){
            URL interProz = new URL(  requestParameter );
            HttpURLConnection conn = (HttpURLConnection) interProz.openConnection();
        }
    }


    void doGetTwoLayer() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Chain2(requestParameter);
        URL interProz = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) interProz.openConnection();
    }

    void doGetTwoLayerSafe() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Chain2(requestParameter);
        if(validate(requestParameter)){
            URL interProz = new URL(  requestParameter );
            HttpURLConnection conn = (HttpURLConnection) interProz.openConnection();
        }
    }

    void doGetTreeLayer() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Chain3(requestParameter);
        URL interProz = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) interProz.openConnection();
    }


    void doGetTreeLayerSafe() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Chain3(requestParameter);
        if(validate(requestParameter)){
            URL interProz = new URL(  requestParameter );
            HttpURLConnection conn = (HttpURLConnection) interProz.openConnection();
        }
    }


    // call positions
    void doGetTreeLayerPositionOne() throws IOException {

        String afterTransmission  = transmissionMethod1Chain3(request.getParameter("URL"));
        URL interProz = new URL(  afterTransmission );
        HttpURLConnection conn = (HttpURLConnection) interProz.openConnection();
    }

    void doGetTreeLayerPositionTwo() throws IOException {
        String requestParameter = request.getParameter("page");
        URL interProz = new URL(  transmissionMethod1Chain3(requestParameter) );
        HttpURLConnection conn = (HttpURLConnection) interProz.openConnection();
    }

    void doGetTreeLayerPositionTree() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Chain3(requestParameter);
        URL interProz = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) interProz.openConnection();
    }

    void doGetTreeLayerPositionFour() throws IOException {
        new URL(   transmissionMethod1Chain3(request.getParameter("URL")) ).openConnection();
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

    boolean validate(String s) throws IOException {
        String urlWhiteListed = "https://example.com/";

        return s.startsWith(urlWhiteListed);
    }

}
