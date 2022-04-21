import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8081);
            System.out.println("Server started!");
            Socket clientSocket = server.accept();
            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.println("New connection accepted");

                final String name = in.readLine();

                System.out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                out.flush();

            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}