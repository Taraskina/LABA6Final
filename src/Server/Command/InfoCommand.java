package Server.Command;

import static Client.Main.client;
import static Server.Server.collectionHashSet;

/**
 * The command that provides information about the collection
 */
public class InfoCommand extends Command {

    public InfoComand() {
    }

    public void execute(String id) {
        client.printLine("Имя коллекции: " + collectionHashSet.getName() + "\n" +
                "Тип коллекции: Person\n" +
                "Время инициализации: " + collectionHashSet.getTimeInicilization() + "\n" +
                "Колличество элементов: " + collectionHashSet.sizeCollection());
    }
}