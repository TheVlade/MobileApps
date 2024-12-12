package com.example.mobileApps

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import com.example.mobileApps.CredentialsManager.Companion.check_email
import com.example.mobileApps.CredentialsManager.Companion.check_password

class CredentialsManagerTest {

    @Test
    fun validPassword_True() {
        assertEquals(false, check_password("pAssWord221"))
    }
    @Test
    fun emptyPassword_False() {
        assertEquals(false, check_password(""))
    }
    @Test
    fun emptyEmail_False() {
        assertEquals(false, check_email(""))
    }
    @Test
    fun wrongEmail_False() {
        assertEquals(false, check_email("thisinnotemail"))
    }
    @Test
    fun properEmail_True() {
        assertEquals(true, check_email("thisis@email.com"))
    }
}