package Server.Command;
import Entity.Person;

import static Client.Main.client;
import static Server.Server.collectionHashSet;

/**
 * The command outputs the hair colors of all items stored in the collection
 */

public class PrintFieldDescendingHairColor extends Command {

    public PrintFieldDescendingHairColor() {
    }
    public void execute(String id) {
        spisok = collectionHashSet.getCollection();
        if (spisok.size() < 1){
            client.printLine("Collection is empty");
        }else {
            for (Person person : spisok) {
                client.printLine(person.getHairlor().toString());
            }
        }
    }
}
