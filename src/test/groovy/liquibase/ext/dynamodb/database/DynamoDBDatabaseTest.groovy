package liquibase.ext.dynamodb.database

import liquibase.database.DatabaseConnection
import spock.lang.Specification
import spock.lang.Unroll

class DynamoDBDatabaseTest extends Specification {

    @Unroll
    def "isCorrectDatabaseImplementation: #productName"() {
        when:
        def connection = Mock(DatabaseConnection)
        connection.getDatabaseProductName() >> productName

        then:
        new DynamoDBDatabase().isCorrectDatabaseImplementation(connection) == correct

        where:
        productName | correct
        "DynamoDB"  | true
        "MySQL"     | false
    }
}
