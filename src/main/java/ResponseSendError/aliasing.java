package ResponseSendError;

import helper.A;
import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class aliasing {
    HttpServletRequest request;
    HttpServletResponse response;

    //bad
    void alliaseSimple() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = request.getParameter("URL");
        a2.requestParameter = "param";

        a2 = a1;
        response.sendError(HttpServletResponse.SC_NOT_FOUND, a2.requestParameter);
    }

    //Abbildung 32 //bad
    void alliase2() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        a1.a = a2;
        A a3 = a1.a;
        response.sendError(HttpServletResponse.SC_NOT_FOUND, a3.requestParameter);


    }
    //Abbildung 33 //bad
    void alliase3() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        A a3 = a1;
        a3.a = a2;
        A a4 = a3.a;
        response.sendError(HttpServletResponse.SC_NOT_FOUND, a4.requestParameter);

    }

    //Abbildung 34 //bad
    void alliase4() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        A a3 = a1;
        a3.a = a2;
        A a4 = a1.a;
        response.sendError(HttpServletResponse.SC_NOT_FOUND, a4.requestParameter);

    }

    //Abbildung 35 //bad
    void alliase5() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        A a3 = a1;
        A a4 = a1;
        a3.a = a2;
        a4.a = a2;

        A a5 = a4.a;
        response.sendError(HttpServletResponse.SC_NOT_FOUND, a5.requestParameter);

    }

    //Abbildung 36 //bad
    void alliase6() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        A a3 = a1;
        A a4 = a1;
        a3.a = a2;
        A a5 = a4.a;


        response.sendError(HttpServletResponse.SC_NOT_FOUND, a5.requestParameter);

    }
    //good
    void alliaseSimpleSafe() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = request.getParameter("URL");
        a2.requestParameter = "param";

        a2 = a1;
        response.sendError(HttpServletResponse.SC_NOT_FOUND, StringEscapeUtils.escapeEcmaScript(a2.requestParameter));
    }

    //Abbildung 32 //good
    void alliase2Safe() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        a1.a = a2;
        A a3 = a1.a;
        response.sendError(HttpServletResponse.SC_NOT_FOUND, StringEscapeUtils.escapeEcmaScript(a3.requestParameter));


    }
    //Abbildung 33 //good
    void alliase3Safe() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        A a3 = a1;
        a3.a = a2;
        A a4 = a3.a;
        response.sendError(HttpServletResponse.SC_NOT_FOUND, StringEscapeUtils.escapeEcmaScript(a4.requestParameter));

    }

    //Abbildung 34 //good
    void alliase4Safe() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        A a3 = a1;
        a3.a = a2;
        A a4 = a1.a;
        response.sendError(HttpServletResponse.SC_NOT_FOUND, StringEscapeUtils.escapeEcmaScript(a4.requestParameter));

    }

    //Abbildung 35 //good
    void alliase5Safe() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        A a3 = a1;
        A a4 = a1;
        a3.a = a2;
        a4.a = a2;

        A a5 = a4.a;
        response.sendError(HttpServletResponse.SC_NOT_FOUND, StringEscapeUtils.escapeEcmaScript(a5.requestParameter));

    }

    //Abbildung 36 //good
    void alliase6Safe() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        A a3 = a1;
        A a4 = a1;
        a3.a = a2;
        A a5 = a4.a;


        response.sendError(HttpServletResponse.SC_NOT_FOUND, StringEscapeUtils.escapeEcmaScript(a5.requestParameter));

    }


}
