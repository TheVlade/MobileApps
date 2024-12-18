package com.example.mobileApps.fragments.authActivity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobileApps.CredentialsManager
import com.example.mobileApps.DataBaseClass.Companion.check_credentials
import com.example.mobileApps.DataBaseClass.Companion.get_emails
import com.example.mobileApps.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView


class LoginFragment : Fragment() {

    interface OnLoginClickListener {
        fun onRegisterNowClicked()

        fun onLoginNextClicked()
    }

    private var listener: OnLoginClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnLoginClickListener) {
            listener = context
        } else {
            throw ClassCastException("$context must implement OnButtonClickListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val emailLayout: TextInputLayout = view.findViewById(R.id.email_layout)
        val passwordLayout: TextInputLayout = view.findViewById(R.id.password_layout)
        val emailText: TextInputEditText = view.findViewById(R.id.email_text)
        val passwordText: TextInputEditText = view.findViewById(R.id.password_text)
        val nextButton: MaterialButton = view.findViewById(R.id.next_button)
        nextButton.setOnClickListener {
            if(get_emails().contains(emailText.text.toString())){
                emailLayout.error = null
                if(check_credentials(emailText.text.toString(), passwordText.text.toString())){
                    if (listener != null) {
                        listener!!.onLoginNextClicked()
                    }
                } else {
                    passwordLayout.error = "Password is wrong or invalid"
                }
            } else {
                emailLayout.error =  "Email is invalid"
            }
        }

        val registerTextButton: MaterialTextView = view.findViewById(R.id.register)
        registerTextButton.setOnClickListener {
            if (listener != null) {
                listener!!.onRegisterNowClicked()
            }
        }

        return view
    }
}