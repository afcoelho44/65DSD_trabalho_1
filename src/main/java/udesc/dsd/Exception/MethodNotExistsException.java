package udesc.dsd.Exception;

public class MethodNotExistsException extends ServerSideException{
    public MethodNotExistsException() {
        super("Metodo não existente!");
    }
}
