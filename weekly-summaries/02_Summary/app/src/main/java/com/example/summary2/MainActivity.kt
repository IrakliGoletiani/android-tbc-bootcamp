package com.example.summary2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.summary2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val users = arrayListOf<User>()

        val etFirstName = binding.etFirstName.text
        val etLastName = binding.etLastName.text
        val etAge = binding.etAge.text
        val etEmail = binding.etEmail.text

        var removedUsers = 0

        binding.btnAdd.setOnClickListener {
            if (etFirstName.isNotEmpty() && etLastName.isNotEmpty() && etAge.isNotEmpty() && etEmail.isNotEmpty()) {
                val user = User(
                    etFirstName.toString(),
                    etLastName.toString(),
                    etAge.toString().toInt(),
                    etEmail.toString()
                )

                if (users.contains(user)) {
                    makeToast("User Already Exists")
                    setActionText(false)
                } else {
                    users.add(user)
                    setActionText(true)

                    binding.tvActiveUsersResult.text = users.size.toString()
                    makeToast("User Added Successfully")
                }
            } else {
                makeToast("Fill All Fields")
                setActionText(false)
            }
        }

        binding.btnRemove.setOnClickListener {
            if (etFirstName.isNotEmpty() && etLastName.isNotEmpty() && etAge.isNotEmpty() && etEmail.isNotEmpty()) {
                val user = User(
                    etFirstName.toString(),
                    etLastName.toString(),
                    etAge.toString().toInt(),
                    etEmail.toString()
                )

                if (users.contains(user)) {
                    users.remove(user)
                    makeToast("User Deleted Successfully")
                    setActionText(true)

                    removedUsers++
                    binding.tvRemovedUsersResult.text = removedUsers.toString()
                    binding.tvActiveUsersResult.text = users.size.toString()
                } else {
                    makeToast("User Doesn't Exists")
                    setActionText(false)
                }
            } else {
                makeToast("Fill All Fields")
                setActionText(false)
            }
        }

        binding.btnUpdate.setOnClickListener {
            if (etFirstName.isNotEmpty() && etLastName.isNotEmpty() && etAge.isNotEmpty() && etEmail.isNotEmpty()) {
                val user = User(
                    etFirstName.toString(),
                    etLastName.toString(),
                    etAge.toString().toInt(),
                    etEmail.toString()
                )

                var userHasChanged = false

                users.forEachIndexed { index, element ->
                    if (element.email == user.email) {
                        users[index] = user
                        userHasChanged = true
                    }
                }

                if (userHasChanged) {
                    makeToast("User Info with ${user.email} has been updated")
                    setActionText(true)
                } else {
                    makeToast("User with ${user.email} isn't registered")
                    setActionText(false)
                }

            } else {
                makeToast("Fill All Fields")
                setActionText(false)
            }
        }

    }

    private fun setActionText(isSuccess: Boolean) {
        if (isSuccess) {
            binding.tvActionResult.text = "Success"
            binding.tvActionResult.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.success_color
                )
            )
        } else {
            binding.tvActionResult.text = "Error"
            binding.tvActionResult.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.error_color
                )
            )
        }
    }

    private fun makeToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}