package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.logic.Database;

public class UpdateKeyCommand implements DatabaseCommand {
    private String k;
    private String v;
    private String dataName;
    private String tableName;
    private ExecutionEnvironment executionEnvironment;

    public UpdateKeyCommand(ExecutionEnvironment executionEnvironment, String dataName, String tableName, String k, String v) {
        this.k = k;
        this.v = v;
        this.dataName = dataName;
        this.tableName = tableName;
        this.executionEnvironment = executionEnvironment;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Database data = executionEnvironment.getDatabase(dataName).orElseThrow();
        data.write(tableName, k, v);
        return DatabaseCommandResult.success();
    }
}