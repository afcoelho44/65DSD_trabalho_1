package udesc.dsd.Service;

import java.io.PrintWriter;

public class GetPersonService extends Service{

    public GetPersonService(String[] request, PrintWriter out) {
        super(request, out);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
