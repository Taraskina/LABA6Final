package Server.Command;

import static Client.Main.client;

/**
 * A command that stores a stack of 13 recent commands
 */

public class HistoryCommand extends Command {
    public HistoryCommand() {
    }

    public void addCommand(String command) {
        if (listHistory.size() >= 8) {
            listHistory.remove(0);
            listHistory.add(command);
        } else {
            listHistory.add(command);
        }
    }
    public void execute(String id) {
        for (String command : listHistory) {
            client.printLine(command);
        }
    }
}
