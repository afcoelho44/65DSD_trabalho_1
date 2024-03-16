package udesc.dsd;

import udesc.dsd.Dao.DepartmentDao;
import udesc.dsd.Dao.PersonDao;
import udesc.dsd.Socket.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

import static udesc.dsd.Commons.Colors.GREEN;
import static udesc.dsd.Commons.Colors.YELLOW;

public class App {
    public static void main(String[] args) throws IOException {
        populate();
        run();
    }

    private static void run() throws IOException {
        System.out.println(GREEN + "Server starting...");
        while (isRunning){
            Server server = new Server(new ServerSocket(65000));
            server.serve();
            continueRunning();
        }
    }

    private static void continueRunning(){
        String answer = "";
        while (!answer.equals("y")){
            System.out.println(YELLOW + "Want to restart server? [y/n]");
            Scanner s = new Scanner(System.in);
            answer = s.next();
            if (answer.equals("n")) {
                isRunning = false;
                break;
            }
            System.out.println(GREEN + "Server restarting...");
        }
        System.out.println(YELLOW + "Shutting down");
    }

    private static void populate(){
        DepartmentDao.populate();
        PersonDao.populate();
    }
    private static boolean isRunning = true;
}
