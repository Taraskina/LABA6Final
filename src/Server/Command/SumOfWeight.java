package Server.Command;


import Entity.Person;

import static Client.Main.client;
import static Server.Server.collectionHashSet;

/**
 * The command outputs the sum of the masses of all objects in the collection
 */
public class SumOfWeight extends Command {
    public SumOfWeight() {
    }

    public void execute(String id) {
        spisok = collectionHashSet.getCollection();
        int sum = 0;
        for (Person person : spisok) {
            sum += person.getWeight();
        }
        client.printLine(String.valueOf(sum));
    }
}
