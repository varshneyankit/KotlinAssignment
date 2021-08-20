/**
 * Main function where the execution starts
 *
 */
fun main() {
    val year = 1900
    if (isLeapYear(year)) println("$year is a leap year") else println("$year is not a leap year")
}

/**
 * Returns a Boolean whether a year is leap year
 *
 * @param year The year which is to be analysed
 * @return Boolean Whether given year is a leap year or not.
 */
fun isLeapYear(year: Int) = year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)