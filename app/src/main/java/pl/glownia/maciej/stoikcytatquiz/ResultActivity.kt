package pl.glownia.maciej.stoikcytatquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
            startActivity(Intent(this@ResultActivity, MenuActivity::class.java))
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
}