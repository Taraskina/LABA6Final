package Server.Command;

import DATA.DataManager;

import static Server.Server.collectionHashSet;
/**
 * The command that save collection to the file
 */


public class SaveCommand extends Command {

    public SavCommand() {
    }
    public void execute(String id){
        DataManager.Save(collectionHashSet.getHashsetCollection());
    }
}