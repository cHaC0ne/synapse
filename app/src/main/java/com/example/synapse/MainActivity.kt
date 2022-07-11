package com.example.synapse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.*
import com.example.synapse.SharedPreferences.Companion.prefs
import com.example.synapse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        var genero = "Female"
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        initUI()
        checkUserValues()

        b.bRegister.setOnClickListener {
            var myIntent = Intent(this, SecondActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menumainac, menu)
        return true
    }

    fun initUI(){
        b.bRegisterWF.setOnClickListener {
            accessSharedPreferences()
            var myIntetFace = Intent(this,ThirdActivity::class.java)

            startActivity(myIntetFace)
        }
    }
    fun checkUserValues(){
        if(prefs.getRealName().isNotEmpty()){
            goAccess()
        }
    }
    fun accessSharedPreferences(){
        if (b.etFullName.text.toString().isNotEmpty()){
            prefs.saveRealName(b.etFullName.text.toString())
            prefs.saveUserName(b.etUsername.text.toString())
            prefs.saveCheckGender(b.rbFemale.toString())
            prefs.saveCheckGender(b.rbMale.toString())
            prefs.savePass(b.etPass.text.toString())
            prefs.saveRePass(b.etPass2.text.toString())
            prefs.saveEmail(b.etEmail.text.toString())
            goAccess()
        }else{
            Toast.makeText(this, "Debe rellenar el nombre", Toast.LENGTH_SHORT).show()
        }
    }
    private fun goAccess(){
        prefs.printValues(this)
        //startActivity(Intent(this, SecondActivity::class.java))
    }
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rbFemale ->
                    if (checked) {
                        prefs.saveCheckGender("Femenino")
                        Toast.makeText(this, prefs.getCheckGender(), Toast.LENGTH_SHORT).show()
                        // Pirates are the best
                    }
                R.id.rbMale ->
                    if (checked) {
                        prefs.saveCheckGender("Masculino")
                        // Ninjas rule
                    }
            }
        }

        Toast.makeText(this, prefs.getCheckGender(), Toast.LENGTH_SHORT).show()
    }
}

