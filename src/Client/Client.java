package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Client.Main.server;

/**
 * This class takes a line from the command line and passes it to the server
 */

public class Client {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Client() {
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    public void printLine(String massage) {
        System.out.println(massage);
    }

    public void start() {
        while (true) {
            try {
                System.out.println("Введите команду: ");
                String read = reader.readLine();
                if (read == null) {
                    System.out.println("Неверный ввод");
                } else {
                    if (read.trim().isEmpty()) {
                        System.out.println("Неверный ввод");
                    } else {
                        server.checkCommand(read);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
