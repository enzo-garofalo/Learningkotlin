fun main()
{
    for (num in 1..10)
    {
        println(num)
    }

    var slices :Int = 8
    while (slices > 0)
    {
        println("The pizza has $slices slices")
        slices--
    }

    // lambda expression
    val upperCaseString = { text: String -> text.uppercase() }
    println(upperCaseString("enzo"))
}