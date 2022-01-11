package pl.glownia.maciej.stoikcytatquiz

import android.os.Build

object Constants {

    // consts are compile time constants it means that their value has to be assigned
    // during compile time, unlike vals, where it can be done at runtime.
    // This means, that consts can never be assigned to a function or any class constructor,
    // but only to a String or primitive.

    // Location, under which are the details - can to retrieve them
    // when moving data from one activity to another.
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getRandomLimitedNumberOfQuestions(): ArrayList<Question> {
        val questionsList = getQuestion()
        // Set how many question would like to display
        val numberOfQuestionsToDisplay = 2
        // To have numbers of questions as equals above it need to subtract this value from arraylist size
        val randomElements =
            questionsList
                .asSequence()
                .take(questionsList.size.minus(numberOfQuestionsToDisplay))
                .toList()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            questionsList.removeIf { question -> randomElements.contains(question) }
        }
        questionsList.shuffle()
        return questionsList
    }

    private fun getQuestion(): ArrayList<Question> {
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
        questionListTest.shuffle()
        return questionListTest

    }

    private fun questionContent(): String {
        return "Czyje to słowa?"
    }

    private fun quotes(): Map<Int, String> {
        return mapOf(
            1 to "''Wiele jest ziarenek kadzielnych na jednym ołtarzu. Jedne najpierw wpadają, inne później. A to nie stanowi różnicy.''",
            2 to "''Nie same zdarzenia budzą w ludziach niepokój, ale sądy o nich.''",
            3 to "''Lepiej jest sporządzić bilans dotyczący własnego życia, niż rynku zbóż.''",
            4 to "''Uważam cię za pechowca, ponieważ nigdy nie zmierzyłes się z przeciwnościami losu. Przeszedłeś przez życie bez przeciwnika. Nikt, nawet ty, nie wie do czego jesteś zdolny.''",
            5 to "''Został osadzony w więzieniu. Jednak spostrzeżenie > spotkało go zło < dodałeś już sam.''",
            6 to "''Mamy dwoje uszu i jedne usta, abyśmy słuchali dwa razy tyle, co mówili.''",
            7 to "''Skutki gniewu są dużo poważniejsze od jego przyczyny.''",
            8 to "''Fortuna pragnie abym miał więcej wolności by filozofować. (Na wieść o zatonięciu statku z prawie całym majątkiem)''",
            9 to "''Chętnego Losy prowadzą, niechętnego wloką.''",
            10 to "''Lekarstwem na przyzwyczajenie jest inne przyzwyczajenie''",
            11 to "''Jeśli chcesz być czytelnikiem, czytaj, jeśli pisarzem, pisz.''",
            12 to "''Mędrzec nie będzie twierdzić tego, co mu się tylko wydaje, i dzięki temu nigdy nie przytaknie fałszowi.''",
            13 to "''Na tym właśnie polega dzielność szczęśliwego i pogodnego życia, że wszystko się czyni zgodnie z własnym głosem wewnętrznym i z wolą rządcy Wszechświata.''",
            14 to "''Ten, kto więcej grzeszy, i ten, kto mniej grzeszy, są równie dalecy od dobrego postępowania.''",
            15 to "''Czyż ból i życie nie są sobie pokrewne?''",
            16 to "''Celem człowieka jest rozważny wybór rzeczy, które są zgodne z naturą.''",
            17 to "''Błąd obcy pozostaw u jego źródła.''",
            18 to "''Nie należy sie gniewać na bieg wypadków. Nic ich to bowiem nie obchodzi.''",
            19 to "''Szpetne jest, by twarz była umysłowi podległa i według jego rozkazu układała się i stawała piękną, a by umysł nie układał się na swój rozkaz własny i nie upiększał.''",
            20 to "''Wsiadłeś na okręt, użyłeś podróży, dobiłeś do portu. Wysiądź!''",
            21 to "''Najlepszym lekarstwem na gniew jest zwłoka.''",
            22 to "''Panować nad sobą to najwyższa władza.''",
            23 to "''Ludzie nauczając, uczą się.''",
            24 to "''Życie bez celu jest błądzeniem.''",
            25 to "''Z życiem jak ze sztuką w teatrze: ważne nie jak długo trwa, ale jak zagrana.''",
            26 to "''Z bliska zazwyczaj lęk jest mniejszy.''",
            27 to "''Najpierw naucz się znaczenia tego, co chcesz powiedzieć, a dopiero potem mów.''",
            28 to "''Nic tak nie zadziwia ludzi, jak zdrowy rozsądek i proste działanie.''",
            29 to "''Nie usiłuj naginać biegu wydarzeń do swojej woli, ale naginaj wolę do biegu wydarzeń, a życie upłynie ci w pomyślności.''",
            30 to "''Raz zobaczyć jakąś rzecz znaczy więcej, niż sto razy o niej słyszeć.''"
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
            10 to 1,
            11 to 1,
            12 to 4,
            13 to 4,
            14 to 4,
            15 to 4,
            16 to 4,
            17 to 2,
            18 to 2,
            19 to 2,
            20 to 2,
            21 to 3,
            22 to 3,
            23 to 3,
            24 to 3,
            25 to 3,
            26 to 3,
            27 to 1,
            28 to 1,
            29 to 1,
            30 to 1
        )
    }
}