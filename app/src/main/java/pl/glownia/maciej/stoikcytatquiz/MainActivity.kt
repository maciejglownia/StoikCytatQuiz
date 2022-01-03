package pl.glownia.maciej.stoikcytatquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStart : Button = findViewById(R.id.btnStart)
        buttonStart.setOnClickListener{
            val intent = Intent(this@MainActivity, QuizQuestionsActivity::class.java)
            startActivity(intent)
        }
    }
}