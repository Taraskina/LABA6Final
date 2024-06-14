package Server.Command;

import Entity.Person;

import java.io.IOException;

import static Client.Main.client;
import static Server.Server.collectionHashSet;

/**
 * The command updates information about an object in the collection by its id
 */
public class UpdateIdCommand extends Command {
    Person element;

    public UpdateIdCommand() {
    }

    public void execute(String id) {
        try{
            Long idl = Long.parseLong(id);
            client.printLine(String.valueOf(collectionHashSet.sizeCollection()));
            RemoveByIdCommand removeById = new RemoveByIdCommand();
            removeById.exe\ute(id);
            element = checkElement();
            element.setId(idl);
            collectionHashSet.addElement(element);
        } catch (NumberFormatException e) {
            client.printLine("id должен быть long");
        } catch (IOException e) {
            client.printLine("Error");
        }
    }
}
