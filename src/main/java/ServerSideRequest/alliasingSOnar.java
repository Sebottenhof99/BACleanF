package ServerSideRequest;

import helper.A;
import org.apache.commons.httpclient.util.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class alliasingSOnar {

    HttpServletRequest request;
    HttpServletResponse response;

    //good
    void alliaseSimple() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = request.getParameter("URL");
        a2.requestParameter = "param";

        a2 = a1;
        String urlWhiteListed = "https://example.com/";

        if(a2.requestParameter.startsWith(urlWhiteListed)){
            URL url2 = new URL(  a2.requestParameter );
            HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
        }

    }

    //Abbildung 32//good
    void alliase2() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        a1.a = a2;
        A a3 = a1.a;
        String urlWhiteListed = "https://example.com/";

        if(a3.requestParameter.startsWith(urlWhiteListed)){
            URL url2 = new URL(  a3.requestParameter );
            HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
        }
    }
    //Abbildung 33 //good
    void alliase3() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        A a3 = a1;
        a3.a = a2;
        A a4 = a3.a;
        String urlWhiteListed = "https://example.com/";

        if(a4.requestParameter.startsWith(urlWhiteListed)){
            URL url2 = new URL(  a4.requestParameter );
            HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
        }


    }

    //Abbildung 34 //good
    void alliase4() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        A a3 = a1;
        a3.a = a2;
        A a4 = a1.a;
        String urlWhiteListed = "https://example.com/";
        if(a4.requestParameter.startsWith(urlWhiteListed)){
            URL url2 = new URL(  a4.requestParameter );
            HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
        }

    }

    //Abbildung 35 //good
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

        String urlWhiteListed = "https://example.com/";
        if(a5.requestParameter.startsWith(urlWhiteListed)){
            URL url2 = new URL(  a5.requestParameter );
            HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
        }


    }

    //Abbildung 36 //good
    void alliase6() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        A a3 = a1;
        A a4 = a1;
        a3.a = a2;
        A a5 = a4.a;

        String urlWhiteListed = "https://example.com/";
        if(a5.requestParameter.startsWith(urlWhiteListed)){
            URL url2 = new URL(  a5.requestParameter );
            HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
        }

    }


}
