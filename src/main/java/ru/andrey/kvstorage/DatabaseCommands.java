package ru.andrey.kvstorage;

import ru.andrey.kvstorage.commands.CreateDatabaseCommand;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.commands.CreateTableCommand;
import ru.andrey.kvstorage.commands.UpdateKeyCommand;
import ru.andrey.kvstorage.commands.ReadKeyCommand;
import ru.andrey.kvstorage.console.DatabaseCommand;

public enum DatabaseCommands {
    CREATE_TABLE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            checkArgsLength(2, args);
            return new CreateTableCommand(env, args[0], args[1]);
        }
    },
    CREATE_DATABASE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            checkArgsLength(1, args);
            return new CreateDatabaseCommand(env, args[0]);
        }
    },
    READ_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            checkArgsLength(3, args);
            return new ReadKeyCommand(env, args[0], args[1], args[2]);
        }
    },
    UPDATE_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            checkArgsLength(4, args);
            return new UpdateKeyCommand(env, args[0], args[1], args[2], args[3]);
        }
    };

    public abstract DatabaseCommand getCommand(ExecutionEnvironment env, String... args);

    public void checkArgsLength(int length, String... args) {
        if (args.length != length) {
            throw new IllegalArgumentException("Must be " + length + " arguments");
        }
    }
}
