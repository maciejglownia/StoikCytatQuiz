package pl.glownia.maciej.stoikcytatquiz

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val question1 = Question(
            1,
            "Czyje to słowa?",
            "''Wiele jest ziarenek kadzielnych na jednym ołtarzu."
                    + " Jedne najpierw wpadają, inne później. " +
                    "A to nie stanowi różnicy.''",
            "Epiktet",
            "Marek Aureliusz",
            "Seneka",
            "Zenon z Kiton",
            2
        )
        questionsList.add(question1)

        val question2 = Question(
            2,
            "Czyje to słowa?",
            "''Nie same zdarzenia budzą w ludziach niepokój, ale sądy o nich.''",
            "Epiktet",
            "Marek Aureliusz",
            "Seneka",
            "Zenon z Kiton",
            1
        )
        questionsList.add(question2)

        val question3 = Question(
            3,
            "Czyje to słowa?",
            "''Lepiej jest sporządzić bilans dotyczący własnego życia, niż rynku zbóż.''",
            "Epiktet",
            "Marek Aureliusz",
            "Seneka",
            "Zenon z Kiton",
            3
        )
        questionsList.add(question3)

        val question4 = Question(
            4,
            "Czyje to słowa?",
            "''Uważam cię za pechowca, ponieważ nigdy nie zmierzyłes się " +
                    "z przeciwnościami losu. Przeszedłeś przez życie bez przeciwnika." +
                    "Nikt, nawet ty, nie wie do czego jesteś zdolny.''",
            "Epiktet",
            "Marek Aureliusz",
            "Seneka",
            "Zenon z Kiton",
            3
        )
        questionsList.add(question4)

        val question5 = Question(
            5,
            "Czyje to słowa?",
            "''Został osadzony w więzieniu. Jednak spostrzeżenie " +
                    "> spotkało go zło < dodałeś już sam.''",
            "Epiktet",
            "Marek Aureliusz",
            "Seneka",
            "Zenon z Kiton",
            1
        )
        questionsList.add(question5)

        val question6 = Question(
            6,
            "Czyje to słowa?",
            "''Mamy dwoje uszu i jedne usta, abyśmy słuchali dwa razy tyle, co mówili.''",
            "Epiktet",
            "Marek Aureliusz",
            "Seneka",
            "Zenon z Kiton",
            4
        )
        questionsList.add(question6)

        val question7 = Question(
            7,
            "Czyje to słowa?",
            "''Skutki gniewu są dużo poważniejsze od jego przyczyny.''",
            "Epiktet",
            "Marek Aureliusz",
            "Seneka",
            "Zenon z Kiton",
            2
        )
        questionsList.add(question7)

        val question8 = Question(
            8,
            "Czyje to słowa?",
            "''Fortuna pragnie abym miał więcej wolności by filozofować. " +
                    "(Na wieść o zatonięciu statku z prawie całym majątkiem)''",
            "Epiktet",
            "Marek Aureliusz",
            "Seneka",
            "Zenon z Kiton",
            4
        )
        questionsList.add(question8)


        val question9 = Question(
            9,
            "Czyje to słowa?",
            "''Chętnego Losy prowadzą, niechętnego wloką.''",
            "Epiktet",
            "Marek Aureliusz",
            "Seneka",
            "Zenon z Kiton",
            4
        )
        questionsList.add(question9)


        val question10 = Question(
            10,
            "Czyje to słowa?",
            "''Lekarstwem na przyzwyczajenie jest inne przyzwyczajenie''",
            "Epiktet",
            "Marek Aureliusz",
            "Seneka",
            "Zenon z Kiton",
            1
        )
        questionsList.add(question10)

        return questionsList
    }
}