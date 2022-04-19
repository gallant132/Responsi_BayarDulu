package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val email = findViewById<EditText>(R.id.etemail)
        val password = findViewById<EditText>(R.id.password)
        val confirmpassword = findViewById<EditText>(R.id.confirmpassword)
        val register = findViewById<Button>(R.id.btnregister)

        val actionBar = supportActionBar
        actionBar?.setTitle("Register Account")
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        register.setOnClickListener {

            if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
                email.error = "Masukan Email dengan Benar"
            }
            else if (password.length()<5){
                password.error = "Password tidak boleh kurang dari 5 huruf"
            }
            else{
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,"Berhasil Daftar", Toast.LENGTH_SHORT).show()

            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}