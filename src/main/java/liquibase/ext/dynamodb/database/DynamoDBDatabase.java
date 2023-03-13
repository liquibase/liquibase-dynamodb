package liquibase.ext.dynamodb.database;

import liquibase.database.AbstractJdbcDatabase;
import liquibase.database.DatabaseConnection;
import liquibase.exception.DatabaseException;

public class DynamoDBDatabase extends AbstractJdbcDatabase {

    @Override
    public String getShortName() {
        return "dynamodb";
    }

    @Override
    protected String getDefaultDatabaseProductName() {
        return "DynamoDB";
    }

    @Override
    public boolean isCorrectDatabaseImplementation(DatabaseConnection databaseConnection) throws DatabaseException {
        return databaseConnection.getDatabaseProductName().equals("DynamoDB");
    }

    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }

    @Override
    public String getDisplayName() {
        return "DynamoDB";
    }

    @Override
    public String getDefaultDriver(String s) {
        return null;
    }

    @Override
    public Integer getDefaultPort() {
        return 8000;
    }

    @Override
    public boolean supportsInitiallyDeferrableColumns() {
        return false;
    }

    @Override
    public boolean supportsTablespaces() {
        return false;
    }
}
