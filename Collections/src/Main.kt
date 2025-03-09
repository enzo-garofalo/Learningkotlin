fun list()
{
    // Read only List
    val readOnlyList :List<String>  = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
    println(readOnlyList)

    // Updatable list
    val mutableList  :MutableList<String> = mutableListOf("Alpha", "Delta", "Epsilon")
    println("Original: $mutableList")

    mutableList.add("Gamma")
    println("New 1: $mutableList")

    mutableList.remove("Delta")
    println("New 2: $mutableList")


    // Casting of lists!
    val shape :MutableList<String> =  mutableListOf("Gamma", "Delta", "Epsilon")
        val shapesLocked :List<String> = shape

    println("The first element is ${readOnlyList[0]} or ${readOnlyList.first()}")
    println("The last  element is ${readOnlyList.last()}\n")

    println("All the elements:")
    for ((index, element) in readOnlyList.withIndex())
    {
        println("${index + 1} - $element")
    }
}


fun set()
{
    // Set - Its like a tuple
    // "Sets are UNORDERED an only stores UNIQUE items "
    // Unordered means it cannot be accessed by an index
    val readOnlySet: Set<String> = setOf("Alpha", "Beta", "Gamma", "Delta")

    println("Non-mutable: $readOnlySet")

    println("Alpha" in readOnlySet)
    println("Potato" in readOnlySet)

    val mutableSet :MutableSet<String> = mutableSetOf("Alpha", "Delta", "Epsilon")
    println("Mutable: $mutableSet")

    mutableSet.add("Gamma")
    println("New 1:   $mutableSet")

    mutableSet.remove("Gamma")
    println("New 2:   $mutableSet")
}

fun main()
{
    // Read only map
    val readOnlyMap : Map<String, Double> = mapOf(
        "Orange" to 30.9,
        "Apple"  to 100.0,
        "Kiwi"   to 20.9
    )
    println(readOnlyMap)

    // Having access to a value:
    println("Apple value = ${readOnlyMap["Apple"]}")
    // Counting
    println("Total map elements = ${readOnlyMap.count()}")
    // Contains key??
    println("Does map contain 'banana' - ${readOnlyMap.contains("Banana")}")

    val mutableList : MutableMap<String, Int> = mutableMapOf(
        "Orange" to 30,
        "Apple"  to 100,
        "Kiwi"   to 20
    )
    println(mutableList)

    // Mutable to non-mutable
    val mutableList2 : MutableMap<String, Int> = mutableMapOf("Orange" to 30, "Apple"  to 100, "Kiwi"   to 20)
        val mapLocked : Map<String, Int> = mutableList2
}