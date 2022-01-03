package pl.glownia.maciej.stoikcytatquiz

object Constants {

    fun getQuestions() : ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val question1 = Question(
            1,
            "Czyje to słowa?",
            "Wiele jest ziarenek kadzielnych na jednym ołtarzu."
                    +" Jedne najpierw wpadają, inne później. " +
                    "A to nie stanowi różnicy.",
            "Epiktet",
            "Marek Aureliusz",
            "Seneka",
            "Zenon",
            2
        )
        questionsList.add(question1)
        return questionsList
    }
}