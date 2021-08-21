/**
 * Main function where the execution starts
 *
 */
fun main() {
    val string = "abcdefg hij klmn opqrs tu vwxyz"
    println("String: $string is a pangram?  ${isPangram(string)} ")
}

/**
 * Returns a Boolean whether a string is pangram
 *
 * @param string The string which is to be analysed
 * @return Boolean Whether given string is a pangram or not.
 */
fun isPangram(string: String): Boolean {
    val arr = Array(26) { false }
    string.lowercase().forEach {
        if (it in 'a'..'z') {
            val index = it - 'a'
            arr[index] = true
        }
    }
    for (c in arr.indices)
        if (!arr[c])
            return false

    return true
}