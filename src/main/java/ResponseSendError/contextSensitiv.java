package ResponseSendError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class contextSensitiv {
    HttpServletRequest request;
    HttpServletResponse response;

    void doGetOneLayer() throws IOException {
        String safeString = "parameter";
        String requestParameter = request.getParameter("URL");
//bad
        String requestParameterAfterTransmission = transmission(requestParameter);
        response.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameterAfterTransmission);
//good
        String safeStringAfterTransmission = transmission(safeString);
        response.sendError(HttpServletResponse.SC_NOT_FOUND, safeStringAfterTransmission);

    }

    String transmission(String s){
        return s;
    }
}
