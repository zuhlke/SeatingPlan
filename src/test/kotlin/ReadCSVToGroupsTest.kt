import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class ReadCSVToGroupsTest {

    @Test
    fun `read CSV into groups`() {
        val unit = ReadCSVToGroups()
        val groupedPeople = unit.readToGroups("Sample1.csv")

        assertEquals(
            mapOf(
                Group("Greenwich") to listOf("Alpha", "Bravo"),
                Group("Richmond") to listOf("Charlie", "Delta"),
                Group("Hyde") to listOf("Echo"),
            ), groupedPeople
        )
    }
}