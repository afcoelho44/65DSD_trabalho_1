package udesc.dsd.Exception;

public class CodeGeneratingTimeoutException extends RuntimeException{
    public CodeGeneratingTimeoutException(){
        super("Error Generating the access key: Many attempts were made to generate a unique code.");
    }
}
