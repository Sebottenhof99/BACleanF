package ResponseSendError;

import helper.A;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class fieldsensitiv {

    HttpServletRequest request;
    HttpServletResponse response;

//bad
    void doGetSimple() throws IOException {
        A a = new A();
        a.requestParameter = request.getParameter("url");
        response.sendError(HttpServletResponse.SC_NOT_FOUND, a.requestParameter);
    }
    //bad
    void doGetTwoInstanzes() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a2.requestParameter = "safeString";
        a1.requestParameter = request.getParameter("url");
        response.sendError(HttpServletResponse.SC_NOT_FOUND, a1.requestParameter);
    }
//Good
    void doGetTwoInstanzesSafe() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a2.requestParameter = "safeString";
        a1.requestParameter = request.getParameter("url");
        response.sendError(HttpServletResponse.SC_NOT_FOUND, a2.requestParameter);
    }
    //bad
    void doGetTwoInstanzesDesinfect() throws IOException {
        A a1 = new A();
        A a2 = new A();

        a1.requestParameter = request.getParameter("url");
        a2.requestParameter = StringEscapeUtils.escapeEcmaScript("reqParam");
        response.sendError(HttpServletResponse.SC_NOT_FOUND, a1.requestParameter);
    }

}
