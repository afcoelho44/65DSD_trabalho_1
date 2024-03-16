package udesc.dsd.Socket;

import udesc.dsd.Exception.ServerSideException;
import udesc.dsd.Service.*;
import udesc.dsd.Utils.ProtocolTranslator;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static udesc.dsd.Commons.Colors.BLUE;
import static udesc.dsd.Commons.Colors.RED;

public class Server {

    private final ServerSocket server;
    private Socket connection;
    private BufferedReader in;
    private PrintWriter out;
    private final ServiceMediator mediator;

    public Server(ServerSocket server){
        this.server = server;
        this.mediator = new ServiceMediator();
    }

    public void serve() throws IOException {
        this.server.setReuseAddress(true);
        String message;
        while (true) {
            try {
                System.out.println(BLUE + "Ready <-");
                connection = server.accept();
                System.out.println(BLUE + "Requested");

                setIn();
                setOut();

                message = in.readLine();
                String[] request = ProtocolTranslator.translateRequest(message);
                mediator.setup(request, out);
                mediator.execute();

                connection.close();
                System.out.println(BLUE + "Socket closed.");
            } catch (ServerSideException e) {
                String errorMessage = e.getMessage();

                System.out.println(errorMessage);
                out.println(errorMessage);

                if (connection != null) {
                    connection.close();
                    System.out.println("Socket closed.");
                }
            } catch (Exception e){
                out.println("Server closed!");
                server.close();
                System.out.println(RED + "The server stopped abruptly due an error");
                break;
            }
        }
    }

    private void setIn() throws IOException{
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    }

    private void setOut() throws IOException{
        out = new PrintWriter(connection.getOutputStream(), true);
    }
}
