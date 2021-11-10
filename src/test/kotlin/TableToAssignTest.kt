import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TableToAssignTest {

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
    fun `fewest groups chosen when equal number of people`() {
        val twoGroupsInTable = Table(3, mutableMapOf(Group(1) to 1, Group(2) to 1))
        val oneGroupInTable = Table(3, mutableMapOf(Group(1) to 2))

        assertEquals(oneGroupInTable, listOf(oneGroupInTable, twoGroupsInTable).smallestTableWithSpace())
    }
}