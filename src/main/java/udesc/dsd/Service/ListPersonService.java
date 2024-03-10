package udesc.dsd.Service;

import java.io.PrintWriter;

public class ListPersonService extends Service {
    public ListPersonService(String[] request, PrintWriter out) {
        super(request, out);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
