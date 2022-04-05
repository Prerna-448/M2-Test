package com.example.m2test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class Login : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var error_password: TextInputLayout
    lateinit var password: TextInputEditText
    lateinit var checkbox:CheckBox

    lateinit var email_error: TextView
    lateinit var checkbox_error:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.email)
        error_password = findViewById(R.id.error_password)
        email_error = findViewById(R.id.email_error)
        password = findViewById(R.id.password)
        checkbox= findViewById(R.id.checkbox)
        checkbox_error= findViewById(R.id.checkbox_error)

        val signUp = findViewById<TextView>(R.id.sign_up)
        val login = findViewById<TextView>(R.id.login_btn)


        signUp.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        login.setOnClickListener {


            var email = email.text.toString()
            email_error.text = ""

            var password = password.text.toString()
            error_password.helperText = ""

            checkbox_error.text=""

            //val intent1 = Intent(this,MainActivity::class.java)
            //startActivity(intent1)
            if (email.isEmpty()) {
                email_error.text = "*Please enter your email address"

            } else if (!checkEmail(email)) {
                email_error.text = "*Please enter your valid email address"

            } else if (password.isEmpty()) {
                error_password.helperText = "*Please enter your password"


            } else if (password.length < 6) {
                error_password.helperText = "*Enter your password atleast 6 characters"

            }else if(checkbox.isChecked==false){
                checkbox_error.text="*Accepting checkbox is neccessary"
            }else {

                val intent1 = Intent(this, MainActivity::class.java)
                startActivity(intent1)
            }
        }
    }

    private fun checkEmail(email: String): Boolean {

        val EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()

    }


}