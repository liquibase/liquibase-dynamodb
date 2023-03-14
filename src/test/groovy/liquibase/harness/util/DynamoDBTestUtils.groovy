package liquibase.harness.util

import liquibase.changelog.ChangeLogParameters
import liquibase.changelog.ChangeSet
import liquibase.changelog.DatabaseChangeLog
import liquibase.exception.LiquibaseException
import liquibase.ext.dynamodb.database.DynamoDBDatabase
import liquibase.parser.ChangeLogParser
import liquibase.parser.ChangeLogParserFactory
import liquibase.resource.ClassLoaderResourceAccessor

import java.util.stream.Collectors
import java.util.stream.StreamSupport

class DynamoDBTestUtils extends TestUtils {


    static List<ChangeSet> getChangesets(final String changeSetPath, final DynamoDBDatabase database) throws LiquibaseException {
        final ClassLoaderResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor();
        final ChangeLogParser parser =
                ChangeLogParserFactory.getInstance().getParser(
                        changeSetPath, resourceAccessor
                );

        final DatabaseChangeLog changeLog =
                parser.parse(changeSetPath, new ChangeLogParameters(database), resourceAccessor);
        return changeLog.getChangeSets();
    }

    static List<String> getCollections(final DynamoDBDatabase connection) {
        return StreamSupport.stream(connection.getMongoDatabase().listCollectionNames().spliterator(), false)
                .collect(Collectors.toList());
    }
}
