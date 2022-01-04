package pl.glownia.maciej.stoikcytatquiz

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

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

        tvAnswerOne?.setOnClickListener(this)
        tvAnswerTwo?.setOnClickListener(this)
        tvAnswerThree?.setOnClickListener(this)
        tvAnswerFour?.setOnClickListener(this)
        btnNext?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()
        setQuestion()
        defaultAnswersView()
    }

    private fun setQuestion() {
        // It starts at the position one and then go through the individual positions now
        // This will give me the individual question that I am currently looking at
        var currentPosition = 1
        // This is unsafe nullable type (T?) conversion to a non-nullable type (T),
        // !! will throw NullPointerException if the value is null. (Force it)
        // Get the question
        val question: Question = mQuestionsList!![currentPosition - 1]
        // Set everything we need
        progressBar?.progress = currentPosition
        // e.g. 1/10 - depends on size of ArrayList - so on quantity of questions/quotes
        tvProgress?.text = "$currentPosition/${progressBar?.max}"
        // Set text question and answers
        tvQuestion?.text = question.question
        tvQuote?.text = question.quote
        tvAnswerOne?.text = question.answer1
        tvAnswerTwo?.text = question.answer2
        tvAnswerThree?.text = question.answer3
        tvAnswerFour?.text = question.answer4

        // Set the button based on, if it is next question or last click at the end
        if (mCurrentPosition == mQuestionsList!!.size) {
            btnNext?.text = "KONIEC"
        } else {
            btnNext?.text = "DALEJ"
        }
    }

    // Set the default options when the new position is loaded or when the answer is reselected
    // It's going to reset basically the colors of the selected answers,
    // then we can just set it to other color
    private fun defaultAnswersView() {
        // List of text views, which are my four text use that I can select from
        val answers = ArrayList<TextView>()
        // Because answer one is a nullable I need to use "let statement"
        // Then I can add this answer to the answers
        // Text view, which is what we need here for our options array list
        tvAnswerOne?.let {
            // I can now add it at the index zero.
            answers.add(0, it) // it is actual text view, so tvAnswerOne
        }
        tvAnswerTwo?.let {
            answers.add(1, it)
        }
        tvAnswerThree?.let {
            answers.add(2, it)
        }
        tvAnswerFour?.let {
            answers.add(3, it)
        }

        // Set color for answer default answer (before answer)
        for (answer in answers) {
            answer.setTextColor(Color.parseColor("#89896C"))
            // Typeface is another property of answer
            answer.typeface = Typeface.DEFAULT
            // res -> drawable -> default...
            answer.background = ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                R.drawable.default_answer_border_bg
            )
        }
    }

    // We need to know which text we need to change and then we need
    // to know which answer it was (arguments -> answer number (Int))
    private fun selectedAnswerView(tv: TextView, selectedAnswerNumber: Int) {
        //Set every single button to its normal state
        defaultAnswersView()

        mSelectedOptionPosition = selectedAnswerNumber
        // Set text view after click on it
        tv.setTextColor(Color.parseColor("#7E7E63"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            R.drawable.selected_answer_border_bg
        )
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            // When we clicked on the answer one and so on
            // We're calling this select that answer view method that we just created
            // It will highlight the selected option -> change its appearance.
            // Important ! At the same time, it's also going to change the selected option number,
            // We need to know if we've selected the correct option or not
            R.id.tv_answer_one -> {
                tvAnswerOne?.let {
                    selectedAnswerView(it, 1) // it is the TV option one text view
                }
            }
            R.id.tv_answer_two -> {
                tvAnswerTwo?.let {
                    selectedAnswerView(it, 2)
                }
            }
            R.id.tv_answer_three -> {
                tvAnswerThree?.let {
                    selectedAnswerView(it, 3)
                }
            }
            R.id.tv_answer_four -> {
                tvAnswerFour?.let {
                    selectedAnswerView(it, 4)
                }
            }
        }
    }

    // Assign the color
    // This method requires context as an integer, which is drawable resources ID
    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tvAnswerOne?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            2 -> {
                tvAnswerTwo?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            3 -> {
                tvAnswerThree?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            4 -> {
                tvAnswerFour?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
        }
    }
}
