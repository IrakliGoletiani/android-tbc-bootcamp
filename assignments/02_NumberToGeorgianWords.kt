package homework.oop_irakli

class NumberToGeorgianWords {

    private val numberNames = arrayOf(
        "", "ერთი", "ორი", "სამი", "ოთხი", "ხუთი",
        "ექვსი", "შვიდი", "რვა", "ცხრა", "ათი", "თერთმეტი", "თორმეტი", "ცამეტი",
        "თოთხმეტი", "თხუთმეტი", "თექვსმეტი", "ჩვიდმეტი", "თვრამეტი", "ცხრამეტი"
    )

    private val tensNames = arrayOf(
        "", "", "ოცდა", "ოცდა", "ორმოცდა",
        "ორმოცდა", "სამოცდა", "სამოცდა", "ოთხმოცდა", "ოთხმოცდა"
    )

    private val hundredNames =
        arrayOf("", "ასი", "ორასი", "სამასი", "ოთხასი", "ხუთასი", "ექვსასი", "შვიდასი", "რვაასი", "ცხრაასი")

    fun convertNumberToWord(num: Int): String {

        var number = num
        var word: String

        if (number % 100 < 20) {
            word = numberNames[number % 100]
            number /= 100
        } else {
            word = numberNames[number % 20]
            number /= 10
            word = "${tensNames[number % 10]}$word"
            number /= 10
        }

        return if (number == 0) {
            word
        } else {

            if (word.isEmpty()) {
                hundredNames[number]
            } else {
                "${hundredNames[number].substring(0, hundredNames[number].length - 1)}$word"
            }

        }
    }
}