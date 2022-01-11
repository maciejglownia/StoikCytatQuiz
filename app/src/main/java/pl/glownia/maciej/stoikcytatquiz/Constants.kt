package pl.glownia.maciej.stoikcytatquiz

object Constants {

    // consts are compile time constants it means that their value has to be assigned
    // during compile time, unlike vals, where it can be done at runtime.
    // This means, that consts can never be assigned to a function or any class constructor,
    // but only to a String or primitive.

    // Location, under which are the details - can to retrieve them
    // when moving data from one activity to another.
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestion(): ArrayList<Question> {
        val questionListTest = ArrayList<Question>()
        val numberOfQuestions = quotes().size
        for (i in 1..numberOfQuestions) {
            val question = Question(
                i,
                questionContent(),
                quotes().getValue(i),
                possibilityAnswers().getValue(1),
                possibilityAnswers().getValue(2),
                possibilityAnswers().getValue(3),
                possibilityAnswers().getValue(4),
                correctAnswers().getValue(i)
            )
            questionListTest.add(question)
        }
        return questionListTest

    }

    private fun questionContent(): String {
        return "Czyje to słowa?"
    }

    private fun quotes(): Map<Int, String> {
        return mapOf(
            1 to "''Wiele jest ziarenek kadzielnych na jednym ołtarzu." +
                    " Jedne najpierw wpadają, inne później. " +
                    "A to nie stanowi różnicy.''",
            2 to "''Nie same zdarzenia budzą w ludziach niepokój, ale sądy o nich.''",
            3 to "''Lepiej jest sporządzić bilans dotyczący własnego życia, niż rynku zbóż.''",
            4 to "''Uważam cię za pechowca, ponieważ nigdy nie zmierzyłes się " +
                    "z przeciwnościami losu. Przeszedłeś przez życie bez przeciwnika. " +
                    "Nikt, nawet ty, nie wie do czego jesteś zdolny.''",
            5 to "''Został osadzony w więzieniu. Jednak spostrzeżenie " +
                    "> spotkało go zło < dodałeś już sam.''",
            6 to "''Mamy dwoje uszu i jedne usta, abyśmy słuchali dwa razy tyle, co mówili.''",
            7 to "''Skutki gniewu są dużo poważniejsze od jego przyczyny.''",
            8 to "''Fortuna pragnie abym miał więcej wolności by filozofować. " +
                    "(Na wieść o zatonięciu statku z prawie całym majątkiem)''",
            9 to "''Chętnego Losy prowadzą, niechętnego wloką.''",
            10 to "''Lekarstwem na przyzwyczajenie jest inne przyzwyczajenie''"
        )
    }

    private fun possibilityAnswers(): Map<Int, String> {
        return mapOf(
            1 to "Epitktet z Hierapolis",
            2 to "Marek Aureliusz",
            3 to "Seneka Młodszy",
            4 to "Zenon z Kition"
        )
    }

    private fun correctAnswers(): Map<Int, Int> {
        return mapOf(
            1 to 2,
            2 to 1,
            3 to 3,
            4 to 3,
            5 to 1,
            6 to 4,
            7 to 2,
            8 to 4,
            9 to 4,
            10 to 1
        )
    }
}