package com.example.mobileApps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class Functions {
    companion object {
        fun <T> AppCompatActivity.navigateToActivity(targetActivity: Class<T>) {
            val intent = Intent(this, targetActivity)
            startActivity(intent)
            finish()
        }
    }
}