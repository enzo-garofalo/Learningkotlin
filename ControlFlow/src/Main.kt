fun lambda()
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

    val numbers  : List<Int>    = listOf(1, -2, 3, -4, 5, -6)
    val positives  = numbers.filter({ x -> x > 0})
    val isNegative = { x: Int -> x < 0}
    val negative   = numbers.filter(isNegative)

    println(positives)
    println(negative)
}

fun main()
{
//  You have a list of actions supported by a web service, a common prefix for all requests, and an ID of a particular resource.
//  To request an action title over the resource with ID: 5,
//  you need to create the following URL: https://example.com/book-info/5/title.
//  Use a lambda expression to create a list of URLs from the list of actions.

    val	actions	=	listOf("title",	"year",	"author")
    val	prefix	=	"https://example.com/book-info"
    val	id	    =	5
    val	urls	=	actions.map	{	action	->	"$prefix/$id/$action"	}
    println(urls)
}