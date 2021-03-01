package helper;

public class B extends  A{

    public B(){
        this.requestParameter = "safe";
    }
     @Override
    public String getRequestParameter(){
        return  this.requestParameter;
    }
}
