package com.example.synapse

import android.content.Context
import android.widget.Toast

class Prefs(val context : Context) {
    val DATABASE = "MyDB"
    val NAME = "Name"
    val USER_NAME = "UserName"
    val eMail = "E-mail"
    val Pass = "Pass"
    val RePass = "Repass"
    val CHECK_GENDER = "Check_Gender"

    val storage = context.getSharedPreferences(DATABASE, Context.MODE_PRIVATE)

    fun printValues(context: Context){
        Toast.makeText(context, storage.all.toString(), Toast.LENGTH_SHORT).show()

    }

    fun saveUserName(username: String) {
        storage.edit().putString(USER_NAME, username).apply()
    }

    fun saveRealName(rName: String) {
        storage.edit().putString(NAME, rName).apply()
    }

    fun saveEmail(email: String) {
        storage.edit().putString(eMail, email).apply()
    }

    fun saveCheckGender(gender: String) {
        storage.edit().putString(CHECK_GENDER, "").apply()
    }

    fun savePass(pass: String) {
        storage.edit().putString(Pass, pass).apply()
    }

    fun saveRePass(Rpass: String) {
        storage.edit().putString(RePass, Rpass).apply()
    }


    fun getRealName(): String {
        return storage.getString(NAME, "")!!
    }

    fun getCheckGender(): String {
        return storage.getString(CHECK_GENDER, "false")!!
    }

    fun wipeData() {
        storage.edit().clear().apply()
    }

    fun getUserName(): String {
        return storage.getString(USER_NAME, "")!!
    }

    fun geteMail(): String {
        return storage.getString(eMail, "")!!
    }

    fun getPass1(): String {
        return storage.getString(Pass, "")!!
    }

    fun getRePass1(): String {
        return storage.getString(RePass, "")!!
    }
}
