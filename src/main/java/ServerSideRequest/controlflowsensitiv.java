package ServerSideRequest;

import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class controlflowsensitiv {
    HttpServletRequest request;
    void  doGet() throws IOException {
        String requestParameter = request.getParameter("parameter");
        requestParameter = "safeString";
        URL controlFlow = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) controlFlow.openConnection();
    }

    void  doGet2() throws IOException {
        String requestParameter = request.getParameter("parameter");
        requestParameter = "safeString";
        requestParameter = request.getParameter("parameter");
        requestParameter = "safeString";
        URL controlFlow = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) controlFlow.openConnection();

    }

    void  doGet3() throws IOException {
        String requestParameter = request.getParameter("parameter");
        requestParameter = "safeString";
        requestParameter = request.getParameter("parameter");
        requestParameter = "safeString";
        requestParameter = request.getParameter("parameter");
        requestParameter = "safeString";
        URL controlFlow = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) controlFlow.openConnection();


    }

    void  doGet31() throws IOException {
        String requestParameter = "safeString";
        requestParameter = request.getParameter("parameter");
        URL controlFlow = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) controlFlow.openConnection();


    }

    void  doGet32() throws IOException {
        String requestParameter = "safeString";
        requestParameter = request.getParameter("parameter");
        requestParameter = "safeString";
        requestParameter = request.getParameter("parameter");
        URL controlFlow = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) controlFlow.openConnection();


    }

    void  doGet33() throws IOException {
        String requestParameter = "safeString";
        requestParameter = request.getParameter("parameter");
        requestParameter = "safeString";
        requestParameter = request.getParameter("parameter");
        requestParameter = "safeString";
        requestParameter = request.getParameter("parameter");
        URL controlFlow = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) controlFlow.openConnection();


    }

}
