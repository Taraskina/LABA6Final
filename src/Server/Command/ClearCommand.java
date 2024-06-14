package Server.Command;

import java.io.IOException;

import static Client.Main.client;
import static Server.Server.collectionHashSet;

public class ClearCommand extends Command {
    public ClearCommand() {

    }

    @Override
    public void execute(String id) throws IOException {
        collectionashSet.clearCollection();
        client.printLine("Collection is clear");
    }}
