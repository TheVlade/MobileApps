package com.example.mobileApps

class DataBaseClass {
    companion object {
        private val email_list = ArrayList<String>()
        private val password_list = ArrayList<String>()

        init {
            email_list.add("test@te.st")
            password_list.add("1234")
        }

        fun get_emails(): ArrayList<String> {
            return email_list
        }


        fun check_credentials(email: String, password: String): Boolean{
            val emailIndex = email_list.indexOf(email)
            return password == password_list.get(emailIndex)
        }

    }
}