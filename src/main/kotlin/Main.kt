/**
 * Main function where the execution starts
 *
 */
fun main() {
    val year = 2000
    if (isLeapYear(year)) println("$year is a leap year") else println("$year is not a leap year")
}

/**
 * Returns a Boolean whether a year is leap year
 *
 * @param year The year which is to be analysed
 * @return Boolean Whether given year is a leap year or not.
 */
fun isLeapYear(year: Int): Boolean {
    if (year % 400 == 0)
        return true
    if (year % 100 == 0)
        return false
    if (year % 4 == 0)
        return true
    return false
}