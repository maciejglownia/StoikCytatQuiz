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

    fun createQuestion(): ArrayList<Question> {
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
        return mapOf(1 to "''Lekarstwem na przyzwyczajenie jest inne przyzwyczajenie''")
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
        return mapOf(1 to 1)
    }

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val question1 = Question(
            1,
            "Czyje to słowa?",
            "''Wiele jest ziarenek kadzielnych na jednym ołtarzu."
                    + " Jedne najpierw wpadają, inne później. " +
                    "A to nie stanowi różnicy.''",
            "Epitktet z Hierapolis",
            "Marek Aureliusz",
            "Seneka Młodszy",
            "Zenon z Kition",
            2
        )
        questionsList.add(question1)

        val question2 = Question(
            2,
            "Czyje to słowa?",
            "''Nie same zdarzenia budzą w ludziach niepokój, ale sądy o nich.''",
            "Epitktet z Hierapolis",
            "Marek Aureliusz",
            "Seneka Młodszy",
            "Zenon z Kition",
            1
        )
        questionsList.add(question2)

        val question3 = Question(
            3,
            "Czyje to słowa?",
            "''Lepiej jest sporządzić bilans dotyczący własnego życia, niż rynku zbóż.''",
            "Epitktet z Hierapolis",
            "Marek Aureliusz",
            "Seneka Młodszy",
            "Zenon z Kition",
            3
        )
        questionsList.add(question3)

        val question4 = Question(
            4,
            "Czyje to słowa?",
            "''Uważam cię za pechowca, ponieważ nigdy nie zmierzyłes się " +
                    "z przeciwnościami losu. Przeszedłeś przez życie bez przeciwnika." +
                    "Nikt, nawet ty, nie wie do czego jesteś zdolny.''",
            "Epitktet z Hierapolis",
            "Marek Aureliusz",
            "Seneka Młodszy",
            "Zenon z Kition",
            3
        )
        questionsList.add(question4)

        val question5 = Question(
            5,
            "Czyje to słowa?",
            "''Został osadzony w więzieniu. Jednak spostrzeżenie " +
                    "> spotkało go zło < dodałeś już sam.''",
            "Epitktet z Hierapolis",
            "Marek Aureliusz",
            "Seneka Młodszy",
            "Zenon z Kition",
            1
        )
        questionsList.add(question5)

        val question6 = Question(
            6,
            "Czyje to słowa?",
            "''Mamy dwoje uszu i jedne usta, abyśmy słuchali dwa razy tyle, co mówili.''",
            "Epitktet z Hierapolis",
            "Marek Aureliusz",
            "Seneka Młodszy",
            "Zenon z Kition",
            4
        )
        questionsList.add(question6)

        val question7 = Question(
            7,
            "Czyje to słowa?",
            "''Skutki gniewu są dużo poważniejsze od jego przyczyny.''",
            "Epitktet z Hierapolis",
            "Marek Aureliusz",
            "Seneka Młodszy",
            "Zenon z Kition",
            2
        )
        questionsList.add(question7)

        val question8 = Question(
            8,
            "Czyje to słowa?",
            "''Fortuna pragnie abym miał więcej wolności by filozofować. " +
                    "(Na wieść o zatonięciu statku z prawie całym majątkiem)''",
            "Epitktet z Hierapolis",
            "Marek Aureliusz",
            "Seneka Młodszy",
            "Zenon z Kition",
            4
        )
        questionsList.add(question8)


        val question9 = Question(
            9,
            "Czyje to słowa?",
            "''Chętnego Losy prowadzą, niechętnego wloką.''",
            "Epitktet z Hierapolis",
            "Marek Aureliusz",
            "Seneka Młodszy",
            "Zenon z Kition",
            4
        )
        questionsList.add(question9)

        val question10 = Question(
            10,
            questionContent(),
            quotes().getValue(10),
            possibilityAnswers().getValue(1),
            possibilityAnswers().getValue(2),
            possibilityAnswers().getValue(3),
            possibilityAnswers().getValue(4),
            correctAnswers().getValue(10)
        )
        questionsList.add(question10)

        return questionsList
    }


}