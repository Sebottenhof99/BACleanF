package ResponseSendError;

import helper.A;
import helper.B;
import helper.C;
import helper.D;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class static_dynamic {
    HttpServletResponse response;

    //bad
    void doGetA() throws IOException {
        A a = new A();
        String reqParam  = a.getRequestParameter();
        response.sendError(HttpServletResponse.SC_NOT_FOUND, reqParam);
    }

    //good
    void doGetB() throws IOException {
        A a = new B();
        String reqParam  = a.getRequestParameter();
        response.sendError(HttpServletResponse.SC_NOT_FOUND, reqParam);
    }
    //bad
    void doGetC() throws IOException {
        A a = new C();
        String reqParam  = a.getRequestParameter();
        response.sendError(HttpServletResponse.SC_NOT_FOUND, reqParam);
    }
    //good
    void doGetD() throws IOException {
        A a = new D();
        String reqParam  = a.getRequestParameter();
        response.sendError(HttpServletResponse.SC_NOT_FOUND, reqParam);
    }

}
