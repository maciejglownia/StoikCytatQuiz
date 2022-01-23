package pl.glownia.maciej.stoikcytatquiz

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
        val contact: LinearLayout = findViewById(R.id.ll_contact)
        contact.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:maciej.k.glownia@gmail.com")
            }
            startActivity(Intent.createChooser(emailIntent, "Send feedback"))
        }
    }
}