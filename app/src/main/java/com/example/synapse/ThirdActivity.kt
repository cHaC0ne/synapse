package com.example.synapse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.synapse.SharedPreferences.Companion.prefs
import com.example.synapse.databinding.ActivitySecondBinding
import com.example.synapse.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var b: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(b.root)
        initUi()

        b.bVolver.setOnClickListener {
            val myIntentThird = Intent(this, MainActivity::class.java)
            startActivity(myIntentThird)
        }


        }
    fun initUi(){
        b.bVolver.setOnClickListener {
            prefs.wipeData()
            onBackPressed()
        }
        val realName = prefs.getRealName()
        val username = prefs.getUserName()
        val email = prefs.geteMail()
        val pass = prefs.getPass1()
        val repass = prefs.getRePass1()
        val gender = prefs.getCheckGender()
        b.tvInfo.text = "$realName \n $username \n $email, \n $pass, \n $repass, \n $gender "
//        Toast.makeText(this@ThirdActivity, "$realName", Toast.LENGTH_SHORT).show()



        }
}


