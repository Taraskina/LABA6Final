package Client;

import Server.Server;

import java.io.IOException;


public class Main {
    public static Client client = new Client();
    public static Server server = new Server();

    public static void main(String[] args) throws IOException {
        server.start();
        client.start();
    }
}