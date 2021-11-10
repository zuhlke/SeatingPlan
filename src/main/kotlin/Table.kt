data class Table(
    val capacity: Int,
    val contents: MutableMap<Group, Int>
) {

    fun numberOfPeople(): Int = contents.values.sum()
    fun numberOfGroups(): Int = contents.keys.size

}

@JvmInline
value class Group(private val i: String)
