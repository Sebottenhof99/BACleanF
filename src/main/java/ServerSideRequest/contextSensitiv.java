package ServerSideRequest;

import org.apache.commons.httpclient.util.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class contextSensitiv {


    HttpServletRequest request;
    HttpServletResponse response;

    void doGetOneLayer() throws IOException {
        String safeString = "parameter";
        String requestParameter = request.getParameter("URL");

        String requestParameterAfterTransmission = transmission(requestParameter);
        URL context = new URL(  requestParameter );
        HttpURLConnection conn = (HttpURLConnection) context.openConnection();

        String safeStringAfterTransmission = transmission(safeString);
        URL context2 = new URL(  safeStringAfterTransmission );
        HttpURLConnection conn2 = (HttpURLConnection) context2.openConnection();

    }

    String transmission(String s){
        return s;
    }


}
