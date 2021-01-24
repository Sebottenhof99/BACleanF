package ResponseSendError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ValidateTesten {

    HttpServletRequest request;
    HttpServletResponse response;

    void sendErrror() throws IOException {

        String doNotfindIt = request.getParameter("beliebiger Parameter");
        validate(doNotfindIt);
        response.sendError(HttpServletResponse.SC_NOT_FOUND, doNotfindIt);


        String doNotfindIt2 = request.getParameter("par");
        validate2(doNotfindIt2);
        response.sendError(HttpServletResponse.SC_NOT_FOUND, doNotfindIt2);


        String doNotfindIt3 = request.getParameter("par");
        if(validate3(doNotfindIt3)){
            response.sendError(HttpServletResponse.SC_NOT_FOUND, doNotfindIt3);
        }


        String doNotfindIt4 = request.getParameter("par");
        if(validate4(doNotfindIt4)){
            response.sendError(HttpServletResponse.SC_NOT_FOUND, doNotfindIt4);
        }
        

    }

    void validate(String s ){
        String tamplete = "abc";
        s.contains(tamplete);

    }

    void validate2(String s ){
        String tamplete = "abc";
        s.charAt(0);


    }
    boolean validate3(String s){
        if(s.contains(s)){
            return true;
        }

        return false;
    }

    boolean validate4(String s){
        String tamplete = "abc";
        if(s.startsWith(tamplete)){
            return true;
        }

        return false;
    }


    boolean validateOnlyTrue(String s ) {
        return true;
    }


}
