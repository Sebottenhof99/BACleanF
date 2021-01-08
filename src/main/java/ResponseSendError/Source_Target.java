package ResponseSendError;

import org.apache.commons.httpclient.util.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class Source_Target {

    HttpServletRequest req;
    HttpServletResponse resp;

    protected void doGet() throws IOException {

        String requestParameter1 =  req.getParameter("page");
        String requestParameter2 = requestParameter1;
        String requestParameter3 = requestParameter2;
        resp.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameter3);


    }
}
