import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AssignPeopleTest {

    @Test
    fun `two groups of two`() {
        val groupedPeople = mapOf(
            Group(1) to listOf("1-Alpha", "1-Bravo"),
            Group(2) to listOf("2-Charlie", "2-Delta")
        )
        val groupedTables = listOf(
            Table(2, mutableMapOf(Group(1) to 1, Group(2) to 1)),
            Table(2, mutableMapOf(Group(1) to 1, Group(2) to 1))
        )

        val assignments = assignPeople(groupedTables, groupedPeople)

        assertEquals(
            listOf(
                "Table0" to listOf("1-Alpha", "2-Charlie"),
                "Table1" to listOf("1-Bravo", "2-Delta"),
            ), assignments
        )
    }

    @Test
    fun `three groups`() {
        val groupedPeople = mapOf(
            Group(1) to listOf("1-Alpha", "1-Bravo"),
            Group(2) to listOf("2-Charlie", "2-Delta"),
            Group(3) to listOf("3-Echo"),
        )
        val groupedTables = listOf(
            Table(2, mutableMapOf(Group(1) to 1, Group(2) to 1)),
            Table(2, mutableMapOf(Group(1) to 1, Group(3) to 1)),
            Table(2, mutableMapOf(Group(2) to 1)),
        )

        val assignments = assignPeople(groupedTables, groupedPeople)

        assertEquals(
            listOf(
                "Table0" to listOf("1-Alpha", "2-Charlie"),
                "Table1" to listOf("1-Bravo", "3-Echo"),
                "Table2" to listOf("2-Delta"),
            ), assignments
        )
    }

}