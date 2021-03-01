package ServerSideRequest;

import org.apache.commons.httpclient.util.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class intraproceduralSonar {
    HttpServletRequest request;
    HttpServletResponse response;

//10 Test

    //bad
    protected void doGetSourceInSinkSinge() throws IOException {
        URL url = new URL("abc" + request.getParameter("url"));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    }
    //bad
    protected void doGetSourceInSinkPlusStr() throws IOException {
        URL url = new URL( request.getParameter("url")+"abc");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    }
    //bad
    protected void doGetSourceInPlusStrSink() throws IOException {
        URL url = new URL( "abc" + request.getParameter("url"));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    }
    //bad
    protected void doGetSourceInStrSinkStr() throws IOException {
        URL url = new URL( "abc" + request.getParameter("url") + "def");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    }



    //one Step
    //bad
    protected void doGetOneStep() throws IOException {
        String str1 = request.getParameter("page");
        URL url = new URL(  str1 );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    }
    //good
    protected void doGetOneStepDesinfekt() throws IOException {
        String str1 = request.getParameter("url");
        String urlWhiteListed = "https://example.com/";

        if (str1.startsWith(urlWhiteListed)) {
            URL url = new URL(str1);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        }

    }
    //two Steps
    //bad
    protected void doGetTwoSteps() throws IOException {
        String str1 = request.getParameter("page");
        String str2 = str1;
        URL url = new URL( str2 );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    }
    //good
    protected void doGetTwoStepsDesinfekt() throws IOException {
        String str1 = request.getParameter("page");
        String str2 = str1;
        String urlWhiteListed = "https://example.com/";

        if (str2.startsWith(urlWhiteListed)) {
            URL url = new URL(  str2 );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        }

    }
    //tree Steps
    //bad
    protected void doGetTreeSteps() throws IOException {
        String str1 = request.getParameter("page");
        String str2 = str1;
        String str3 = str2;
        URL url = new URL(  str3 );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    }
    //good
    protected void doGetTreeStepsDesinfekt() throws IOException {
        String str1 = request.getParameter("page");
        String str2 = str1;
        String str3 = str2;
        String urlWhiteListed = "https://example.com/";

        if (str3.startsWith(urlWhiteListed)) {
            URL url = new URL(  str3 );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        }
    }



    boolean validate(String s) throws IOException {
        String urlWhiteListed = "https://example.com/";

        return s.startsWith(urlWhiteListed);
    }



}
