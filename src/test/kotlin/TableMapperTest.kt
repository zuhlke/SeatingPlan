import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TableMapperTest {

    private val unit = TableMapper()

    @Test
    fun `seating plan for Sample1`() {
        val plan = unit.getSeatingPlanFor(noOfTables = 3, tableCapacity = 2, fileName = "Sample1.csv")

        with(plan[0].second) {
            assertTrue(
                this.size == 2
                        && (this.contains("Charlie") || this.contains("Delta"))
                        && (this.contains("Alpha") || this.contains("Bravo"))
            )
        }
        with(plan[1].second) {
            assertTrue(
                this.size == 2
                        && this.contains("Echo")
                        && (this.contains("Alpha") || this.contains("Bravo"))
            )
        }
        with(plan[2].second) {
            assertTrue(
                this.size == 1
                        && (this.contains("Charlie") || this.contains("Delta"))
            )
        }

        assertTrue(plan[2].second.size == 1)

//            listOf(
//                "Table0" to listOf("Alpha" | "Bravo", "Charlie" | "Delta"),
//                "Table1" to listOf("Alpha" | "Bravo", "Echo"),
//                "Table2" to listOf("Charlie" | "Delta"),
//            )
    }
}