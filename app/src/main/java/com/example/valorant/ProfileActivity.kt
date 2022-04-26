package com.example.valorant

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.valorant.databinding.ActivityProfileBinding
import com.example.valorant.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var actionBar: ActionBar
    private lateinit var progressDialog: ProgressDialog
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        actionBar = supportActionBar!!
        actionBar.title = "Profile"

        // init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.logoutButton.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }

        binding.mainButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun checkUser() {
        // check user in logged in or not
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null) {
            val email = firebaseUser.email
            binding.emailText.text = email
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}