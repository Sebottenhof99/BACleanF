package ServerSideRequest;

import helper.A;
import org.apache.commons.httpclient.util.HttpURLConnection;

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
        URL alliase = new URL(  a2.requestParameter );
        HttpURLConnection conn2 = (HttpURLConnection) alliase.openConnection();
    }

//Abbildung 32 //bad
    void alliase2() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        a1.a = a2;
        A a3 = a1.a;
        URL alliase = new URL(  a3.requestParameter );
        HttpURLConnection conn2 = (HttpURLConnection) alliase.openConnection();
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
        URL alliase = new URL(  a4.requestParameter );
        HttpURLConnection conn2 = (HttpURLConnection) alliase.openConnection();
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
        URL alliase = new URL(  a4.requestParameter );
        HttpURLConnection conn2 = (HttpURLConnection) alliase.openConnection();
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
        URL alliase = new URL(  a5.requestParameter );
        HttpURLConnection conn2 = (HttpURLConnection) alliase.openConnection();
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


        URL alliase = new URL(  a5.requestParameter );
        HttpURLConnection conn2 = (HttpURLConnection) alliase.openConnection();
    }


    void alliaseSimpleSafe() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = request.getParameter("URL");
        a2.requestParameter = "param";

        a2 = a1;
        if(validate(a2.requestParameter)){
            URL alliase = new URL(  a2.requestParameter );
            HttpURLConnection conn2 = (HttpURLConnection) alliase.openConnection();
        }

    }

    //Abbildung 32
    void alliase2Safe() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        a1.a = a2;
        A a3 = a1.a;
        if(validate(a3.requestParameter)){
            URL alliase = new URL(  a2.requestParameter );
            HttpURLConnection conn2 = (HttpURLConnection) alliase.openConnection();
        }
    }
    //Abbildung 33
    void alliase3Safe() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        A a3 = a1;
        a3.a = a2;
        A a4 = a3.a;
        if(validate(a4.requestParameter)){
            URL alliase = new URL(  a4.requestParameter );
            HttpURLConnection conn2 = (HttpURLConnection) alliase.openConnection();
        }


    }

    //Abbildung 34 SonarNOTFOUND
    void alliase4Safe() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        A a3 = a1;
        a3.a = a2;
        A a4 = a1.a;
        if(validate(a4.requestParameter)){
            URL alliase = new URL(  a4.requestParameter );
            HttpURLConnection conn2 = (HttpURLConnection) alliase.openConnection();
        }

    }

    //Abbildung 35
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

        if(validate(a5.requestParameter)){
            URL alliase = new URL(  a5.requestParameter );
            HttpURLConnection conn2 = (HttpURLConnection) alliase.openConnection();
        }


    }

    //Abbildung 36
    void alliase6Safe() throws IOException {
        A a1 = new A();
        A a2 = new A();
        a1.requestParameter = "param";
        a2.requestParameter = request.getParameter("URL");

        A a3 = a1;
        A a4 = a1;
        a3.a = a2;
        A a5 = a4.a;


        if(validate(a5.requestParameter)){
            URL alliase = new URL(  a5.requestParameter );
            HttpURLConnection conn2 = (HttpURLConnection) alliase.openConnection();
        }

    }

    boolean validate(String s) throws IOException {
        String urlWhiteListed = "https://example.com/";

        return s.startsWith(urlWhiteListed);
    }

}
