package helper;

public class C extends B {

    public C(){
        this.requestParameter = request.getParameter("URL");
    }
    @Override
    public String getRequestParameter(){
        return  this.requestParameter;
    }
}
