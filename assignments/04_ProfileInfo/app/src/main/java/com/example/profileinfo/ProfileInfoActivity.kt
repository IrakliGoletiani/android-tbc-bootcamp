package com.example.profileinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.profileinfo.databinding.ActivityProfileInfoBinding
import java.util.regex.Pattern.compile

class ProfileInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            validateFields()
        }
        binding.btnClear.setOnLongClickListener {
            clearFields()
            true
        }
    }

    private fun validateFields() {
        val email = binding.edEmail.text
        val password = binding.edPassword.text
        val userName = binding.edUsername.text
        val firstName = binding.edFirstName.text
        val lastName = binding.edLastName.text
        val age = binding.edAge.text

        if (email.isEmpty() || password.isEmpty() || userName.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || age.isEmpty()) {
            Toast.makeText(this, "Please, fill all fields", Toast.LENGTH_SHORT).show()
        } else if (!isEmailValid(email.toString())) {
            Toast.makeText(this, "Email is not valid", Toast.LENGTH_SHORT).show()
        } else if (binding.edUsername.text.length < 10) {
            Toast.makeText(this, "Username must contain at least 10 characters", Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearFields() {
        binding.edEmail.text.clear()
        binding.edPassword.text.clear()
        binding.edUsername.text.clear()
        binding.edFirstName.text.clear()
        binding.edLastName.text.clear()
        binding.edAge.text.clear()
    }

    private fun isEmailValid(email: String): Boolean {
        val emailRegex = compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        return emailRegex.matcher(email).matches()
    }
}