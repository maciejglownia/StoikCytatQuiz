package pl.glownia.maciej.stoikcytatquiz

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MenuActivity : AppCompatActivity() {

    //Create a dialog variable for dialog for user -> check showProgressDialog() method
    var customProgressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val settingsImageButton: ImageView = findViewById(R.id.settings_image_button)
        settingsImageButton.setOnClickListener {
            val intent = Intent(this@MenuActivity, SettingsActivity::class.java)
            startActivity(intent)
        }

        val buttonOneQuestion: Button = findViewById(R.id.btn_one_question)
        buttonOneQuestion.setOnClickListener {
            showProgressDialog()
            val intent = Intent(this@MenuActivity, QuizQuestionsActivity::class.java)
            intent.putExtra(
                "numberOfQuestionsToDisplay", 0
            )
            startActivity(intent)
            lifecycleScope.launch {
                execute()
            }
        }

        val buttonTenQuestions: Button = findViewById(R.id.btn_ten_questions)
        buttonTenQuestions.setOnClickListener {
            showProgressDialog()
            val intent = Intent(this@MenuActivity, QuizQuestionsActivity::class.java)
            intent.putExtra(
                "numberOfQuestionsToDisplay", 9
            )
            startActivity(intent)
            lifecycleScope.launch {
                execute()
            }
        }

        val buttonFortyQuestions: Button = findViewById(R.id.btn_forty_questions)
        buttonFortyQuestions.setOnClickListener {
            showProgressDialog()
            val intent = Intent(this@MenuActivity, QuizQuestionsActivity::class.java)
            intent.putExtra(
                "numberOfQuestionsToDisplay", 39
            )
            startActivity(intent)
            lifecycleScope.launch {
                execute()
            }
        }
    }

    // It will make it a coroutine function -> a SUSPEND function
    private suspend fun execute() {
        //  You can code here what you wants to execute in background execution without freezing the UI

        // Now to stop the function from blocking the UI, we need to add suspend in front of the
        // function but also we actually need to make sure that it runs on a different thread

        // The withContext here with context method and then passing a Dispatchers thought
        // remember to add to gradle -> implementation 'androidx.core:core-ktx:1.7.0'
        // we use the with context method to run the task
        /**
         * withContext is a method created to move an operation into a different thread
         * until it completes its process
         * And then it is moved back into the original thread
         * And then we're passing Dispatchers.IO which moves the task to a different thread,
         * which is the input output, thread, which is different from the UI thread
         */
        withContext(Dispatchers.IO) {
            // This is just a for loop which is executed for 30000 times.
            for (i in 1..30000) {
                Log.e("delay : ", "" + i)
            }
            // We can add something that we want to run on the UI thread, specifically by calling
            // the run on UI thread method here, and we can then say what kind of action we want
            // to execute on the UI thread inside of this call routine
            runOnUiThread {
                // Once we are done and we start running something on the wife thread
                // We can cancel it in the thread
                cancelProgressDialog()
            }
        }
    }

    /**
     * Method is used to show the Custom Progress Dialog.
     *
     * If you have such a situation where you want to run something and you want the user
     * to wait for a response?
     * Well, what you can do is you can add a progress dialogue
     *
     * The dialog visual side is created in layout!
     */
    private fun showProgressDialog() {
        customProgressDialog = Dialog(this@MenuActivity)
        // Set the screen content from a layout resource
        // The resource will be inflated, adding all top-level views to the screen
        customProgressDialog?.setContentView(R.layout.dialog_custom_progress)
        // Set transparent background of progress bar
        customProgressDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //Start the dialog and display it on screen
        customProgressDialog?.show()
    }

    /**
     * This function is used to dismiss the progress dialog if it is visible to user.
     *
     * Here cancel progress dialogue, which handles a progress dialogue which should be
     * also handled in the UI thread -> in runOnUiThread {}
     */
    private fun cancelProgressDialog() {
        if (customProgressDialog != null) {
            customProgressDialog?.dismiss()
            customProgressDialog = null
        }
    }

    // Override onBackPressed() method. Call customDialogFunction()
    override fun onBackPressed() {
        customDialogForBackButton()
    }

    // Set up custom dialog when user click back button during taking the quiz
    private fun customDialogForBackButton() {
        val customDialog = Dialog(this)
        // Set the screen content from a layout resource.
        // The resource will be inflated, adding all top-level views to the screen
        customDialog.setContentView(R.layout.dialog_custom_back_button_for_exit)
        customDialog.findViewById<TextView>(R.id.tv_submit).setOnClickListener {
            customDialog.dismiss() // Dialog will be dismissed
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
        customDialog.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
            customDialog.dismiss()
        }
        //Start the dialog and display it on screen.
        customDialog.show()
    }
}
