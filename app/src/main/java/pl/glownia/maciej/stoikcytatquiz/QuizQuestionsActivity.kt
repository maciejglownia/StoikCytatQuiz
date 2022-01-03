package pl.glownia.maciej.stoikcytatquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

// After AppCompatActivity() I added View.OnClickListener to make things CLICKABLE
// Of course I need to override onClick method because OnClickListener is an interface
class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    // Create here than we can use it inside all methods
    private var mCurrentPosition: Int = 1

    // Nullable at this point because we cannot assign it at the outside of any method,
    // We need to assign it inside of the concrete method and then we can go ahead and
    // set up the selected option
    private var mQuestionsList: ArrayList<Question>? = null

    // We need to know which option was selected
    private var mSelectedOptionPosition: Int = 0

    // Here I need to set up all items I want to access
    // All of the views: e.g. TextViews, ImageViews, Buttons, ProgressBar, etc.
    private var tvQuestion: TextView? = null
    private var tvQuote: TextView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvAnswerOne: TextView? = null
    private var tvAnswerTwo: TextView? = null
    private var tvAnswerThree: TextView? = null
    private var tvAnswerFour: TextView? = null
    private var btnNext: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        tvQuestion = findViewById(R.id.tv_question)
        tvQuote = findViewById(R.id.tv_quote)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvAnswerOne = findViewById(R.id.tv_answer_one)
        tvAnswerTwo = findViewById(R.id.tv_answer_two)
        tvAnswerThree = findViewById(R.id.tv_answer_three)
        tvAnswerFour = findViewById(R.id.tv_answer_four)
        btnNext = findViewById(R.id.btn_next)
    }

    override fun onClick(view: View?) {
    }
}
