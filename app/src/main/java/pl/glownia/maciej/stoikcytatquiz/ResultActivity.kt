package pl.glownia.maciej.stoikcytatquiz

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvScore: TextView = findViewById(R.id.tv_score)
        val btnFinish: Button = findViewById(R.id.btn_finish)
        // Need to take care of endings in polish words depends on amount of correct and total answers
        var resultCorrectAnswersWordInPolish = "poprawna"
        var resultTotalAnswersWordInPolish = "możliwą"
        var answerWordFormInPolish = "odpowiedź"

        // intExtra cause mCorrectAnswers in QuizQuestionsActivity is Int
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        val tvMessageBasedOnResult: TextView = findViewById(R.id.tv_message_based_on_result)
        val messageToUser = textToUserBasedOnQuizResult()
        tvMessageBasedOnResult.text = messageToUser

        // Different endings in Polish depends on correctAnswers and/or totalQuestions
        resultCorrectAnswersWordInPolish =
            checkCorrectFormOfCorrectWord(correctAnswers, resultCorrectAnswersWordInPolish)
        answerWordFormInPolish =
            checkCorrectFormOfAnswerWord(correctAnswers, answerWordFormInPolish)
        resultTotalAnswersWordInPolish =
            checkCorrectFormOfPossibleWord(totalQuestions, resultTotalAnswersWordInPolish)
        // Use resource string with placeholders
        // in other way there will be warning: do not concatenate text displayed with setText
        val resultText = "$correctAnswers $resultCorrectAnswersWordInPolish " +
                "$answerWordFormInPolish na $totalQuestions $resultTotalAnswersWordInPolish"

        tvScore.text = resultText

        btnFinish.setOnClickListener {
            //startActivity(Intent(this@ResultActivity, MenuActivity::class.java))
            finish() // <- better option to clean stack
        }
    }

    private fun checkCorrectFormOfPossibleWord(
        totalQuestions: Int,
        resultTotalAnswersWordInPolish: String
    ): String {
        var resultTotalAnswersWordInPolish1 = resultTotalAnswersWordInPolish
        if (totalQuestions == 1) {
            resultTotalAnswersWordInPolish1 = "możliwą"
        } else if (totalQuestions in 1..4) {
            resultTotalAnswersWordInPolish1 = "możliwe"
        } else if (totalQuestions == 0 || totalQuestions > 4) {
            resultTotalAnswersWordInPolish1 = "możliwych"
        }
        return resultTotalAnswersWordInPolish1
    }

    private fun checkCorrectFormOfAnswerWord(
        correctAnswers: Int,
        answerWordFormInPolish: String
    ): String {
        var answerWordFormInPolish1 = answerWordFormInPolish
        if (correctAnswers > 1) {
            answerWordFormInPolish1 = "odpowiedzi"
        }
        return answerWordFormInPolish1
    }

    private fun checkCorrectFormOfCorrectWord(
        correctAnswers: Int,
        resultCorrectAnswersWordInPolish: String
    ): String {
        var resultCorrectAnswersWordInPolish1 = resultCorrectAnswersWordInPolish
        if (correctAnswers in 2..4) {
            resultCorrectAnswersWordInPolish1 = "poprawne"
        } else if (correctAnswers == 0 || correctAnswers in 5..100) {
            resultCorrectAnswersWordInPolish1 = "poprawnych"
        }
        return resultCorrectAnswersWordInPolish1
    }

    private fun textToUserBasedOnQuizResult(): String {
        val result = calculateResultLevel()
        val laurelWreath: ImageView = findViewById(R.id.iv_laurel_wreath)

        if (result < 0 || result > 100) {
            return "Coś poszło nie tak. Błąd aplikacji." // "Something went wrong. App doesn't work properly."
        } else if (result == 100) {
            with(laurelWreath) { setColorFilter(ContextCompat.getColor(context, R.color.teal_200)) }
            return "Bezbłędnie! Wspaniały wynik!" // "Faultlessly! Great result!"
        } else if (result in 80..99) {
            with(laurelWreath) { setColorFilter(ContextCompat.getColor(context, R.color.silver)) }
            return "Bardzo dobry wynik. Tak trzymaj." // "Very good result. Keep it up."
        } else if (result in 60..79) {
            with(laurelWreath) { setColorFilter(ContextCompat.getColor(context, R.color.bronze)) }
            return "Więcej niż połowa, ale stać cię na więcej." // More than half, but you can do better.
        } else if (result in 40..59) {
            with(laurelWreath) { setColorFilter(ContextCompat.getColor(context, R.color.olive)) }
            return "Widać braki, ale nie łam się. Czyń postępy!" // Yours gap in knowledge are
            // visible, but don't worry. Do the progress.
        } else {
            with(laurelWreath) { setColorFilter(ContextCompat.getColor(context, R.color.light_black)) }
            return "Nie przejmuj się, ale poświęć więcej czasu na czytanie."
            // "Don't worry, but spend more time reading."
        }
    }

    private fun calculateResultLevel(): Int {
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        return correctAnswers * 100 / totalQuestions
    }
}