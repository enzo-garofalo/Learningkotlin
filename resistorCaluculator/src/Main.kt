import kotlin.math.pow

// Data class para representar um resistor
data class Resistor(
    val colorList: List<String>,
    val firstColor: Double,
    val secondColor: Double,
    val multiplier: Double,
    val tolerance: Double?
) {
    fun getResultFourBands(): Double {
        return (firstColor * 10 + secondColor) * multiplier
    }
}

fun main() {
    val colorsValuesMap: HashMap<String, List<Double?>> = hashMapOf(
        "black"  to listOf(0.0, 1.0, null),
        "brown"  to listOf(1.0, 10.0, 1.0),
        "red"    to listOf(2.0, 100.0, 2.0),
        "orange" to listOf(3.0, 1000.0, null),
        "yellow" to listOf(4.0, 10000.0, null),
        "green"  to listOf(5.0, 100000.0, 0.5),
        "blue"   to listOf(6.0, 1000000.0, 0.25),
        "violet" to listOf(7.0, 10000000.0, 0.1),
        "grey"   to listOf(8.0, 100000000.0, 0.05),
        "white"  to listOf(9.0, 1000000000.0, null),
        "gold"   to listOf(null, 0.1, 5.0),
        "silver" to listOf(null, 0.01, 10.0),
    )

    println("How many bands do you see?")
    val bandsNum = readln().toInt()
    val usersColorsList = mutableListOf<String>()

    while (counter < bandsNum)
    {
        println("Type the color ${counter+1}: ")
        var color: String  = readln().lowercase()
        usersColorsList.add(color)

        counter++
    }

    switch (bandsNum)
    if (bandsNum == 4) {
        val firstColor = colorsValuesMap[usersColorsList[0]]?.get(0)
        val secondColor = colorsValuesMap[usersColorsList[1]]?.get(0)
        val multiplier = colorsValuesMap[usersColorsList[2]]?.get(1)
        val tolerance = colorsValuesMap[usersColorsList[3]]?.get(2)

        if (firstColor != null && secondColor != null && multiplier != null) {
            val resistor = Resistor(usersColorsList, firstColor, secondColor, multiplier, tolerance)
            val result = resistor.getResultFourBands()

            println("The resistor value is: $result ohms ±${tolerance ?: "unknown"}%")
        } else {
            println("Invalid color input. Please try again.")
        }
    } else {
        println("Currently, only 4-band resistors are supported.")
    }
}
