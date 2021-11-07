package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences

class SplashActivity : AppCompatActivity() {

    //instancia a classe usa seus metodos
    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences(this)


        val button: Button = findViewById(R.id.btnSave)
        button.setOnClickListener {
            handleSave()
        }

        verifyName()

    }

    private fun verifyName() {
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

        if (name != "") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun handleSave() {
        val name = findViewById<EditText>(R.id.inputName).text.toString()

        if (name != "") {
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "O campo nome não pode ser vazio!!!", Toast.LENGTH_SHORT).show()
        }
    }
}