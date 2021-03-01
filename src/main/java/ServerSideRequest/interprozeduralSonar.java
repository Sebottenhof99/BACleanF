package ServerSideRequest;

import org.apache.commons.httpclient.util.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class interprozeduralSonar {

    HttpServletRequest request;
    HttpServletResponse response;

//10 Tests - 7bad + 3 good

    void doGetOneLayer() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Single(requestParameter);
        URL url = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    }

    void doGetOneLayerSafe() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Single(requestParameter);
        String urlWhiteListed = "https://example.com/";

        if (requestParameter.startsWith(urlWhiteListed)) {
            URL url = new URL(  requestParameter );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        }
    }


    void doGetTwoLayer() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Chain2(requestParameter);
        URL url = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    }

    void doGetTwoLayerSafe() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Chain2(requestParameter);
        String urlWhiteListed = "https://example.com/";
        if(requestParameter.startsWith(urlWhiteListed)){
            URL url = new URL(  requestParameter );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        }
    }

    void doGetTreeLayer() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Chain3(requestParameter);
        URL url = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    }


    void doGetTreeLayerSafe() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Chain3(requestParameter);
        String urlWhiteListed = "https://example.com/";
        if(requestParameter.startsWith(urlWhiteListed)){
            URL url = new URL(  requestParameter );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        }
    }


    // call positions
    void doGetTreeLayerPositionOne() throws IOException {

        String afterTransmission  = transmissionMethod1Chain3(request.getParameter("URL"));
        URL url = new URL(  afterTransmission );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    }

    void doGetTreeLayerPositionTwo() throws IOException {
        String requestParameter = request.getParameter("page");
        URL url = new URL(  transmissionMethod1Chain3(requestParameter) );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    }

    void doGetTreeLayerPositionTree() throws IOException {
        String requestParameter = request.getParameter("URL");
        requestParameter = transmissionMethod1Chain3(requestParameter);
        URL url = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
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


}
