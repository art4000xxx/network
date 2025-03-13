import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1"; // Используем 127.0.0.1
        int port = 8080;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Шаг 1: Читаем запрос имени и отправляем имя
            System.out.println("Server: " + in.readLine());
            String name = "Alex";
            out.println(name);
            System.out.println("Sent name: " + name);

            // Шаг 2: Читаем вопрос про возраст и отправляем ответ
            System.out.println("Server: " + in.readLine());
            String childResponse = "yes";
            out.println(childResponse);
            System.out.println("Sent response: " + childResponse);

            // Шаг 3: Читаем финальный ответ сервера
            System.out.println("Server: " + in.readLine());

        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}