package pl.glownia.maciej.stoikcytatquiz

import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Set up sending mail to developer
        val contactButton: LinearLayout = findViewById(R.id.ll_contact)
        contactButton.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:maciej.k.glownia@gmail.com")
            }
            startActivity(Intent.createChooser(emailIntent, "Send feedback"))
        }

        // Set up button to open privacy policy
        val privacyButton: LinearLayout = findViewById(R.id.ll_privacy_policy)
        privacyButton.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW, Uri.parse(
                    "https://sites.google.com/view/stoikcytatquiz-privacypolicy"
                )
            )
            startActivity(browserIntent)
        }

        // Set up button to redirect user to google store to rate the app
        val rateButton: LinearLayout = findViewById(R.id.ll_rate)
        rateButton.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=$packageName")
                    )
                )
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    )
                )
            }
        }

        // Set up button to display info about app to user as dialog
        val aboutButton: LinearLayout = findViewById(R.id.ll_about)
        aboutButton.setOnClickListener {
            showDescriptionDialog()
        }

        // Set up button to open lepiejteraz.pl - website of Radosław Budnicki about stoic life
        val lepiejTerazButton: LinearLayout = findViewById(R.id.ll_lepiej_teraz)
        lepiejTerazButton.setOnClickListener {
showDialogToAskUserIfWantsToGoToPolishPodcastAboutStoicism()
        }
    }

    private fun showDescriptionDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("O aplikacji")
        builder.setMessage(
            "Aplikacja została stworzona z myślą o wszystkich, którzy chcą poznać lub " +
                    "utrwalić mądrości czterech znanych stoików: Epikteta z Hierapolis, " +
                    "Marka Aureliusza, Seneki Młodszego, Zenona z Kition." +
                    "\n\nAplikacja została zaprojektowana w formie quizu składającego się " +
                    "z 1, 10 lub 40 pytań. Użytkownik decyduje na ile pytań chce odpowiedzieć. " +
                    "W bazie jest łącznie 100 cytatów. W zależności od osiągniętego wyniku użytkownik " +
                    "otrzymuje na koniec trofeum w postaci wieńca laurowego. " +
                    "\nKolory wieńca (kolejno od największej ilości punktów, procent poprawnych odpowiedzi):" +
                    "\n\n 1. Złoty -> 100%" +
                    "\n 2. Srebrny -> 80 - 99%" +
                    "\n 3. Brązowy -> 60 - 79%" +
                    "\n 4. Oliwkowy -> 40 - 59%" +
                    "\n 5. Czarny -> 0 - 39%" +
                    "\n\nMam nadzieję, że ten quiz będzie nie tylko dobrą zabawą, ale także pozwoli " +
                    "lepiej zapamiętać ponadczasowe myśli stoickie." +
                    "\n\nPowodzenia!"
        )

        builder.setNegativeButton("Zamknij") { dialogInterface, _ ->
            dialogInterface.dismiss() // Dialog will be dismissed
        }

        val appDescription: AlertDialog = builder.create()
        appDescription.setCancelable(false) // Will not allow user to cancel after clicking on remaining screen area
        appDescription.show()  // show the dialog to UI
    }


    // Need this method to let user decide to go to the website or stay in the application
    private fun showDialogToAskUserIfWantsToGoToPolishPodcastAboutStoicism() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Drogi Gościu!") // Dear Guest!
        // Description to inform user that they can go to the website or stay in the application
        builder.setMessage(
            "Jeśli szukasz więcej mądrości i pragniesz sięgnąć głębiej do stoicyzmu, " +
                    "koniecznie poznaj Radka Budnickiego i jego podcast ''Lepiej Teraz'' klikając " +
                    "''ZABIERZ MNIE'' poniżej. \nTam otrzymasz mnówstwo informacji na ten temat. " +
                    "Jestem pewien, że nie będzie to wizyta na chwilę. " +
                    "\nJeśli natomiast chcesz pozostać w aplikacji wybierz ''ZOSTAJĘ''." +
                    "\n\n\nWybierając ''ZABIERZ MNIE'' jednocześnie wyrażasz zgodę na przeniesienie Cię do " +
                    " strony internetowej podcastu ''Lepiej Teraz''."
        )
        builder.setPositiveButton("ZABIERZ MNIE") // Take me (to the website)
        { dialogInterface, _ ->
            dialogInterface.dismiss()
            val browserIntent = Intent(
                Intent.ACTION_VIEW, Uri.parse(
                    "https://lepiejteraz.pl/"
                )
            )
            startActivity(browserIntent)
        }
        builder.setNegativeButton("ZOSTAJĘ") // I'm staying (in the application)
        { dialogInterface, _ ->
            dialogInterface.dismiss() // Dialog will be dismissed
        }
        val appDescription: AlertDialog = builder.create()
        appDescription.setCancelable(false) // Will not allow user to cancel after clicking on remaining screen area
        appDescription.show()  // show the dialog to UI
    }
}