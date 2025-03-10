data class Colors(
    val name: String,
    val digit: Int?,
    val multiplier: Double,
    val tolerance: Double?
)

abstract class Resistor
{
    val bandsNum: Int

    constructor(bandsNum: Int) {
        this.bandsNum = bandsNum
    }

    abstract fun calculateResistance(): Double
}

// Four Bands Resistor

class FourBandsResistor : Resistor
{
    private val firstBand  : Colors
    private val secondBand : Colors
    private val multiplier : Colors
    private val tolerance  : Colors

    constructor(firstBand: Colors, secondBand: Colors, multiplier: Colors, tolerance: Colors) : super(4)
    {
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

// Five Bands Resistor
class FiveBandsResistor : Resistor
{
    private val firstBand  : Colors
    private val secondBand : Colors
    private val thirdBand  : Colors
    private val multiplier : Colors
    private val tolerance  : Colors

    constructor(firstBand: Colors, secondBand: Colors, thirdBand: Colors,
                multiplier: Colors, tolerance: Colors
    ) : super(5)
    {
        this.firstBand  = firstBand
        this.secondBand = secondBand
        this.thirdBand  = thirdBand
        this.multiplier = multiplier
        this.tolerance  = tolerance
    }

    override fun calculateResistance(): Double {
        // Safely access 'digit' with the elvis operator (?:) to handle null values
        val firstDigit  = firstBand.digit  ?: 0
        val secondDigit = secondBand.digit ?: 0
        val thirdDigit  = thirdBand.digit  ?: 0
        val multiplier  = multiplier.multiplier

        // Formula for a 5-band resistor:
        // (first digit * 100 + second digit * 10 + third digit) * multiplier
        return (firstDigit * 100 + secondDigit * 10 + thirdDigit) * multiplier
    }
}

// Six Bands Resistor

class SixBandsResistor : Resistor
{
    private val firstBand  : Colors
    private val secondBand : Colors
    private val thirdBand  : Colors
    private val multiplier : Colors
    private val tolerance  : Colors
    private val temperatureCoefficient: Colors

    constructor(firstBand: Colors, secondBand: Colors, thirdBand: Colors,
                multiplier: Colors, tolerance: Colors, temperatureCoefficient: Colors
    ) : super(6)
    {
        this.firstBand  = firstBand
        this.secondBand = secondBand
        this.thirdBand  = thirdBand
        this.multiplier = multiplier
        this.tolerance  = tolerance
        this.temperatureCoefficient = temperatureCoefficient
    }

    override fun calculateResistance(): Double {
        // Safely access 'digit' with the elvis operator (?:) to handle null values
        val firstDigit  = firstBand.digit  ?: 0
        val secondDigit = secondBand.digit ?: 0
        val thirdDigit  = thirdBand.digit  ?: 0
        val multiplierValue = multiplier.multiplier

        // Formula for a 6-band resistor:
        // (first digit * 100 + second digit * 10 + third digit) * multiplier
        return (firstDigit * 100 + secondDigit * 10 + thirdDigit) * multiplierValue
    }
}
