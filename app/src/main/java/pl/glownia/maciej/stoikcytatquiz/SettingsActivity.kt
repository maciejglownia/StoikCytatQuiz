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

        // Set up button to open lepiejteraz.pl - website of Rados??aw Budnicki - about stoic life
        val lepiejTerazButton: LinearLayout = findViewById(R.id.ll_lepiej_teraz)
        lepiejTerazButton.setOnClickListener {
            showDialogToAskUserIfWantsToGoToPolishPodcastAboutStoicism()
        }

        // Set up button to open Google Play Store - place to get my other application Wygraj Dzie??
        val wygrajDzienApp: LinearLayout = findViewById(R.id.ll_wygraj_dzien)
        wygrajDzienApp.setOnClickListener {
            showDialogToAskUserIfWantsToGoToGooglePlayStoreForToCheckWygrajDzienApplication()
        }
    }

    private fun showDescriptionDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("O aplikacji")
        builder.setMessage(
            "Aplikacja zosta??a stworzona z my??l?? o wszystkich, kt??rzy chc?? pozna?? lub " +
                    "utrwali?? m??dro??ci czterech znanych stoik??w: Epikteta z Hierapolis, " +
                    "Marka Aureliusza, Seneki M??odszego, Zenona z Kition." +
                    "\n\nAplikacja zosta??a zaprojektowana w formie quizu sk??adaj??cego si?? " +
                    "z 1, 10 lub 40 pyta??. U??ytkownik decyduje na ile pyta?? chce odpowiedzie??. " +
                    "W bazie jest ????cznie 100 cytat??w. W zale??no??ci od osi??gni??tego wyniku u??ytkownik " +
                    "otrzymuje na koniec trofeum w postaci wie??ca laurowego. " +
                    "\nKolory wie??ca (kolejno od najwi??kszej ilo??ci punkt??w, procent poprawnych odpowiedzi):" +
                    "\n\n 1. Z??oty -> 100%" +
                    "\n 2. Srebrny -> 80 - 99%" +
                    "\n 3. Br??zowy -> 60 - 79%" +
                    "\n 4. Oliwkowy -> 40 - 59%" +
                    "\n 5. Czarny -> 0 - 39%" +
                    "\n\nMam nadziej??, ??e ten quiz b??dzie nie tylko dobr?? zabaw??, ale tak??e pozwoli " +
                    "lepiej zapami??ta?? ponadczasowe my??li stoickie." +
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
        builder.setTitle("Drogi Go??ciu!") // Dear Guest!
        // Description to inform user that they can go to the website or stay in the application
        builder.setMessage(
            "Je??li chcesz zg????bi?? filozofi?? stoick??, " +
                    "koniecznie poznaj Radka Budnickiego i jego podcast ''Lepiej Teraz'' klikaj??c " +
                    "''ZABIERZ MNIE'' poni??ej. \nTam otrzymasz mn??wstwo warto??ciowych tre??ci na ten temat. " +
                    "Jestem pewien, ??e nie b??dzie to wizyta na chwil??. " +
                    "\nJe??li natomiast chcesz pozosta?? w aplikacji wybierz ''ZOSTAJ??''." +
                    "\n\n\nWybieraj??c ''ZABIERZ MNIE'' jednocze??nie wyra??asz zgod?? na przeniesienie Ci?? do " +
                    "strony internetowej podcastu ''Lepiej Teraz''."
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
        builder.setNegativeButton("ZOSTAJ??") // I'm staying (in the application)
        { dialogInterface, _ ->
            dialogInterface.dismiss() // Dialog will be dismissed
        }
        val appDescription: AlertDialog = builder.create()
        appDescription.setCancelable(false) // Will not allow user to cancel after clicking on remaining screen area
        appDescription.show()  // show the dialog to UI
    }

    // Need this method to let user decide to go to Google Play Store or stay in the application
    private fun showDialogToAskUserIfWantsToGoToGooglePlayStoreForToCheckWygrajDzienApplication() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Drogi Go??ciu!") // Dear Guest!
        // Description about if user wants to go to the Google Play Store for the app or staying here
        builder.setMessage(
            "Je??eli opr??cz m??dro??ci i spokoju ducha, poszukujesz tak??e sposobu na skuteczne " +
                    "osi??ganie zamierzonych cel??w, zapraszam Ci?? do skorzystania z mojej aplikacji " +
                    "''Wygraj Dzie??''." +
                    "\nAplikacja umo??liwa tworzenie zada??, kt??re pozwol?? Ci czyni?? post??py " +
                    "w obszarach zdrowego cia??a, ducha i finans??w. " +
                    "Wybierz ''ZABIERZ MNIE'' by przej???? do aplikacji ''Wygraj Dzie??'' lub " +
                    "''ZOSTAJ??'', aby pozosta?? w obecnej." +
                    "\n\n\nWybieraj??c ''ZABIERZ MNIE'' jednocze??nie wyra??asz zgod?? na przeniesienie Ci?? do " +
                    "Google Play Store, gdzie mo??esz pobra?? aplikacj?? ''Wygraj Dzie??''."
        )
        builder.setPositiveButton("ZABIERZ MNIE") // Take me (to the Google Play Store)
        { dialogInterface, _ ->
            dialogInterface.dismiss()
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=pl.glownia.maciej.wygrajdzien")
            )
            startActivity(browserIntent)
        }
        builder.setNegativeButton("ZOSTAJ??") // I'm staying (in the application)
        { dialogInterface, _ ->
            dialogInterface.dismiss() // Dialog will be dismissed
        }
        val appDescription: AlertDialog = builder.create()
        appDescription.setCancelable(false) // Will not allow user to cancel after clicking on remaining screen area
        appDescription.show()  // show the dialog to UI
    }
}