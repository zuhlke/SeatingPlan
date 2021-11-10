class TableMapper {

    val csvToGroups = ReadCSVToGroups()

    fun getSeatingPlanFor(
        noOfTables: Int,
        tableCapacity: Int,
        fileName: String
    ): List<Pair<String, List<String>>> {
        val groups = csvToGroups.readToGroups(fileName)
        val tables = emptyTables(noOfTables, tableCapacity)
        val distribution = distributeGroups(tables, groups.mapValues { it.value.size })
        return assignPeople(distribution, groups)
    }

    internal fun emptyTableWithCapacity(capacity: Int) = Table(capacity, mutableMapOf())

    internal fun emptyTables(noOfTables: Int, tableCapacity: Int): List<Table> {
        val tables = mutableListOf<Table>()
        repeat(noOfTables) {
            tables.add(emptyTableWithCapacity(tableCapacity))
        }
        return tables
    }

}
