package ro.info.uaic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Locale;

public class Client {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 8080;
    private static final String STOP = "stop";

    public void run() {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, PORT);
            System.out.println("Welcome!\n Available commands:\n register <username>\n login <username> \n friend <name1> <name2> ... <nameK> \n send <message> \n read");
            String command = null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                try {
                    command = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String commandCopy = command;

                if(commandCopy != null) {
                    commandCopy = commandCopy.toLowerCase();
                    if(commandCopy.equals(STOP)) {
                        out.println("Server stopped");
                        break;
                    }
                }
                out.println(command);
                String response = in.readLine();
                System.out.println(response);
            }
            socket.close();
        } catch (IOException e) {
            System.err.println("[ERROR] IOException caught in client: " + e.getMessage());
        }
        finally {
            System.out.println("[INFO] Client has finished execution.");
        }
    }
}
