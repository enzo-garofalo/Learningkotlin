package resistors

class Colors
{
    val name       : String
    val digit      : Int?
    val multiplier : Double
    val tolerance  : Double?

    constructor(name: String, digit: Int?, multiplier: Double, tolerance: Double?) {
        this.name  = name
        this.digit = digit
        this.multiplier = multiplier
        this.tolerance  = tolerance
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
    val firstBand  : Colors
    val secondBand : Colors
    val multiplier : Colors
    val tolerance  : Colors

    constructor(firstBand: Colors, secondBand: Colors, multiplier: Colors, tolerance: Colors) : super(4) {
        this.firstBand  = firstBand
        this.secondBand = secondBand
        this.multiplier = multiplier
        this.tolerance  = tolerance
    }

    override fun calculateResistance(): Double {
        val firstDigit  = firstBand.digit ?: 0
        val secondDigit = secondBand.digit ?: 0
        val multiplier  = multiplier.multiplier
        return (firstDigit * 10 + secondDigit) * multiplier
    }

}

class FiveBandsResistor : Resistor
{
    val firstBand  : Colors
    val secondBand : Colors
    val thirdBand  : Colors
    val multiplier : Colors
    val tolerance  : Colors

    constructor(firstBand: Colors, secondBand: Colors, thirdBand: Colors,
                multiplier: Colors, tolerance: Colors) : super(5) {
        this.firstBand  = firstBand
        this.secondBand = secondBand
        this.thirdBand  = thirdBand
        this.multiplier = multiplier
        this.tolerance  = tolerance
    }

    override fun calculateResistance(): Double {
        // Safely access 'digit' with the elvis operator (?:) to handle null values
        val firstDigit  = firstBand.digit ?: 0
        val secondDigit = secondBand.digit ?: 0
        val thirdDigit  = thirdBand.digit ?: 0
        val multiplier  = multiplier.multiplier

        // Formula for a 5-band resistor:
        // (first digit * 100 + second digit * 10 + third digit) * multiplier
        return (firstDigit * 100 + secondDigit * 10 + thirdDigit) * multiplier
    }
}

class SixBandsResistor : Resistor
{
    val firstBand  : Colors
    val secondBand : Colors
    val thirdBand  : Colors
    val multiplier : Colors
    val tolerance  : Colors
    val temperatureCoefficient: Colors

    constructor(firstBand: Colors, secondBand: Colors, thirdBand: Colors,
                multiplier: Colors, tolerance: Colors, temperatureCoefficient: Colors) : super(6) {
        this.firstBand  = firstBand
        this.secondBand = secondBand
        this.thirdBand  = thirdBand
        this.multiplier = multiplier
        this.tolerance  = tolerance
        this.temperatureCoefficient = temperatureCoefficient
    }

    override fun calculateResistance(): Double {
        // Safely access 'digit' with the elvis operator (?:) to handle null values
        val firstDigit  = firstBand.digit ?: 0
        val secondDigit = secondBand.digit ?: 0
        val thirdDigit  = thirdBand.digit ?: 0
        val multiplierValue = multiplier.multiplier

        // Formula for a 6-band resistor:
        // (first digit * 100 + second digit * 10 + third digit) * multiplier
        return (firstDigit * 100 + secondDigit * 10 + thirdDigit) * multiplierValue
    }
}
