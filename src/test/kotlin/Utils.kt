internal fun emptyTableWithCapacity(capacity: Int) = Table(capacity, mutableMapOf())

internal fun emptyTables(noOfTables: Int, tableCapacity: Int): List<Table> {
    val tables = mutableListOf<Table>()
    repeat(noOfTables) {
        tables.add(emptyTableWithCapacity(tableCapacity))
    }
    return tables
}