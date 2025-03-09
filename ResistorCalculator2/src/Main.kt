class Colors
{
    val name: String
    val digit: Int?
    val multiplier: Double
    val tolerance: Double?

    constructor(name: String, digit: Int?, multiplier: Double, tolerance: Double?) {
        this.name = name
        this.digit = digit
        this.multiplier = multiplier
        this.tolerance = tolerance
    }
}

abstract class Resistor
{
    val bandsNum: Int

    constructor(bandsNum: Int) {
        this.bandsNum = bandsNum
    }

    abstract fun calculateResistance(): Double
}

class FourBandsResistor : Resistor
{
    val firstBand: Colors
    val secondBand: Colors
    val multiplier: Colors
    val tolerance: Colors

    constructor(firstBand: Colors, secondBand: Colors, multiplier: Colors, tolerance: Colors) : super(4) {
        this.firstBand = firstBand
        this.secondBand = secondBand
        this.multiplier = multiplier
        this.tolerance = tolerance
    }

    override fun calculateResistance(): Double {
        return (firstBand.digit!! * 10 + secondBand.digit!!) * multiplier.multiplier
    }

}

fun setResistorColors(bandsNum: Int) : MutableList<Colors>
{
    val colorsMap: Map<String, Colors> = mapOf(
        "black"  to Colors("black",  0,    1.0,         null),
        "brown"  to Colors("brown",  1,    10.0,        1.0),
        "red"    to Colors("red",    2,    100.0,       2.0),
        "orange" to Colors("orange", 3,    1000.0,      null),
        "yellow" to Colors("yellow", 4,    10000.0,     null),
        "green"  to Colors("green",  5,    100000.0,    0.5),
        "blue"   to Colors("blue",   6,    1000000.0,   0.25),
        "violet" to Colors("violet", 7,    10000000.0,  0.1),
        "grey"   to Colors("grey",   8,    100000000.0, 0.05),
        "white"  to Colors("white",  9,    1000000000.0,null),
        "gold"   to Colors("gold",   null, 0.1,         5.0),
        "silver" to Colors("silver", null, 0.01,        10.0)
    )
    val selectedBands = mutableListOf<Colors>()

    var i = 0
    while (i < bandsNum) {
        println("Type the color ${i + 1}: ")
        val color: String = readln().lowercase()

        val selectedColor = colorsMap[color]
        if (selectedColor != null) {
            selectedBands.add(selectedColor)
            i++
        } else {
            println("Invalid color! Please try again.")
        }
    }

    return selectedBands
}

fun setBandsNum() : Int
{
    var bandsNum: Int

    while (true)
    {
        println("How many bands do you see? (4, 5, or 6)")
        bandsNum  = readln().lowercase().toInt()

        if(bandsNum < 4 || bandsNum > 6)
        {
            println("Invalid number! Please try again.")
        }else{
            break
        }
    }

    return bandsNum
}

fun setResistor(bandsNum: Int, colors: MutableList<Colors>) : Resistor
{
    return when (bandsNum) {
        4 -> {
            // Assuming 4-band resistor (first color, second color, multiplier, tolerance)
            val (firstColor, secondColor, thirdColor, fourthColor) = colors
            FourBandsResistor(firstColor, secondColor, thirdColor, fourthColor)
        }
//        5 -> {
//            // Assuming 5-band resistor (first color, second color, third color, multiplier, tolerance)
//            val (firstColor, secondColor, thirdColor, multiplierColor, toleranceColor) = colors
//            FiveBandsResistor(firstColor, secondColor, thirdColor, multiplierColor, toleranceColor)
//        }
//        6 -> {
//            // Assuming 6-band resistor (first color, second color, third color, fourth color, multiplier, tolerance)
//            val (firstColor, secondColor, thirdColor, fourthColor, multiplierColor, toleranceColor) = colors
//            SixBandsResistor(firstColor, secondColor, thirdColor, fourthColor, multiplierColor, toleranceColor)
//        }
        else -> throw IllegalArgumentException("Invalid number of bands. Only 4, 5, or 6 are allowed.")
    }

}

fun main()
{
    val bandsNum :Int = setBandsNum()
    val colors   :MutableList<Colors> = setResistorColors(bandsNum)
    val resistor : Resistor = setResistor(bandsNum, colors)

    println("Resistance Value: ${resistor.calculateResistance()}")
}