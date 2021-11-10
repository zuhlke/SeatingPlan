import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DistributeGroupsTest {

    @Test
    fun `two groups of two, two tables of capacity two`() {
        val groupedPeople = mapOf(Group("1") to 2, Group("2") to 2)
        val tables = emptyTables(noOfTables = 2, tableCapacity = 2)

        val assignments = distributeGroups(tables, groupedPeople)

        assertEquals(
            listOf(
                Table(2, mutableMapOf(Group("1") to 1, Group("2") to 1)),
                Table(2, mutableMapOf(Group("1") to 1, Group("2") to 1))
            ), assignments
        )
    }

    @Test
    fun `four people, three groups, two tables of capacity two`() {
        val groupedPeople = mapOf(Group("1") to 1, Group("2") to 2, Group("3") to 1)
        val tables = emptyTables(noOfTables = 2, tableCapacity = 2)

        val assignments = distributeGroups(tables, groupedPeople)

        assertEquals(
            listOf(
                Table(2, mutableMapOf(Group("1") to 1, Group("2") to 1)),
                Table(2, mutableMapOf(Group("3") to 1, Group("2") to 1))
            ), assignments
        )
    }

    @Test
    fun `five people, three groups, two tables of capacity two`() {
        val groupedPeople = mapOf(Group("1") to 2, Group("2") to 2, Group("3") to 1)
        val tables = emptyTables(noOfTables = 3, tableCapacity = 2)

        val assignments = distributeGroups(tables, groupedPeople)

        assertEquals(
            listOf(
                Table(2, mutableMapOf(Group("1") to 1, Group("2") to 1)),
                Table(2, mutableMapOf(Group("1") to 1, Group("3") to 1)),
                Table(2, mutableMapOf(Group("2") to 1)),
            ), assignments
        )
    }

    @Test
    fun `nine people, two groups, three tables `() {
        val groupedPeople = mapOf(Group("1") to 2, Group("2") to 7)
        val tables = emptyTables(noOfTables = 3, tableCapacity = 4)

        val assignments = distributeGroups(tables, groupedPeople)

        assertEquals(
            listOf(
                Table(4, mutableMapOf(Group("1") to 1, Group("2") to 2)),
                Table(4, mutableMapOf(Group("1") to 1, Group("2") to 2)),
                Table(4, mutableMapOf(Group("2") to 3)),
            ), assignments
        )
    }

    @Test
    fun `23 people, 4 groups, 4 tables `() {
        val groupedPeople = mapOf(Group("1") to 5, Group("2") to 10, Group("3") to 7, Group("4") to 1)
        val tables = emptyTables(noOfTables = 8, tableCapacity = 3)

        val assignments = distributeGroups(tables, groupedPeople)

        assertEquals(
            listOf(
                Table(3, mutableMapOf(Group("1") to 1, Group("2") to 1, Group("3") to 1)),
                Table(3, mutableMapOf(Group("1") to 1, Group("2") to 1, Group("3") to 1)),
                Table(3, mutableMapOf(Group("1") to 1, Group("2") to 1, Group("3") to 1)),
                Table(3, mutableMapOf(Group("1") to 1, Group("2") to 1, Group("3") to 1)),
                Table(3, mutableMapOf(Group("1") to 1, Group("2") to 1, Group("4") to 1)),
                Table(3, mutableMapOf(Group("2") to 2, Group("3") to 1)),
                Table(3, mutableMapOf(Group("2") to 2, Group("3") to 1)),
                Table(3, mutableMapOf(Group("2") to 1, Group("3") to 1)),
            ), assignments
        )
    }

}