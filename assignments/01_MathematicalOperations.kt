package homework

class MathematicalOperations {

    /** 1 */
    fun greatestCommonDivisor(num1: Int, num2: Int): Int {

        var number1 = num1
        var number2 = num2

        if (number1 < 0) {
            number1 = -number1
        }

        if (number2 < 0) {
            number2 = -number2
        }

        while (number1 != number2) {
            if (number1 > number2) number1 -= number2
            else number2 -= number1
        }

        return number1
    }

    /** 2 */
    fun lowestCommonDenominator(number1: Int, number2: Int): Int {

        var denominator = if (number1 > number2) number1 else number2

        while (true) {
            if (denominator % number1 == 0 && denominator % number2 == 0) break

            ++denominator
        }

        return denominator
    }

    /** 3 */
    fun containDollarSign(text: String): Boolean {

        // Way 1
        text.forEach {
            if (it == '$') {
                return true
            }
        }

        return false

        // Way 2
//        return text.contains('$')
    }

    /** 4 */
    fun sumEvenNumbers(maximum: Int = 99): Int {

        return if (maximum != 0 && maximum % 2 == 0) {
            maximum + sumEvenNumbers(maximum - 2)
        } else if (maximum % 2 == 1) {
            sumEvenNumbers(maximum - 1)
        } else {
            maximum
        }

    }

    /** 5 */
    fun reversedNumber(number: Int) = number.toString().reversed().toInt()

    /** 6 */
    fun isPalindrome(word: String): Boolean {

        // Way 1
        var reverse = ""

        for (index in word.length - 1 downTo 0) {
            reverse += word[index].toLowerCase()
        }

        return word.toLowerCase() == reverse

        // Way 2
//        return word.equals(word.reversed(), ignoreCase = true)
    }

}