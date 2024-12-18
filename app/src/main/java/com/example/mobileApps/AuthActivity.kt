package com.example.mobileApps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileApps.fragments.authActivity.LoginFragment
import com.example.mobileApps.fragments.authActivity.RegisterFragment

class AuthActivity: AppCompatActivity(), LoginFragment.OnLoginClickListener, RegisterFragment.OnRegisterClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)

        supportFragmentManager.beginTransaction()
            .replace(R.id.auth_fragments, LoginFragment())
            .commit()

    }

    override fun onRegisterNowClicked() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.auth_fragments, RegisterFragment())
            .commit()
    }

    override fun onLogInClicked() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.auth_fragments, LoginFragment())
            .commit()
    }

    override fun onRegisterNextClicked() {
        navigateToActivity(MainActivity::class.java)
    }

    override fun onLoginNextClicked() {
        navigateToActivity(MainActivity::class.java)
    }

    private fun <T> AppCompatActivity.navigateToActivity(targetActivity: Class<T>) {
        val intent = Intent(this, targetActivity)
        startActivity(intent)
        finish()
    }
}