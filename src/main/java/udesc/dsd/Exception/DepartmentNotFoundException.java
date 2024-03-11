package udesc.dsd.Exception;

public class DepartmentNotFoundException extends ServerSideException{

    public DepartmentNotFoundException(){
        super("Departmento não encontrado");
    }
}
