package com.example.synapse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.synapse.databinding.ActivityMainBinding
import com.example.synapse.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var b: ActivitySecondBinding
    var tlf = ""
    var email = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(b.root)
        getSpinner(b.spinner)
        getSpinner2(b.spinner2)
        b.bSig.setOnClickListener {
            val myIntent4 = Intent(this,ThirdActivity::class.java)
            startActivity(myIntent4)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menusecondact, menu)
        return true
    }
    fun getSpinner(spinner: Spinner){
        var userSelect = ""
        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.Telefono,
            android.R.layout.simple_spinner_item)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                userSelect = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@SecondActivity, userSelect, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                userSelect = "No ha habido selección"
                Toast.makeText(this@SecondActivity, userSelect, Toast.LENGTH_SHORT).show()
            }
        }
        //Sustituir 'year' por la variable global donde se recoge el valor
        tlf = userSelect
    }
    fun getSpinner2(spinner: Spinner){
        var userSelect = ""
        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.Email,
            android.R.layout.simple_spinner_item)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                userSelect = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@SecondActivity, userSelect, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                userSelect = "No ha habido selección"
                Toast.makeText(this@SecondActivity, userSelect, Toast.LENGTH_SHORT).show()
            }
        }
        //Sustituir 'year' por la variable global donde se recoge el valor
        email = userSelect
    }
}