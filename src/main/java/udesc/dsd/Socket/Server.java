package udesc.dsd.Socket;

import udesc.dsd.Commons.Constants;
import udesc.dsd.Service.*;
import udesc.dsd.Utils.ProtocolTranslator;
import udesc.dsd.enums.DataIndexes;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final ServerSocket server;
    private Socket connection;
    private BufferedReader in;
    private PrintWriter out;

    public Server(ServerSocket server){
        this.server = server;
    }

    public void serve() throws IOException {

        this.server.setReuseAddress(true);
        String message;
        while (true) {
            try {
                System.out.println("Waiting request...");
                connection = server.accept();
                System.out.println("Requested");

                setIn();
                setOut();

                message = in.readLine();

                operate(ProtocolTranslator.translate(message));

            } catch (Exception e) {
                System.out.println("Error");
                if (connection != null) {
                    connection.close();
                    System.out.println("Socket closed.");
                }
                server.close();
                System.out.println("ServerSocket closed.");
                break;
            }
        }
    }

    private void operate(String[] data){
        String method = data[DataIndexes.METHOD.index];

        Service service = switch (method) {
            case Constants.INSERT -> new InsertPersonService(data, out);
            case Constants.UPDATE -> new UpdatePersonService(data, out);
            case Constants.DELETE -> new DeletePersonService(data, out);
            case Constants.GET -> new GetPersonService(data, out);
            case Constants.LIST -> new ListPersonService(data, out);

            default -> throw new RuntimeException("Method not found!");
        };

        service.execute();
    }

    private void setIn() throws IOException{
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    }

    private void setOut() throws IOException{
        out = new PrintWriter(connection.getOutputStream(), true);
    }
}
