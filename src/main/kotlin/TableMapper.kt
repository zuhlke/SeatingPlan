class TableMapper {

    operator fun invoke(tables: List<Table>, groupedPeople: Map<Group, Int>): List<Table> {
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
}

fun List<Table>.smallestTableWithSpace(): Table? =
    filter { it.capacity > it.numberOfPeople() }
        .minByOrNull { it.numberOfPeople() + it.numberOfGroups() / 2 }
