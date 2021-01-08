package ServerSideRequest;

import org.apache.commons.httpclient.util.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class Source_Target {

    HttpServletRequest req;
    HttpServletResponse resp;

    protected void doGet() throws IOException {
        URL url = new URL(req.getParameter("url"));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
    }



}
