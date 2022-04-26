package com.example.valorant

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.valorant.databinding.ActivityLoginBinding
import com.example.valorant.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var actionBar: ActionBar
    private lateinit var progressDialog: ProgressDialog
    private lateinit var firebaseAuth: FirebaseAuth

    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        // Configure Actionbar, //enable back button
        actionBar = supportActionBar!!
        actionBar.title = "Sign Up"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        // configure progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("Creating account...")
        progressDialog.setCanceledOnTouchOutside(false)

        // init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()

        // handle click, begin sign up
        binding.signupButton.setOnClickListener {
            validateData()
        }
    }

    private fun validateData() {
        email = binding.emailTextField.editText?.text.toString().trim()
        Log.d("email", email)
        password = binding.passwordTextField.editText?.text.toString().trim()

        // validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailTextField.error = "Invalid email format"
        } else if (TextUtils.isEmpty(password)) {
            binding.passwordTextField.error = "Please enter your password"
        } else if (password.length < 6) {
            binding.passwordTextField.error = "Password must at least 6 characters long"
        } else {
            // data is valid, continue sign up
            firebaseSignUp()
        }
    }

    private fun firebaseSignUp() {
        // show progress
        progressDialog.show()

        // create account
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                // sign up success
                progressDialog.dismiss()

                // get current user
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this, "Account created with email $email", Toast.LENGTH_SHORT).show()

                // open profile
                startActivity(Intent(this, ProfileActivity::class.java))
                finish()
            }
            .addOnFailureListener { e ->
                // sign up failed
                progressDialog.dismiss()
                Toast.makeText(this, "Sign up failed due to ${e.message}", Toast.LENGTH_SHORT)
                    .show()
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // go back to previous activity, when back button of actionbar clicked
        return super.onSupportNavigateUp()
    }
}