package ServerSideRequest;

import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class intraprocedural {

    HttpServletRequest request;
    HttpServletResponse response;

//10 Test

    //bad
    protected void doGetSourceInSinkSinge() throws IOException {
        URL intra = new URL("abc" + request.getParameter("url"));
        HttpURLConnection conn = (HttpURLConnection) intra.openConnection();
    }
    //bad
    protected void doGetSourceInSinkPlusStr() throws IOException {
        URL intra = new URL( request.getParameter("url")+"abc");
        HttpURLConnection conn = (HttpURLConnection) intra.openConnection();

    }
    //bad
    protected void doGetSourceInPlusStrSink() throws IOException {
        URL intra = new URL( "abc" + request.getParameter("url"));
        HttpURLConnection conn = (HttpURLConnection) intra.openConnection();
    }
    //bad
    protected void doGetSourceInStrSinkStr() throws IOException {
        URL intra = new URL( "abc" + request.getParameter("url") + "def");
        HttpURLConnection conn = (HttpURLConnection) intra.openConnection();
    }



    //one Step
    //bad
    protected void doGetOneStep() throws IOException {
        String str1 = request.getParameter("page");
        URL intra = new URL(  str1 );
        HttpURLConnection conn = (HttpURLConnection) intra.openConnection();
    }
//good
    protected void doGetOneStepDesinfekt() throws IOException {
        String str1 = request.getParameter("url");
        if (validate(str1)) {
            URL intra = new URL(str1);
            HttpURLConnection conn = (HttpURLConnection) intra.openConnection();
        }

    }
//two Steps
    //bad
    protected void doGetTwoSteps() throws IOException {
        String str1 = request.getParameter("page");
        String str2 = str1;
        URL intra = new URL( str2 );
        HttpURLConnection conn = (HttpURLConnection) intra.openConnection();
    }
//good
    protected void doGetTwoStepsDesinfekt() throws IOException {
        String str1 = request.getParameter("page");
        String str2 = str1;
        if (validate(str2)) {
            URL intra = new URL(  str2 );
            HttpURLConnection conn = (HttpURLConnection) intra.openConnection();
        }

    }
//tree Steps
    //bad
    protected void doGetTreeSteps() throws IOException {
        String str1 = request.getParameter("page");
        String str2 = str1;
        String str3 = str2;
        URL intra = new URL(  str3 );
        HttpURLConnection conn = (HttpURLConnection) intra.openConnection();

    }
//good
    protected void doGetTreeStepsDesinfekt() throws IOException {
        String str1 = request.getParameter("page");
        String str2 = str1;
        String str3 = str2;
        if(validate(str3)){
            URL intra = new URL(  str3 );
            HttpURLConnection conn = (HttpURLConnection) intra.openConnection();
        }
    }



    boolean validate(String s) throws IOException {
        String urlWhiteListed = "https://example.com/";

        return s.startsWith(urlWhiteListed);
    }


}
