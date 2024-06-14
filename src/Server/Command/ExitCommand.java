package Server.Command;

/**
 * This command is used to exit the console application
 */
public class ExitCommand extends Command {


    public Exitommand() {
    }

    public void execute(String id) {
        System.exit(52);
    }
}
