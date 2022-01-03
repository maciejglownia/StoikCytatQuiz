package pl.glownia.maciej.stoikcytatquiz

data class Question(
    val id: Int,
    val question: String,
    val quote: String,
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String,
    val correctAnswer: Int
)
