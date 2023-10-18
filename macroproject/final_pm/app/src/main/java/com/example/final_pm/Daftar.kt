package com.example.final_pm

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.net.URI

class Daftar : AppCompatActivity() {
    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var confirmpass : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        username = findViewById(R.id.ed_username)
        password = findViewById(R.id.PasswordDF)
        confirmpass = findViewById(R.id.confirmPassword3)

        val buttonregister = findViewById<Button>(R.id.buttondf)
        buttonregister.setOnClickListener(View.OnClickListener {

            val bundle = Bundle()
            bundle. putString("username", username.text.toString())
            bundle. putString("password", password.text.toString())

            val intent = Intent(this@Daftar, Login :: class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        })

        val openLinkButton = findViewById<Button>(R.id.googledf)

        openLinkButton.setOnClickListener {
            val url = "https://accounts.google.com/v3/signin/identifier?authuser=0&continue=https%3A%2F%2Fmyaccount.google.com%2F&ec=GAlAwAE&hl=in&service=accountsettings&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S-1023111507%3A1697637343355129&theme=glif"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        val openLinkButton2 = findViewById<Button>(R.id.facebookdf)

        openLinkButton2.setOnClickListener {
            val url = "https://id-id.facebook.com/login/device-based/regular/login/?login_attempt=1"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

    }
}