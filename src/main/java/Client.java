import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {

            Socket clientSocket = new Socket("localhost", 8081);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            System.out.println("client start");
            String word = reader.readLine();
            out.write(word + "\n");
            out.flush();
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}