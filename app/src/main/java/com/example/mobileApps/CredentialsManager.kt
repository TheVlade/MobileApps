package com.example.mobileApps

class CredentialsManager {
    companion object {
        fun check_email(email: String): Boolean {
            val emailExpression = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
            if (email.matches(emailExpression.toRegex())){
                return true
            }
            else {
                return false
            }
        }

        fun check_password(password: String): Boolean {
            if (password.isNotEmpty()) {
                return true
            }
            else {
                return false
            }
        }
    }
}