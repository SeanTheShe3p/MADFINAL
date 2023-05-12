package com.example.finasprintsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var loginUsername: EditText
    private lateinit var loginPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: Button

    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


        loginUsername = findViewById(R.id.loginUsername)
        loginPassword = findViewById(R.id.loginPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnSignUp = findViewById(R.id.btnSignup)

        mAuth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener{
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }


        btnLogin.setOnClickListener {
            val username = loginUsername.text.toString()
            val password = loginPassword.text.toString()

            login(username, password)
        }




    }



    private fun login(username:String, password:String){
        //create user
        mAuth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
//                    Log.d(TAG, "signInWithEmail:success")
//                    val user = auth.currentUser
//                    updateUI(user)
                    //code for logging in the user

                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
//                    Log.w(TAG, "signInWithEmail:failure", task.exception)
//                    Toast.makeText(
//                        baseContext,
//                        "Authentication failed.",
//                        Toast.LENGTH_SHORT,
//                    ).show()
//                    updateUI(null)
                    Toast.makeText(this@MainActivity, "User does not exist", Toast.LENGTH_SHORT).show()
                }
            }

    }
}