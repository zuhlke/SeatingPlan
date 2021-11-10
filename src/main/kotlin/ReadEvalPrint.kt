fun main() {

    println("Number of tables:")
    val noOfTables: Int = readLine()?.toInt()!!

    println("Number of seats per table:")
    val tableCapacity: Int = readLine()?.toInt()!!

    println("File name in resources folder with people:")
    val fileName: String = readLine()!!

    println("Computing seating plan...")

    println()

    val results = TableMapper().getSeatingPlanFor(
        noOfTables, tableCapacity, fileName
    )

    println(results)
}