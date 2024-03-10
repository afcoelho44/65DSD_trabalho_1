package udesc.dsd.Service;

import java.io.PrintWriter;

public class DeletePersonService extends Service{

    public DeletePersonService(String[] request, PrintWriter out) {
        super(request, out);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
