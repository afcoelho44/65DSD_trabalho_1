package udesc.dsd.Exception;

public class PersonNotFoundException extends ServerSideException{
    public PersonNotFoundException(){
        super("Pessoa não encontrada");
    }
}
