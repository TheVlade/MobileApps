package com.example.mobileApps

import android.content.Intent
import android.os.Bundle
import com.google.android.material.textview.MaterialTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.example.mobileApps.DataBaseClass.Companion.get_emails
import com.example.mobileApps.DataBaseClass.Companion.check_credentials
import com.example.mobileApps.Functions.Companion.navigateToActivity

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val emailLayout: TextInputLayout = findViewById(R.id.email_layout)
        val passwordLayout: TextInputLayout = findViewById(R.id.password_layout)
        val emailText: TextInputEditText = findViewById(R.id.email_text)
        val passwordText: TextInputEditText = findViewById(R.id.password_text)
        val nextButton: MaterialButton = findViewById(R.id.next_button)
        nextButton.setOnClickListener {
            if(get_emails().contains(emailText.text.toString())){
                emailLayout.error = null
                if(check_credentials(emailText.text.toString(), passwordText.text.toString())){
                    navigateToActivity(MainActivity::class.java);
                } else {
                    passwordLayout.error = "Password is wrong or invalid"
                }
            } else {
                emailLayout.error =  "Email is invalid"
            }
        }



        val registerTextButton: MaterialTextView = findViewById(R.id.register)
        registerTextButton.setOnClickListener {
            navigateToActivity(RegisterActivity::class.java)
        }
    }
}