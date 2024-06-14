package Server;

import Collection.CollectionHashSet;
import Server.Command.Command;
import Server.Command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The class in which commands are processed and invoked
 */
public class Server {
    Map<String, Command> map = new HashMap<>();
    HistoryCommand history = new HistoryCommand();
    public static CollectionHashSet collectionHashSet = new CollectionHashSet("collection");

    public Server() {
        map.put("help", new HelpCommand());
        map.put("info", new InfoCommand());
        map.put("show", new ShowCommand());
        map.put("save", new SaveCommand());
        map.put("clear", new ClearCommand());
        map.put("exit", new ExitCommand());
        map.put("history", history);
        map.put("sum_of_weight", new SumOfWeight());
        map.put("max_by_name", new MaxByNameCommand());
        map.put("print_field_descending_hair_color", new PrintFieldDescendingHairColor());
        map.put("add", new AddCommand());
        map.put("update", new UpdateIdCommand());
        map.put("remove_by_id", new RemoveByIdCommand());
        map.put("execute_script", new ExecuteScriptCommand());
    }

    public void checkCommand(String reader) throws IOException {
        try {
            String id = "0";
            String command;
            String[] read;
            read = reader.split("\\s+");
            if (read.length > 1) {
                command = read[0];
                id = read[1];
            } else {
                command = read[0];
            }
            if (map.containsKey(command)) {
                map.get(command).execute(id);
                history.addCommand(command);
            } else {
                System.out.println("Введите help");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {

    }


}

