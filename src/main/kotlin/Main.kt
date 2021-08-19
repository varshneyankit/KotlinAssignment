import java.util.*

/**
 * Main function where the execution starts
 *
 */
fun main() {
    val string = "nsmlpoiquwrayzcbmnxkalsgetabdjhwgru ^iweyghfj& bdnjvbn mzx"
    println("String: $string is a pangram?  ${isPangram(string)} ")
}

/**
 * Returns a Boolean whether a string is pangram
 *
 * @param string The string which is to be analysed
 * @return Boolean Whether given string is a pangram or not.
 */
fun isPangram(string: String): Boolean{
    val lowerString = string.lowercase(Locale.getDefault())
    return ('a'..'z').all { it in lowerString }
}