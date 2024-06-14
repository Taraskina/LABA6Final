package Server.Command;

import Entity.ComparePeople;
import Entity.Person;

import java.util.Comparator;

import static Client.Main.client;
import static Server.Server.collectionHashSet;

/**
 * The command outputs an object with the maximum name
 */
public class MaxByNameCommand extends Command {
    public MaxByNameCommand() {
    }

    public void execute(String id) {
        spisok = collectionHashSet.getCollection();
        if (spisok.size() < 1) {
            client.printLine("Collection is empty");
        } else {
            Comparator compareName = new ComparePeople();
            spisok.sort(compareName);
            for (Person person : spisok) {
                client.printLine("ID: " + person.getId() + " Name: " + person.getName() + " Height: " + person.getHeight() + " Weight: " + person.getWeight() + " Hair's color: " + person.getHairColor());
            }
            Person personMaxName = spisok.get(spisok.size() - 1);
            client.printLine("ID: " + personMaxName.getId() + " Name: " + personMaxName.getName() + " Height: " + personMaxName.getHeight() + " Weight: " + personMaxName.getWeight() + " Hair's color: " + personMaxName.getHairColor());
        }
    }
}
