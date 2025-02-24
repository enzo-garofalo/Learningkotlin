import kotlin.math.pow

// pesquisar o que é uma data class
class ResistorColor(
    val value: Double,
    val multiplier : Double,
    val tolerance: Double?
)

fun main()
{
    var colorsValuesMap: HashMap<String, ResistorColor> = hashMapOf(
        "black"  to ResistorColor(0.0, 1.0, null),
        "brown"  to ResistorColor(1.0, 10.0, 1.0),
        "red"    to ResistorColor(2.0, 100.0, 2.0),
        "orange" to ResistorColor(3.0, 1000.0, null),
        "yellow" to ResistorColor(4.0, 10000.0, null),
        "green"  to ResistorColor(5.0, 100000.0, 0.5),
        "blue"   to ResistorColor(6.0, 1000000.0, 0.25),
        "violet" to ResistorColor(7.0, 10000000.0, 0.1),
        "grey"   to ResistorColor(8.0, 100000000.0, 0.05),
        "white"  to ResistorColor(9.0, 1000000000.0, null),
        "gold"   to ResistorColor(0.0, 0.1, 5.0),
        "silver" to ResistorColor(0.0, 0.01, 10.0),
    )

    println("How many bands do you See?")
    var bandsNum: Int = readln().toInt()
    var counter : Int = 0

    var usersColorsList =  mutableListOf<String>();
    while (counter < bandsNum)
    {
        println("Type the color ${counter+1}: ")
        var color: String  = readln().lowercase()
        usersColorsList.add(color)

        counter++
    }

    var result : Double = 0.0
    if(bandsNum == 4)
    {
        val firstColor = colorsValuesMap[usersColorsList[0]]!!
        val secondColor = colorsValuesMap[usersColorsList[1]]!!
        val multiplier = colorsValuesMap[usersColorsList[2]]!!

        result = (firstColor.value * 10.0 + secondColor.value) * multiplier.multiplier
    }

    // Exibe o resultado
    println("The resistor value is: $result ohms")

}
