package com.example.m2test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {
    lateinit var full_name: EditText
    lateinit var user_name: EditText
    lateinit var email: EditText
    lateinit var phone: EditText
    lateinit var Cpassword: TextInputEditText
    lateinit var password: TextInputEditText
    lateinit var checkbox: CheckBox

    lateinit var full_name_error: TextView
    lateinit var user_name_error: TextView
    lateinit var email_error: TextView
    lateinit var phone_error: TextView
    lateinit var error_password: TextInputLayout
    lateinit var Cerror_password: TextInputLayout
    lateinit var checkbox_error: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        full_name = findViewById(R.id.full_name)
        user_name = findViewById(R.id.user_name)
        email = findViewById(R.id.email)
        phone = findViewById(R.id.phone_no)
        password = findViewById(R.id.password)
        Cpassword = findViewById(R.id.Cpassword)
        checkbox = findViewById(R.id.checkbox)

        full_name_error = findViewById(R.id.full_name_error_textView)
        user_name_error = findViewById(R.id.user_name_error_textView)
        email_error = findViewById(R.id.email_error_textView)
        phone_error = findViewById(R.id.phone_no_error_textView)
        error_password = findViewById(R.id.error_password)
        Cerror_password = findViewById(R.id.Cerror_password)
        checkbox_error = findViewById(R.id.checkbox_error)

        val back_btn = findViewById<ImageView>(R.id.back_button)
        val login = findViewById<TextView>(R.id.login_bck)
        val signUp = findViewById<Button>(R.id.sign_up)


        back_btn.setOnClickListener {
            finish()
        }

        login.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        signUp.setOnClickListener {

            var full_name = full_name.text.toString()
            full_name_error.text = ""

            var user_name = user_name.text.toString()
            user_name_error.text = ""

            var email = email.text.toString()
            email_error.text = ""

            var phone = phone.text.toString()
            phone_error.text = ""

            var password = password.text.toString()
            error_password.helperText = ""

            var Cpassword = Cpassword.text.toString()
            Cerror_password.helperText = ""

            checkbox_error.text = ""


            if (full_name.isEmpty()) {
                full_name_error.text = "*Please enter your name"

            } else if (full_name.length < 2) {
                full_name_error.text = "*Please enter valid name(must be atleast 2 characters)"

            } else if (!isNameValidFormate(full_name)) {
                full_name_error.text = "*Please enter valid full name"

            }else if (user_name.isEmpty()) {
                user_name_error.text = "*Please enter your name"

            } else if (user_name.length < 2) {
                user_name_error.text = "*Please enter valid name(must be atleast 2 characters)"


            }else if (email.isEmpty()) {
                email_error.text = "*Please enter valid email"

            } else if (!checkEmail(email)) {
                email_error.text = "*Please enter valid email address"

            } else if (phone.isEmpty()) {
                phone_error.text = "*Please enter your mobile number"

            } else if (!(phone.length == 10)) {
                phone_error.text = "*Please enter valid mobile number"

            } else if (password.isEmpty()) {
                error_password.helperText = "*Please enter your password"

            } else if (password.length < 6) {
                error_password.helperText = "*Please enter password more than 6 digits"

            } else if (!isValidPasswordFormat(password)) {
                error_password.helperText = "*Please enter your valid password"

            } else if (Cpassword.isEmpty()) {
                Cerror_password.helperText = "*Please enter confirm password"

            } else if (!Cpassword.equals(password)) {
                Cerror_password.helperText = "*Both password should match"

            }else if (checkbox.isChecked==false){
                checkbox_error.text = "*Accepting checkbox is neccessary"

            }else{

                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }

        fun isNameValidFormate(name: String): Boolean {
            val nameREGEX = Pattern.compile("^[aA-zZ\\s]+\$");
            return nameREGEX.matcher(name).matches()
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

        fun isValidPasswordFormat(password: String): Boolean {
            val passwordREGEX = Pattern.compile(
                "^" +
                        "(?=.*[0-9])" +         //at least 1 digit
                        "(?=.*[a-z])" +         //at least 1 lower case letter
                        "(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z])" +      //any letter
                        "(?=.*[@#$%^&+=])" +    //at least 1 special character
                        "(?=\\S+$)" +           //no white spaces
                        ".{6,}" +               //at least 8 characters
                        "$"
            );
            return passwordREGEX.matcher(password).matches()
        }
    }
