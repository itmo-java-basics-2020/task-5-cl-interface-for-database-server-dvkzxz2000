package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.logic.Database;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.console.DatabaseCommandResult;

public class CreateTableCommand implements DatabaseCommand {

    private String tableName;

    private String dataName;

    private ExecutionEnvironment executionEnvironment;

    public CreateTableCommand(ExecutionEnvironment executionEnvironment, String dataName, String tableName) {
        this.dataName = dataName;
        this.tableName = tableName;
        this.executionEnvironment = executionEnvironment;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Database data = executionEnvironment.getDatabase(dataName).orElseThrow();
        data.createTableIfNotExists(tableName);
        return DatabaseCommandResult.success();
    }
}