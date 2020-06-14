package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.logic.Database;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.console.DatabaseCommandResult;

public class CreateDatabaseCommand implements DatabaseCommand {

    private String dataName;

    private ExecutionEnvironment executionEnvironment;

    public CreateDatabaseCommand(ExecutionEnvironment environment, String name) {
        this.dataName = name;
        this.executionEnvironment = environment;
    }

    @Override
    public DatabaseCommandResult execute() {
        executionEnvironment.addDatabase(new Database() {

            @Override
            public String getName() {
                return dataName;
            }

            @Override
            public void createTableIfNotExists(String tableName) {

            }

            @Override
            public String read(String tableName, String objectKey) {
                return null;
            }

            @Override
            public void createTableIfNotExists(String tableName, int segmentSizeInBytes) {

            }

            @Override
            public void write(String tableName, String objectKey, String objectValue)  {

            }
        });
        return DatabaseCommandResult.success();
    }
}