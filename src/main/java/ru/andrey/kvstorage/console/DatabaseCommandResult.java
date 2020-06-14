package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    static DatabaseCommandResult success(String res) {
        return new DatabaseCommandResultImpl(DatabaseCommandStatus.SUCCESS, res);
    }

    static DatabaseCommandResult success() {
        return success(null);
    }

    static DatabaseCommandResult failed(String errorString) {
        return new DatabaseCommandResultImpl(DatabaseCommandStatus.FAILED, null, errorString);
    }

    class DatabaseCommandResultImpl implements DatabaseCommandResult {
        private String res;
        private String errorString;
        private DatabaseCommandStatus status;

        private DatabaseCommandResultImpl(DatabaseCommandStatus status, String res, String errorString) {
            this.res = res;
            this.status = status;
            this.errorString = errorString;
        }

        private DatabaseCommandResultImpl(DatabaseCommandStatus status, String result) {
            this(status, result, null);
        }

        @Override
        public Optional<String> getResult() {
            return Optional.ofNullable(res);
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            return status;
        }

        @Override
        public boolean isSuccess() {
            return status == DatabaseCommandStatus.SUCCESS;
        }

        @Override
        public String getErrorMessage() {
            return errorString;
        }
    }
}