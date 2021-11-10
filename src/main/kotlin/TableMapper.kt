class TableMapper {

    private val csvToGroups = ReadCSVToGroups()

    fun getSeatingPlanFor(
        noOfTables: Int,
        tableCapacity: Int,
        fileName: String
    ): List<Pair<String, List<String>>> {
        val groups: Map<Group, List<String>> = csvToGroups.readToGroups(fileName)
        val distribution: List<Table> =
            distributeGroups(emptyTables(noOfTables, tableCapacity), groups.mapValues { it.value.size })
        return assignPeople(distribution, groups.mapValues { it.value.shuffled() })
    }

    private fun emptyTableWithCapacity(capacity: Int) = Table(capacity, mutableMapOf())

    private fun emptyTables(noOfTables: Int, tableCapacity: Int): List<Table> {
        val tables = mutableListOf<Table>()
        repeat(noOfTables) {
            tables.add(emptyTableWithCapacity(tableCapacity))
        }
        return tables
    }

}
