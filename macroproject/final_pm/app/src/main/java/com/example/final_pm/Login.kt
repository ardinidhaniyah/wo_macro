package com.example.final_pm

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class Login : AppCompatActivity() {
    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var history : TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data: Intent? = result.data
            val returnString:String? = data?.getStringExtra("history")
            history.text =returnString

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username = findViewById(R.id.et_username)
        password = findViewById(R.id.Password)

        val bundle :Bundle? = intent.extras
        if (bundle != null){
            username.setText(bundle.getString("username"))
            password.setText(bundle.getString("password"))
        }

        val buttonlogin = findViewById<Button>(R.id.buttonlg)
        buttonlogin.setOnClickListener(View.OnClickListener {

            val intent = Intent(this@Login, HomeActivity :: class.java)
            intent.putExtra("user", user(username.text.toString(),password.text.toString()))
            resultLauncher.launch(intent)

        })

        val openLinkButton3 = findViewById<Button>(R.id.googlelg)

        openLinkButton3.setOnClickListener {
            val url = "https://accounts.google.com/v3/signin/identifier?authuser=0&continue=https%3A%2F%2Fmyaccount.google.com%2F&ec=GAlAwAE&hl=in&service=accountsettings&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S-1023111507%3A1697637343355129&theme=glif"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        val openLinkButton4 = findViewById<Button>(R.id.facebooklg)

        openLinkButton4.setOnClickListener {
            val url = "https://id-id.facebook.com/login/device-based/regular/login/?login_attempt=1"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }


    }
}