package udesc.dsd.Exception;

public class TypeNotExistsException extends ServerSideException{
    public TypeNotExistsException() {
        super("Tipo não existente!");
    }
}
