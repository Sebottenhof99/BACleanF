package helper;

import javax.servlet.http.HttpServletRequest;

public class A {

    public String requestParameter;
    public A a;
    protected   HttpServletRequest request;

    public A(){
        this.requestParameter = request.getParameter("URL");
    }

    public String getRequestParameter(){
       return  this.requestParameter;
    }

}
