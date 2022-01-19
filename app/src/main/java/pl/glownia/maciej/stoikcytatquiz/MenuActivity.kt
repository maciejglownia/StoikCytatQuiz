package pl.glownia.maciej.stoikcytatquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val buttonOneQuestion : Button = findViewById(R.id.btn_one_question)
        buttonOneQuestion.setOnClickListener{
            val intent = Intent(this@MenuActivity, QuizQuestionsActivity::class.java)
                intent.putExtra(
                    "numberOfQuestionsToDisplay", 1)
                startActivity(intent)
        }

        val buttonTenQuestions : Button = findViewById(R.id.btn_ten_questions)
        buttonTenQuestions.setOnClickListener{
                val intent = Intent(this@MenuActivity, QuizQuestionsActivity::class.java)
                intent.putExtra(
                    "numberOfQuestionsToDisplay", 10)
                startActivity(intent)
        }

        val buttonFortyQuestions : Button = findViewById(R.id.btn_forty_questions)
        buttonFortyQuestions.setOnClickListener{
            val intent = Intent(this@MenuActivity, QuizQuestionsActivity::class.java)
            intent.putExtra(
                "numberOfQuestionsToDisplay", 40)
            startActivity(intent)
        }
    }
}