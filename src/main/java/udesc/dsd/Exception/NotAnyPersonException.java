package udesc.dsd.Exception;

public class NotAnyPersonException extends ServerSideException{
    public NotAnyPersonException() {
        super("Nenhuma pessoa cadastrada");
    }
}
