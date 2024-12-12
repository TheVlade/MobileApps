package com.example.mobileApps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mobileApps.DataBaseClass.Companion.get_emails
import com.example.mobileApps.DataBaseClass.Companion.check_credentials
import com.example.mobileApps.CredentialsManager.Companion.check_email
import com.example.mobileApps.CredentialsManager.Companion.check_password
import com.example.mobileApps.Functions.Companion.navigateToActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class RegisterActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

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
            if(!get_emails().contains(emailText.text.toString())){
                emailLayout.error = null

                if(check_email(emailText.text.toString())) {
                    emailLayout.error = null

                    if (check_password(passwordText.text.toString())){
                        navigateToActivity(LogInActivity::class.java);
                    } else {
                        passwordLayout.error = "Password is invalid"
                    }
                } else {
                    emailLayout.error =  "Email is invalid"
                }
            } else {
                emailLayout.error =  "Email is already taken"
            }
        }




        val buttonLogIn: MaterialTextView = findViewById(R.id.log_in)
        buttonLogIn.setOnClickListener {
            navigateToActivity(LogInActivity::class.java);

        }
    }
}