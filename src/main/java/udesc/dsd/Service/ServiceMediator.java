package udesc.dsd.Service;

import udesc.dsd.Commons.Constants;
import udesc.dsd.Exception.MethodNotExistsException;
import udesc.dsd.Exception.TypeNotExistsException;

import java.io.PrintWriter;

import static udesc.dsd.Commons.Constants.DEPARTMENT_REQUEST;
import static udesc.dsd.Commons.Constants.PERSON_REQUEST;
import static udesc.dsd.enums.DataIndexes.CLASS;
import static udesc.dsd.enums.DataIndexes.METHOD;

public class ServiceMediator {

    private Service service;
    private String[] request;
    private PrintWriter out;

    public void setup(String[] request, PrintWriter out){
        this.out = out;
        this.request = request;
        setService();
    }

    private void setService(){
        String typeClass = request[CLASS.index];

        this.service = switch (typeClass){
            case DEPARTMENT_REQUEST -> new DepartmentService(request, out);
            case PERSON_REQUEST -> new PersonService(request, out);

            default -> throw new TypeNotExistsException();
        };
    }

    public void execute(){
        String method = request[METHOD.index];
        switch (method) {
            case Constants.INSERT -> service.insert();
            case Constants.UPDATE -> service.update();
            case Constants.DELETE -> service.delete();
            case Constants.GET -> service.get();
            case Constants.LIST -> service.list();

            default -> throw new MethodNotExistsException();
        }
    }
}
