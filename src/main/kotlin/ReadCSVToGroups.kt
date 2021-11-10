import com.opencsv.CSVReaderHeaderAware
import java.io.InputStreamReader

class ReadCSVToGroups {

    fun readToGroups(fileName: String): Map<Group, List<String>> {
        val values: MutableList<Array<String>> =
            CSVReaderHeaderAware(InputStreamReader(this.javaClass.getResourceAsStream(fileName)!!))
                .readAll()

        val results = mutableMapOf<Group, MutableList<String>>()

        values.forEach {
            val people = results.computeIfAbsent(Group(it[1])) { mutableListOf() }
            people.add(it[0])
        }

        return results
    }
}