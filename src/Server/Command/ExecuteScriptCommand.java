package Server.Command;

import DATA.DataManager;

import java.io.IOException;
import java.util.ArrayList;

import static Client.Main.client;
import static Client.Main.server;

/**
 * The command responsible for reading commands from the file
 */
public class ExecuteScriptCommand extends Command {

    public ExecuteScriptCommand() {
    }

    public void execute(String fileName) throws IOException {
        System.out.println(fileName);
        if (scripts.size() == 0) {
            scripts.add(fileName);
            ArrayList<String> spisok = DataManager.LoadScript(fileName);
            for (String command : spisok) {
                server.checkCommand(command);
            }

        } else {
            if (fileName.equals(scripts.get(0))) {
                client.printLine("Зацикливание скриптов");
            } else {
                scripts.add(fileName);
                ArrayList<String> spisok = DataManager.LoadScript(fileName);
                for (String command : spisok) {
                    server.checkCommand(command);
                }
            }
        }

    }
}
