package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.CommandsEnum;
import seedu.address.logic.commands.AddTimeCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteTimeCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.ExportCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.FreeCommand;
import seedu.address.logic.commands.FriendCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.HistoryCommand;
import seedu.address.logic.commands.ImportCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.LoginCommand;
import seedu.address.logic.commands.LogoutCommand;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.RegisterCommand;
import seedu.address.logic.commands.SelectCommand;
import seedu.address.logic.commands.TagCommand;
import seedu.address.logic.commands.UiCommand;
import seedu.address.logic.commands.UndoCommand;
import seedu.address.logic.commands.UnfriendCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {
    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");
    private String commandWord;
    private String arguments;

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the CommandsEnum constants which represents a command
     * @throws ParseException if the user input does not conform the expected format
     */
    public CommandsEnum parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        commandWord = matcher.group("commandWord");
        arguments = matcher.group("arguments");

        //Returns the correct command enum constant
        CommandsEnum commandtype = CommandsEnum.find(commandWord);
        if (commandtype == null) {
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }

        return commandtype;
    }

    /**
     * Parses the arguments
     * @return the command to be executed
     * @throws ParseException when arguments are not valid
     */
    public Command parseCommandArguments() throws ParseException {

        switch (commandWord) {
        case RegisterCommand.COMMAND_WORD:
        case RegisterCommand.COMMAND_WORD_ALIAS:
            return new RegisterCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
        case EditCommand.COMMAND_WORD_ALIAS:
            return new EditCommandParser().parse(arguments);

        case SelectCommand.COMMAND_WORD:
        case SelectCommand.COMMAND_WORD_ALIAS:
            return new SelectCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
        case ClearCommand.COMMAND_WORD_ALIAS:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
        case FindCommand.COMMAND_WORD_ALIAS:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
        case ListCommand.COMMAND_WORD_ALIAS:
            return new ListCommand();

        case LogoutCommand.COMMAND_WORD:
        case LogoutCommand.COMMAND_WORD_ALIAS:
            return new LogoutCommand();

        case HistoryCommand.COMMAND_WORD:
        case HistoryCommand.COMMAND_WORD_ALIAS:
            return new HistoryCommand();

        case ExitCommand.COMMAND_WORD:
        case ExitCommand.COMMAND_WORD_ALIAS:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
        case HelpCommand.COMMAND_WORD_ALIAS:
            return new HelpCommand();

        case UndoCommand.COMMAND_WORD:
        case UndoCommand.COMMAND_WORD_ALIAS:
            return new UndoCommand();

        case RedoCommand.COMMAND_WORD:
        case RedoCommand.COMMAND_WORD_ALIAS:
            return new RedoCommand();

        case TagCommand.COMMAND_WORD:
        case TagCommand.COMMAND_WORD_ALIAS:
            return new TagCommandParser().parse(arguments);

        case FriendCommand.COMMAND_WORD:
        case FriendCommand.COMMAND_WORD_ALIAS:
            return new FriendCommandParser().parse(arguments);

        case UnfriendCommand.COMMAND_WORD:
        case UnfriendCommand.COMMAND_WORD_ALIAS:
            return new UnfriendCommandParser().parse(arguments);

        case ImportCommand.COMMAND_WORD:
        case ImportCommand.COMMAND_WORD_ALIAS:
            return new ImportCommandParser().parse(arguments);

        case ExportCommand.COMMAND_WORD:
        case ExportCommand.COMMAND_WORD_ALIAS:
            return new ExportCommandParser().parse(arguments);

        case AddTimeCommand.COMMAND_WORD:
        case AddTimeCommand.COMMAND_WORD_ALIAS:
            return new AddTimeCommandParser().parse(arguments);

        case DeleteTimeCommand.COMMAND_WORD:
        case DeleteTimeCommand.COMMAND_WORD_ALIAS:
            return new DeleteTimeCommandParser().parse(arguments);

        case FreeCommand.COMMAND_WORD:
        case FreeCommand.COMMAND_WORD_ALIAS:
            return new FreeCommandParser().parse(arguments);

        case LoginCommand.COMMAND_WORD:
        case LoginCommand.COMMAND_WORD_ALIAS:
            return new LoginCommandParser().parse(arguments);

        case UiCommand.COMMAND_WORD:
            return new UiCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
