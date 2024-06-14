package Server.Command;

import Entity.Person;

import static Client.Main.client;
import static Server.Server.collectionHashSet;

/**
 * The command deletes an object from the collection by id
 */
public class RemoveByIdCommand extends Command {

    public RemoveByIdCommand() {

    }
    public void execute(String id) {
        try{
            Long idl = Long.parseLong(id);
            spisok = collectionHashSet.geCollection();
            int flag = 0;
            for (Person person : spisok) {
                if (person.getId() == idl) {
                    collectionHashSet.removeElement(person);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                client.printLine("Person with this id isn't found");
            }
        } catch (NumberFormatException e) {
            client.printLine("id должна быть long");
        }
    }
}
