package pl.glownia.maciej.stoikcytatquiz

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

// After AppCompatActivity() is View.OnClickListener to make things CLICKABLE
//  need to override onClick method because OnClickListener is an interface
class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    // Create here than we can use it inside all methods
    private var mCurrentPosition: Int = 1

    // Nullable at this point because we cannot assign it at the outside of any method,
    // We need to assign it inside of the concrete method and then we can go ahead and
    // set up the selected answer
    private var mQuestionsList: ArrayList<Question>? = null

    // We need to know which answer was selected (0 is default)
    private var mSelectedAnswerPosition: Int = 0
    private var mCorrectAnswers: Int = 0

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

        // This time we use setOnClickListener with ()
        // if we use { } we need to write a lot of code
        // now only 5 lines as we see below
        // because we implement onClickListener and we override on Click method
        // () are enough in that case
        tvAnswerOne?.setOnClickListener(this)
        tvAnswerTwo?.setOnClickListener(this)
        tvAnswerThree?.setOnClickListener(this)
        tvAnswerFour?.setOnClickListener(this)
        btnNext?.setOnClickListener(this)

        // Retrieve parameter from button from MenuActivity to pass it to QuestionRandomizer
        val numberOfQuestionsToDisplay = intent.getIntExtra(
            "numberOfQuestionsToDisplay", 0
        )
        mQuestionsList = QuestionsRandomizer
            .getRandomLimitedNumberOfQuestions(numberOfQuestionsToDisplay)
        setQuestion()
    }

    private fun setQuestion() {
        // Reset selected answer or answers if incorrect to make them cleared in next question
        defaultAnswersView()
        // This is unsafe nullable type (T?) conversion to a non-nullable type (T),
        // !! will throw NullPointerException if the value is null. (Force it)
        // Because the question list is nullable we have to make here double ! to force it
        // Because we are sure that question list is not going to be empty at this point
        // Get the question
        val question: Question = mQuestionsList!![mCurrentPosition - 1]// Set everything we need
        progressBar?.progress = mCurrentPosition
        progressBar?.max = mQuestionsList!!.size
        // e.g. 1/10 - depends on size of ArrayList - so on quantity of questions/quotes
        val progressNumbers = "$mCurrentPosition/${mQuestionsList!!.size}"
        tvProgress?.text = progressNumbers
        // Set text question and answers
        tvQuestion?.text = question.question
        tvQuote?.text = question.quote
        tvAnswerOne?.text = question.answer1
        tvAnswerTwo?.text = question.answer2
        tvAnswerThree?.text = question.answer3
        tvAnswerFour?.text = question.answer4

        // Set the button for "CONFIRM" text to let user confirm their choice
        btnNext?.text = "POTWIERDŹ" // "CONFIRM"
    }

    // Set the default answers when the new position is loaded or when the answer is reselected
// It's going to reset basically the colors of the selected answers,
// then we can just set it to other color
    private fun defaultAnswersView() {
        // List of text views, which are my four text use that I can select from
        val answers = ArrayList<TextView>()
        // Because answer one is a nullable I need to use "let statement"
        // Then I can add this answer to the answers
        // Text view, which is what we need here for our answers array list
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
            answer.setTextColor(Color.parseColor("#001219"))
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

        mSelectedAnswerPosition = selectedAnswerNumber
        // Set text view after click on it
        tv.setTextColor(Color.parseColor("#001219"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            R.drawable.selected_answer_border_bg
        )
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

    override fun onClick(view: View?) {
        when (view?.id) {
            // When we clicked on the answer one and so on
            // We're calling this select that answer view method that we just created
            // It will highlight the selected answer -> change its appearance.
            // Important ! At the same time, it's also going to change the selected answer number,
            // We need to know if we've selected the correct answer or not
            R.id.tv_answer_one -> {
                tvAnswerOne?.let {
                    selectedAnswerView(it, 1) // it is the TV answer one text view
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
            // Check if the selected answer is 1, 2, 3 or 4
            // Selected answer position is zero because that's what it is by default.
            // I'm going to increase the current position by one, which means
            // to go to the next question
            R.id.btn_next -> {
                if (mSelectedAnswerPosition == 0) {
                    // Make sure that one of answers is clicked
                    if (mSelectedAnswerPosition == 0 &&
                        btnNext!!.text.equals("POTWIERDŹ")  // "CONFIRM"
                    ) {   // "CONFIRM"
                        Toast.makeText(
                            this,
                            "Zaznacz odpowiedź!", Toast.LENGTH_SHORT    // "PICK THE ANSWER"
                        ).show()
                    } else {
                        mCurrentPosition++
                    }

                    // As long there are questions yet it is going to ask for next question
                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(
                                this@QuizQuestionsActivity,
                                ResultActivity::class.java
                            )
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            // how many questions are there in total and sent. That's what that size gets.
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                            // finish activity at the end cause I don't want user to jump to questions
                            // User should only (when clicking the back button), be able
                            // to get back to the start screen
                        }
                    }
                } else {
                    // Need to know at which position we are and what the correct answer is
                    val question =
                        mQuestionsList?.get(mCurrentPosition - 1) // -1 -> counts from zero
                    if (mSelectedAnswerPosition != question!!.correctAnswer) {
                        answerView(mSelectedAnswerPosition, R.drawable.wrong_answer_border_bg)
                    } else {
                        // Protect to count correct answer only when clicked on correct answer once
                        var clicked = 0
                        if (clicked == 0) {
                            mCorrectAnswers++ // increment if answer is correct
                        }
                    }
                    // Need to set correct answer on color for correct answer if users answer
                    // was either good or bad
                    answerView(question.correctAnswer, R.drawable.correct_answer_border_bg)

                    // Set the button based on, if it is next question or last click at the end
                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btnNext?.text = "KONIEC" // "THE END"
                    } else {
                        btnNext?.text = "NASTĘPNE PYTANIE" // "NEXT QUESTION"
                    }
                    // Set back the selected option position to zero
                    // Because otherwise we will always stay at the current selected option
                    mSelectedAnswerPosition = 0
                }
            }
        }
    }

    // Override onBackPressed() method. Call customDialogFunction()
    override fun onBackPressed() {
        customDialogFunction()
    }

    // Set up custom dialog when user click back button during taking the quiz
    private fun customDialogFunction() {
        val customDialog = Dialog(this)
        // Set the screen content from a layout resource.
        // The resource will be inflated, adding all top-level views to the screen
        customDialog.setContentView(R.layout.dialog_custom_back_button)
        customDialog.findViewById<TextView>(R.id.tv_submit).setOnClickListener {
            customDialog.dismiss() // Dialog will be dismissed
            val intent = Intent(this@QuizQuestionsActivity, MenuActivity::class.java)
            startActivity(intent)
        }
        customDialog.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
            customDialog.dismiss()
        }
        //Start the dialog and display it on screen.
        customDialog.show()
    }
}
