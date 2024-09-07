fun main() {
    val userTimeOnline = 7200
    var minutes = (userTimeOnline/60).toInt()
    var hours = (userTimeOnline/(60*60)).toInt()
    var answer = agoToText(userTimeOnline, minutes, hours)

    println(answer)


}


fun agoToText(userTimeOnline: Int, minutes: Int, hours: Int) = when {

    userTimeOnline > 0 && userTimeOnline < 60 -> "был(а) только что"


    userTimeOnline >= 60 && userTimeOnline < 60 * 60 -> {
        var minutes = (userTimeOnline/60).toInt()
        var isWord = howToWriteMinute(minutes)
        "был(а) $minutes $isWord назад"
    }

    userTimeOnline >= 60 * 60 && userTimeOnline <= 60 * 60 * 24 -> {
        var hours = (userTimeOnline / (60 * 60))
        var isWord = howToWriteHours(hours)
        "был(а) $hours $isWord назад"
    }

    userTimeOnline > 60 * 60 * 24 && userTimeOnline < 60 * 60 * 2 * 24 -> "был(а) вчера"


    userTimeOnline >= 60 * 60 * 24 * 2 && userTimeOnline < 60 * 60 * 3 * 24 -> "был(а) позавчера"

    userTimeOnline >= 60 * 60 * 24 * 3 -> "был(а) давно"

    else -> "время должно быть больше нуля"
}


fun howToWriteMinute(minutes: Int) = when {
    minutes in 10..19 -> "минут"
    (minutes - 1) % 10 == 0 -> "минуту"
    (minutes - 2) % 10 == 0 || (minutes - 3) % 10 == 0 || (minutes - 4) % 10 == 0 -> "минуты"
    else -> "минут"
}


fun howToWriteHours(hours: Int) = when (hours) {
    2,
    3,
    4,
    22,
    23,
    24 -> "часа"
    1,
    21 -> "час"
    else -> "часов"
}