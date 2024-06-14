package Server.Command;

import Entity.Person;

import java.util.Comparator;

import static Client.Main.client;
import static Server.Server.collectionHashSet;

/**
 * The command displays a sorted list of objects from the collection
 */
public class ShowCommand extends Command {

    public ShowCommand() {
    }

    public void execute(String id) {
        spisok = collectionHashSetgetCollection();
        spisok.sort(Comparator.comparing(Person::getId));
        for (Person person : spisok) {
            client.printLine("ID: " + person.getId() + " Name: " + person.getName() + " Height: " + person.getHeight() + " Weight: " + person.getWeight() + " Hair's color: " + person.getHairColor());
        }
    }
}
