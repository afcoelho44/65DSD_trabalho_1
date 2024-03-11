package udesc.dsd.Service;

import java.io.PrintWriter;
import java.net.Socket;

public abstract class Service {

    protected String[] request;
    protected PrintWriter out;

    public Service(String[] request, PrintWriter out){
        this.request = request;
        this.out = out;
    }

    public abstract void insert();
    public abstract void update();
    public abstract void delete();
    public abstract void get();
    public abstract void list();
}
