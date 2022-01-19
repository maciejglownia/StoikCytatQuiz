package pl.glownia.maciej.stoikcytatquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvScore: TextView = findViewById(R.id.tv_score)
        val btnFinish: Button = findViewById(R.id.btn_finish)

        // intExtra cause mCorrectAnswers in QuizQuestionsActivity is Int
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        // Need to take care of endings in polish words depends on amount of correct and total answers
        var resultCorrectAnswersWordInPolish = "poprawna"
        var resultTotalAnswersWordInPolish = "możliwą"
        var answerWordFormInPolish = "odpowiedź"

        if (correctAnswers in 2..4) {
            resultCorrectAnswersWordInPolish = "poprawne"
        } else if (correctAnswers == 0 || correctAnswers in 5..100) {
            resultCorrectAnswersWordInPolish = "poprawnych"
        }

        if (correctAnswers > 1) {
            answerWordFormInPolish = "odpowiedzi"
        }
        if (totalQuestions == 1) {
            resultTotalAnswersWordInPolish = "możliwą"
        } else if (totalQuestions in 1..4) {
            resultTotalAnswersWordInPolish = "możliwe"
        } else if (totalQuestions == 0 || totalQuestions > 4) {
            resultTotalAnswersWordInPolish = "możliwych"
        }

        // Use resource string with placeholders
        // in other way there will be warning: do not concatenate text displayed with setText
        val resultText = "$correctAnswers $resultCorrectAnswersWordInPolish " +
                "$answerWordFormInPolish na $totalQuestions $resultTotalAnswersWordInPolish"

        tvScore.text = resultText

        btnFinish.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MenuActivity::class.java))
        }
    }
}