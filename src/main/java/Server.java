import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

//    private static Socket clientSocket; //сокет для общения
//    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try  {
                ServerSocket server = new ServerSocket(8081);
                System.out.println("Server started!");
                Socket clientSocket = server.accept();
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

//                    String word = in.readLine();

                    System.out.println("New connection accepted");

                    final String name = in.readLine();

                    System.out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                    out.flush(); // выталкиваем все из буфера

                } finally { // в любом случае сокет будет закрыт
                    clientSocket.close();
                    // потоки тоже хорошо бы закрыть
                    in.close();
                    out.close();
                    System.out.println("Сервер закрыт!");
                    server.close();
                }
            } finally {

            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }}