package duke.parser;

import duke.commands.AddCommand;
import duke.commands.Command;
import duke.commands.DeleteCommand;
import duke.commands.DoneCommand;
import duke.commands.ExitCommand;
import duke.commands.FindCommand;
import duke.commands.ListCommand;
import duke.enums.ErrorCodes;
import duke.enums.TaskTypes;
import duke.exceptions.DukeException;

/**
 * Class with methods to parse user input and responds accordingly.
 *
 * @author Firzan Armani
 */
public class Parser {
    /**
     * Parses the full command input from the user and returns the appropriate command to be execute by caller.
     *
     * @param fullCommand String of the full command input by the user.
     * @return A Command object based on the type of command parsed.
     * @throws DukeException DukeException thrown if missing task information or unknown commands.
     */
    public static Command parse(String fullCommand) throws DukeException {
        Command command = null;
        switch (fullCommand) {
        case "list":
            command = new ListCommand();
            break;
        case "bye":
            command = new ExitCommand();
            break;
        default:
            String[] splitString = fullCommand.split(" ", 2);
            if (splitString.length != 2) {
                throw new DukeException(ErrorCodes.MISSING_TASK_NAME);
            }
            String userCommand = splitString[0];
            String userArgs = splitString[1];
            int taskNo = -1;

            switch (userCommand) {
            case "find":
                command = new FindCommand(userArgs);
                break;
            case "done":
                taskNo = Integer.parseInt(userArgs) - 1;
                command = new DoneCommand(taskNo);
                break;
            case "delete":
                taskNo = Integer.parseInt(userArgs) - 1;
                command = new DeleteCommand(taskNo);
                break;
            case "deadline":
                command = new AddCommand(TaskTypes.DEADLINE, userArgs);
                break;
            case "todo":
                command = new AddCommand(TaskTypes.TODO, userArgs);
                break;
            case "event":
                command = new AddCommand(TaskTypes.EVENT, userArgs);
                break;
            default:
                throw new DukeException(ErrorCodes.UNKNOWN_COMMAND);
            };
        }
        return command;
    }
}