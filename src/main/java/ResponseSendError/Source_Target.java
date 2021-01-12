package ResponseSendError;

import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.commons.text.StringEscapeUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class Source_Target {

    HttpServletRequest request;
    HttpServletResponse response;



    protected void doGet() throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND,
                "The page \"" + request.getParameter("page") + "\" was not found.");
    }

    protected void doGet2() throws IOException {

        response.sendError(HttpServletResponse.SC_NOT_FOUND,
                "The page \"" + StringEscapeUtils.escapeEcmaScript(request.getParameter("page"))
                        + "\" was not found.");
    }

}
