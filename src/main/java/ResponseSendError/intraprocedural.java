package ResponseSendError;

import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.commons.text.StringEscapeUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class intraprocedural {

    HttpServletRequest request;
    HttpServletResponse response;


    //14 Tests

    //bad
    protected void doGetSourceInSinkSinge() throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, request.getParameter("page") );
    }
    //bad
    protected void doGetSourceInSinkPlusStr() throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND,
                 request.getParameter("page") + " was not found.");
    }
    //bad
    protected void doGetSourceInPlusStrSink() throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND,
                "The page " + request.getParameter("page") );
    }
    //bad
    protected void doGetSourceInStrSinkStr() throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND,
                "The page " + request.getParameter("page") + " was not found.");

    }

    //good
    protected void doGetSourceInSinkSingePlusDesinfekt() throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND,
                StringEscapeUtils.escapeEcmaScript(request.getParameter("page")) );

    }
    //good
    protected void doGetSourceInSinkPlusDesinfektPlusStr() throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND,
                  StringEscapeUtils.escapeEcmaScript(request.getParameter("page"))  + " was not found.");
    }
    //good
    protected void doGetSourceInSinkPlusStrDesinfekt() throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND,
                "The page " +  StringEscapeUtils.escapeEcmaScript(request.getParameter("page")));
    }
    //good
    protected void doGetSourceInSinkPlusStrDesinfektStr() throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND,
                "The page " +  StringEscapeUtils.escapeEcmaScript(request.getParameter("page"))+ " was not found.");
    }



//one Step
//bad
    protected void doGetOneStep() throws IOException {
        String str1 = request.getParameter("page");
        response.sendError(HttpServletResponse.SC_NOT_FOUND, str1);
    }
    //good
    protected void doGetOneStepDesinfekt() throws IOException {
        String str1 = StringEscapeUtils.escapeEcmaScript(request.getParameter("page"));
        response.sendError(HttpServletResponse.SC_NOT_FOUND, str1);
    }
//two Steps
//bad
    protected void doGetTwoSteps() throws IOException {
        String str1 = request.getParameter("page");
        String str2 = str1;
        response.sendError(HttpServletResponse.SC_NOT_FOUND, str2);
    }
    //good
    protected void doGetTwoStepsDesinfekt() throws IOException {
        String str1 = StringEscapeUtils.escapeEcmaScript(request.getParameter("page"));
        String str2 = str1;
        response.sendError(HttpServletResponse.SC_NOT_FOUND, str2);
    }
//tree Steps
//bad
    protected void doGetTreeSteps() throws IOException {
        String str1 = request.getParameter("page");
        String str2 = str1;
        String str3 = str2;
        response.sendError(HttpServletResponse.SC_NOT_FOUND, str3);
    }
    //good
    protected void doGetTreeStepsDesinfekt() throws IOException {
        String str1 = StringEscapeUtils.escapeEcmaScript(request.getParameter("page"));
        String str2 = str1;
        String str3 = str2;
        response.sendError(HttpServletResponse.SC_NOT_FOUND, str3);
    }




}
