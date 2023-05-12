package com.example.finasprintsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signup : AppCompatActivity() {

    private lateinit var loginUsername: EditText
    private lateinit var loginPassword: EditText
    private lateinit var loginPassword2: EditText
    private lateinit var cleanDate: EditText
    private lateinit var moveinDate: EditText
    private lateinit var position: EditText

    private lateinit var btnSignup: Button
    private lateinit var btnBack: Button

    private lateinit var mAuth: FirebaseAuth

    private lateinit var mDBRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        supportActionBar?.hide()
        mAuth = FirebaseAuth.getInstance()

        loginUsername = findViewById(R.id.loginUsername)
        loginPassword = findViewById(R.id.loginPassword)
        loginPassword2 = findViewById(R.id.loginPassword2)
        cleanDate = findViewById(R.id.cleanDate)
        moveinDate = findViewById(R.id.moveinDate)
        position = findViewById(R.id.position)

        btnSignup = findViewById(R.id.btnSignup)
        btnBack = findViewById(R.id.btnBack)

        btnSignup.setOnClickListener {
            val username = loginUsername.text.toString()
            val password = loginPassword.text.toString()
            val cleanDate = cleanDate.text.toString()
            val moveinDate = moveinDate.text.toString()
            val position = position.text.toString()

            signUp(username, password, cleanDate, moveinDate, position)

        }
        btnBack.setOnClickListener{
            val intent = Intent(this@Signup, MainActivity::class.java)
            finish()
            startActivity(intent)
        }



    }

    private fun signUp(username:String, password:String, cleanDate:String, moveinDate:String, position:String){
        //create user
        mAuth.createUserWithEmailAndPassword(username, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
//                    Log.d(TAG, "createUserWithEmail:success")
//                    val user = auth.currentUser
//                    updateUI(user)
                    //code for jumping to home activity
                    addUserToDatabase(username, cleanDate, moveinDate, position, mAuth.currentUser?.uid!!)
                    val intent = Intent(this@Signup, MainActivity2::class.java)
                    finish()
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
//                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
//                    Toast.makeText(
//                        baseContext,
//                        "Authentication failed.",
//                        Toast.LENGTH_SHORT,
//                    ).show()
//                    updateUI(null)
                    Toast.makeText(this@Signup, "Error Occurred", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun addUserToDatabase(username: String, cleanDate: String, moveinDate: String, position: String, uid: String) {
        mDBRef = FirebaseDatabase.getInstance().getReference()

        mDBRef.child("user").child(uid).setValue(User(username, cleanDate, moveinDate, position, uid))
    }
}