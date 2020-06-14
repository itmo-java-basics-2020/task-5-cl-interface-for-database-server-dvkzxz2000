package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.logic.Database;

public class ReadKeyCommand implements DatabaseCommand {
    private String k;
    private String dataName;
    private String tableName;
    private ExecutionEnvironment executionEnvironment;

    public ReadKeyCommand(ExecutionEnvironment executionEnvironment, String dataName, String tableName, String k) {
        this.k = k;
        this.dataName = dataName;
        this.tableName = tableName;
        this.executionEnvironment = executionEnvironment;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Database data = executionEnvironment.getDatabase(dataName).orElseThrow();
        return DatabaseCommandResult.success(data.read(tableName, k));
    }
}