package udesc.dsd.Exception;

public class NotAnyDepartmentException extends ServerSideException{
    public NotAnyDepartmentException() {
        super("Nenhum departamento cadastrado");
    }
}
