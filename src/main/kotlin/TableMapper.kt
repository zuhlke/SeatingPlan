fun distributeGroups(tables: List<Table>, groupedPeople: Map<Group, Int>): List<Table> {
    groupedPeople.forEach { (group, population) ->
        repeat(population) {
            tables.smallestTableWithSpace()?.let {
                val numberOfPeople = it.contents.computeIfAbsent(group) { 0 }
                it.contents[group] = numberOfPeople + 1
            }
        }
    }

    return tables
}

fun List<Table>.smallestTableWithSpace(): Table? =
    filter { it.capacity > it.numberOfPeople() }
        .minByOrNull { it.numberOfPeople() + it.numberOfGroups() / 2 }


fun assignPeople(
    groupedTables: List<Table>,
    groupedPeople: Map<Group, List<String>>
): List<Pair<String, List<String>>> {
    val peeps = groupedPeople.mapValues { it.value.toMutableList() }
    val result: MutableMap<TableWithId, MutableList<String>> = mutableMapOf()

    groupedTables
        .mapIndexed { index, table -> TableWithId(index, table) }
        .forEach { item ->
            item.table.contents.forEach { (group, size) ->
                repeat(size) {
                    peeps.pop(group)?.let {
                        result.computeIfAbsent(item) { mutableListOf() }.add(it)
                    }
                }
            }
        }

    return result.mapKeys { "Table${it.key.id}" }.toList()
}

fun Map<Group, MutableList<String>>.pop(group: Group): String? {
    val person = this[group]?.get(0)?.let {
        this[group]?.remove(it)
        it
    }
    return person
}

data class TableWithId(
    val id: Int,
    val table: Table
)