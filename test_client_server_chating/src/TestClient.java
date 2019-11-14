import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TestClient {
    private final static int SERVER_PORT = 8888;

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",SERVER_PORT);

        while (true) {
            // ожидаем подключения
            if (socket.isConnected()) {
                System.out.println("!we have connected to the server!");
            }

            // для подключившегося клиента открываем потоки
            // чтения и записи
            try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                 PrintWriter output = new PrintWriter(socket.getOutputStream())) {

                // ждем первой строки запроса
                while (!input.ready()) ;

                // считываем и печатаем все что было отправлено клиентом
                System.out.println();
                while (input.ready()) {
                    System.out.println(input.readLine());
                }

                // отправляем ответ
                output.println("HTTP/1.1 200 OK");
                output.println("Content-Type: text/html; charset=utf-8");
                output.println();
                output.println("<p>Привет всем!</p>");
                output.flush();

                // по окончанию выполнения блока try-with-resources потоки,
                // а вместе с ними и соединение будут закрыты
                System.out.println("Client disconnected!");
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}

