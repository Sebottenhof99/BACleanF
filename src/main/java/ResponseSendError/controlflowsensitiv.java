package ResponseSendError;

import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class controlflowsensitiv {
  HttpServletRequest request;
  HttpServletResponse response;
//GOOD
  void  doGet() throws IOException {
    String requestParameter = request.getParameter("parameter");
    requestParameter = StringEscapeUtils.escapeEcmaScript(requestParameter);
    response.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameter);
  }
  //GOOD
  void  doGet2() throws IOException {
    String requestParameter = request.getParameter("parameter");
    requestParameter = StringEscapeUtils.escapeEcmaScript(requestParameter);
    requestParameter = request.getParameter("parameter");
    requestParameter = StringEscapeUtils.escapeEcmaScript(requestParameter);
    response.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameter);
  }
  //GOOD
  void  doGet3() throws IOException {
    String requestParameter = request.getParameter("parameter");
    requestParameter = StringEscapeUtils.escapeEcmaScript(requestParameter);
    requestParameter = request.getParameter("parameter");
    requestParameter = StringEscapeUtils.escapeEcmaScript(requestParameter);
    requestParameter = request.getParameter("parameter");
    requestParameter = StringEscapeUtils.escapeEcmaScript(requestParameter);
    response.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameter);
  }



  void  doGet31() throws IOException {
    String requestParameter = "safeString";
    requestParameter = request.getParameter("parameter");
    response.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameter);


  }

  void  doGet32() throws IOException {
    String requestParameter = "safeString";
    requestParameter = request.getParameter("parameter");
    requestParameter = "safeString";
    requestParameter = request.getParameter("parameter");
    response.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameter);


  }

  void  doGet33() throws IOException {
    String requestParameter = "safeString";
    requestParameter = request.getParameter("parameter");
    requestParameter = "safeString";
    requestParameter = request.getParameter("parameter");
    requestParameter = "safeString";
    requestParameter = request.getParameter("parameter");
    response.sendError(HttpServletResponse.SC_NOT_FOUND, requestParameter);


  }


}
