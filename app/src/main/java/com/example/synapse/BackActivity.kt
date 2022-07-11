package com.example.synapse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.synapse.databinding.ActivityBackBinding


class BackActivity : AppCompatActivity() {
    private lateinit var b: ActivityBackBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityBackBinding.inflate(layoutInflater)
        setContentView(b.root)


//        b.bBack.setOnClickListener {
//            val myIntentBack = Intent (this,MainActivity::class.java)
//            startActivity(myIntentBack)
//        }
    }
}