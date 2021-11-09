import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AssignmentTest {

    @Test
    fun `two groups of two, two tables of capacity two`() {
        val groupedPeople = mapOf(Group(1) to 2, Group(2) to 2)
        val tables = emptyTables(noOfTables = 2, tableCapacity = 2)

        val assignments = TableMapper().invoke(tables, groupedPeople)

        assertEquals(
            listOf(
                Table(2, mutableMapOf(Group(1) to 1, Group(2) to 1)),
                Table(2, mutableMapOf(Group(1) to 1, Group(2) to 1))
            ), assignments
        )
    }

    @Test
    fun `four people, three groups, two tables of capacity two`() {
        val groupedPeople = mapOf(Group(1) to 1, Group(2) to 2, Group(3) to 1)
        val tables = emptyTables(noOfTables = 2, tableCapacity = 2)

        val assignments = TableMapper().invoke(tables, groupedPeople)

        assertEquals(
            listOf(
                Table(2, mutableMapOf(Group(1) to 1, Group(2) to 1)),
                Table(2, mutableMapOf(Group(3) to 1, Group(2) to 1))
            ), assignments
        )
    }

    @Test
    fun `nine people, two groups, three tables `() {
        val groupedPeople = mapOf(Group(1) to 2, Group(2) to 7)
        val tables = emptyTables(noOfTables = 3, tableCapacity = 4)

        val assignments = TableMapper().invoke(tables, groupedPeople)

        assertEquals(
            listOf(
                Table(4, mutableMapOf(Group(1) to 1, Group(2) to 2)),
                Table(4, mutableMapOf(Group(1) to 1, Group(2) to 2)),
                Table(4, mutableMapOf(Group(2) to 3)),
            ), assignments
        )
    }

    @Test
    fun `smallest table with space`() {
        val fullTable = Table(2, mutableMapOf(Group(1) to 2))
        val emptyTable = emptyTableWithCapacity(3)
        val tableWithOneSpace = Table(2, mutableMapOf(Group(1) to 1))

        assertEquals(emptyTable, listOf(fullTable, emptyTable, tableWithOneSpace).smallestTableWithSpace())
        assertEquals(tableWithOneSpace, listOf(fullTable, tableWithOneSpace).smallestTableWithSpace())
        assertEquals(null, listOf(fullTable).smallestTableWithSpace())
    }

    @Test
    fun `23 people, 4 groups, 4 tables `() {
        val groupedPeople = mapOf(Group(1) to 5, Group(2) to 10, Group(3) to 7, Group(4) to 1)
        val tables = emptyTables(noOfTables = 8, tableCapacity = 3)

        val assignments = TableMapper().invoke(tables, groupedPeople)

        assertEquals(
            listOf(
                Table(3, mutableMapOf(Group(1) to 1, Group(2) to 1, Group(3) to 1)),
                Table(3, mutableMapOf(Group(1) to 1, Group(2) to 1, Group(3) to 1)),
                Table(3, mutableMapOf(Group(1) to 1, Group(2) to 1, Group(3) to 1)),
                Table(3, mutableMapOf(Group(1) to 1, Group(2) to 1, Group(3) to 1)),
                Table(3, mutableMapOf(Group(1) to 1, Group(2) to 1, Group(4) to 1)),
                Table(3, mutableMapOf(Group(2) to 2, Group(3) to 1)),
                Table(3, mutableMapOf(Group(2) to 2, Group(3) to 1)),
                Table(3, mutableMapOf(Group(2) to 1, Group(3) to 1)),
            ), assignments
        )
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