fun main() {
    val userTimeOnline = 45542
    var answer = agoToText(userTimeOnline)
    println(answer)


}


fun agoToText(userTimeOnline: Int) = when {

    userTimeOnline > 0 && userTimeOnline < 60 -> "был(а) только что"


    userTimeOnline >= 60 && userTimeOnline < 60 * 60 -> {
        var minutes = (userTimeOnline / 60).toInt()
        var isWord = howToWriteMinute(userTimeOnline)
        "был(а) $minutes $isWord назад"
    }

    userTimeOnline >= 60 * 60 && userTimeOnline <= 60 * 60 * 24 -> {
        var hours = ((userTimeOnline / (60 * 60))).toInt()
        var isWord = howToWriteHours(userTimeOnline)
        "был(а) $hours $isWord назад"
    }

    userTimeOnline > 60 * 60 * 24 && userTimeOnline < 60 * 60 * 2 * 24 -> "был(а) вчера"


    userTimeOnline >= 60 * 60 * 24 * 2 && userTimeOnline < 60 * 60 * 3 * 24 -> "был(а) позавчера"

    userTimeOnline >= 60 * 60 * 24 * 3 -> "был(а) давно"

    else -> "время должно быть больше нуля"
}


fun howToWriteMinute(userTimeToOnline: Int) = when {
    (userTimeToOnline) / 60 in 10..19 -> "минут"
    ((userTimeToOnline) / 60 - 1) % 10 == 0 -> "минуту"
    ((userTimeToOnline) / 60 - 2) % 10 == 0 || (userTimeToOnline - 3) % 10 == 0 || (userTimeToOnline - 4) % 10 == 0 -> "минуты"
    else -> "минут"
}


fun howToWriteHours(userTimeToOnline: Int) = when {
    ((userTimeToOnline) / (60 * 60)).toInt() == 2
            || ((userTimeToOnline) / (60 * 60)).toInt() == 3
            || ((userTimeToOnline) / (60 * 60)).toInt() == 4
            || ((userTimeToOnline) / (60 * 60)).toInt() == 22
            || ((userTimeToOnline) / (60 * 60)).toInt() == 23
            || ((userTimeToOnline) / (60 * 60)).toInt() == 24 -> "часа"

    ((userTimeToOnline) / (60 * 60)).toInt() == 1
            || ((userTimeToOnline) / (60 * 60)).toInt() == 21 -> "час"

    else -> "часов"
}