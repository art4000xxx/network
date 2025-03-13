import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("New connection accepted from port: " + clientSocket.getPort());

                    // Шаг 1: Запрашиваем имя
                    out.println("Write your name");
                    String name = in.readLine();
                    System.out.println("Client name: " + name);

                    // Шаг 2: Спрашиваем, ребёнок ли клиент
                    out.println("Are you a child? (yes/no)");
                    String childResponse = in.readLine().trim().toLowerCase();
                    System.out.println("Client response: " + childResponse);

                    // Шаг 3: Отвечаем в зависимости от ответа
                    if (childResponse.equals("yes")) {
                        out.println("Welcome to the kids area, " + name + "! Let's play!");
                    } else if (childResponse.equals("no")) {
                        out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                    } else {
                        out.println("Sorry, " + name + ", I didn't understand your answer. Bye!");
                    }

                } catch (Exception e) {
                    System.out.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}