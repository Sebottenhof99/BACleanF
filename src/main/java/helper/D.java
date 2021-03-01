package helper;

public class D extends C{

    public D(){
        this.requestParameter ="safe";
    }
    @Override
    public String getRequestParameter(){
        return  this.requestParameter;
    }


}
