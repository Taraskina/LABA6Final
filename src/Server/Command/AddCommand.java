package Server.Command;

import Entity.Person;

import java.io.IOException;

import static Client.Main.client;
import static Server.Server.collectionHashSet;

/**
 * The command responsible for adding an object of the Person class to the collection
 */
public class AddCommand extends Command{
    Person element;

    public AddCommnd() {

    }

    public void execute(String id) throws IOException {
        element = checkElement();
        collectionHashSet.addElement(element);
        client.printLine("Person добавлен");
    }

}
