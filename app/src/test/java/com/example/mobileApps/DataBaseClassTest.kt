package com.example.mobileApps

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import com.example.mobileApps.DataBaseClass.Companion.check_credentials

class DataBaseClassTest {

    @Test
    fun validCredentials_True() {
        assertEquals(true, check_credentials("test@te.st", "1234"))
    }

    @Test
    fun invalidPassword_False() {
        assertEquals(false, check_credentials("test@te.st", "2211"))
    }
}