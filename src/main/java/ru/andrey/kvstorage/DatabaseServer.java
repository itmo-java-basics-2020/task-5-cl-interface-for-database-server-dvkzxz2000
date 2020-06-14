package ru.andrey.kvstorage;

import java.util.Arrays;
import java.util.NoSuchElementException;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.console.DatabaseCommandResult;

public class DatabaseServer {

    public static void main(String[] args) {
    }

    private final ExecutionEnvironment executionEnvironment;

    public DatabaseServer(ExecutionEnvironment executionEnvironment) {
        this.executionEnvironment = executionEnvironment;
    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        if (commandText == null) {
            return DatabaseCommandResult.failed("Write smth! It is important!");
        }
        String[] splitCommand = "\\s+".split(commandText);

        DatabaseCommands databaseCommand;
        try {
            databaseCommand = DatabaseCommands.valueOf(splitCommand[0]);
            String[] strings = new String[0];
            if (splitCommand.length > 1) {
                strings = Arrays.copyOfRange(splitCommand, 1, splitCommand.length);
            }
            return databaseCommand.getCommand(executionEnvironment, strings).execute();
        } catch (DatabaseException | IllegalArgumentException | NoSuchElementException e) {
            return DatabaseCommandResult.failed(e.getMessage());
        }
    }
}