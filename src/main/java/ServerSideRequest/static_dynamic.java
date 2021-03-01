package ServerSideRequest;

import helper.A;
import helper.B;
import helper.C;
import helper.D;
import org.apache.commons.httpclient.util.HttpURLConnection;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class static_dynamic {

    HttpServletResponse response;

    void doGetA() throws IOException {

        A a = new A();
        String reqParam  = a.getRequestParameter();
        URL staticDyn = new URL( reqParam );
        HttpURLConnection conn2 = (HttpURLConnection) staticDyn.openConnection();
    }


    void doGetB() throws IOException {
        A a = new B();
        String reqParam  = a.getRequestParameter();
        URL staticDyn = new URL( reqParam );
        HttpURLConnection conn2 = (HttpURLConnection) staticDyn.openConnection();
    }

    void doGetC() throws IOException {
        A a = new C();
        String reqParam  = a.getRequestParameter();
        URL staticDyn = new URL( reqParam );
        HttpURLConnection conn2 = (HttpURLConnection) staticDyn.openConnection();
    }

    void doGetD() throws IOException {
        A a = new D();
        String reqParam  = a.getRequestParameter();
        URL staticDyn = new URL( reqParam );
        HttpURLConnection conn2 = (HttpURLConnection) staticDyn.openConnection();
    }



}
