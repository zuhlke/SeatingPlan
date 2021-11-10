import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TableMapperTest {

    val unit = TableMapper()

    @Test
    fun `seating plan for Sample1`() {
        val plan = unit.getSeatingPlanFor(noOfTables = 3, tableCapacity = 2, fileName = "Sample1.csv")

        assertEquals(
            listOf(
                "Table0" to listOf("Alpha", "Charlie"),
                "Table1" to listOf("Bravo", "Echo"),
                "Table2" to listOf("Delta"),
            ), plan
        )
    }
}