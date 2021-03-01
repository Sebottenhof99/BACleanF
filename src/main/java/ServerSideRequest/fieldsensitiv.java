package ServerSideRequest;

import helper.A;
import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class fieldsensitiv {


    HttpServletRequest request;
    HttpServletResponse response;


    //bad
    void doGetSimple() throws IOException {
        A a = new A();
        a.requestParameter = request.getParameter("url");
        URL feldSensitive = new URL(  a.requestParameter );
        HttpURLConnection conn = (HttpURLConnection) feldSensitive.openConnection();
    }
    //bad
    void doGetTwoInstanzes() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a2.requestParameter = "safeString";
        a1.requestParameter = request.getParameter("url");
        URL feldSensitive = new URL(  a1.requestParameter );
        HttpURLConnection conn = (HttpURLConnection) feldSensitive.openConnection();
    }
    //good
    void doGetTwoInstanzesSafe() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a2.requestParameter = "safeString";
        a1.requestParameter = request.getParameter("url");
        URL feldSensitive = new URL(  a2.requestParameter );
        HttpURLConnection conn = (HttpURLConnection) feldSensitive.openConnection();
    }
    //bad
    void doGetTwoInstanzesDesinfect() throws IOException {
        A a1 = new A();
        A a2 = new A();

        a1.requestParameter = request.getParameter("url");
        a2.requestParameter = "safeString";
        if(validate(a2.requestParameter)){
            URL feldSensitive = new URL(  a1.requestParameter );
            HttpURLConnection conn = (HttpURLConnection) feldSensitive.openConnection();
        }
    }

    //bad
    void doGetTwoInstanzesDesinfectSonar() throws IOException {
        A a1 = new A();
        A a2 = new A();

        a1.requestParameter = request.getParameter("url");
        a2.requestParameter = "safeString";
        String urlWhiteListed = "https://example.com/";


        if ( a2.requestParameter.startsWith(urlWhiteListed)) {
            URL feldSensitive = new URL(  a1.requestParameter );
            HttpURLConnection conn = (HttpURLConnection) feldSensitive.openConnection();
        }
    }

    boolean validate(String s) throws IOException {
        String urlWhiteListed = "https://example.com/";

        return s.startsWith(urlWhiteListed);
    }

}
