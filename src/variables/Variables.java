package variables;

import java.awt.*;

public class Variables {
    private Dimension size_window;
    private String operation;
    private String operation2;

    public Variables(){
        setSize_window(new Dimension(600, 800));
    }

    public Variables(String operation){
        setOperation(operation);
    }
    public Dimension getSize_window() {
        return size_window;
    }

    public void setSize_window(Dimension window) {
        this.size_window = window;
    }

    public String getOperation(){
        return operation;
    }

    public void setOperation(String operation){
        this.operation = operation;

    }

    public String getOperation2(){
        return operation2;
    }

    public void setOperation2(String operation){
        this.operation2 = operation;
    }
}
