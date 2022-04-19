package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val tvregister = findViewById(R.id.tvregister) as TextView
        val tvforgot = findViewById(R.id.tvforgot) as TextView
        val email = findViewById<EditText>(R.id.etemail)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.btnlogin)

        login.setOnClickListener {
            if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
                email.error = "Masukan Email dengan Benar"
            }
            else if (password.length()<5){
                password.error = "Password tidak boleh kurang dari 5 huruf"
            }
            else {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,"Berhasil Login", Toast.LENGTH_SHORT).show()
            }
        }

        tvforgot.setOnClickListener {
            val intent = Intent(this,RecoveryActivity::class.java)
            startActivity(intent)
        }

        tvregister.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }


    }
}