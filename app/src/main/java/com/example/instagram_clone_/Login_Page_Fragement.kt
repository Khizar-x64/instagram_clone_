package com.example.instagram_clone_

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.instagram_clone_.R.layout.activity_login_page
import com.google.firebase.auth.FirebaseAuth

class Login_Page_Fragement : Fragment(activity_login_page) {

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(activity_login_page, container, false)
        val AccountBtn =view.findViewById<Button>(R.id.btn_create_account)
        AccountBtn.setOnClickListener()
        {
            val fragment=Signup_page_Fragement()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_Fragement_Container, fragment)
                .commit()
        }
        val login_btn:Button=view.findViewById(R.id.btn_login)

        login_btn.setOnClickListener() {
            firebaseAuth = FirebaseAuth.getInstance()
            performLogin(view,firebaseAuth)
        }
        return view
    }
   /* public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null) {
            Toast.makeText(requireContext(), "yp!", Toast.LENGTH_SHORT).show()
            relod()
        }
    }*/


    private fun performLogin(view: View, firebaseAuth: FirebaseAuth) {
        val emailOrPhone = view.findViewById<EditText>(R.id.email_or_phone)
            .text.toString().trim()
        val password = view.findViewById<EditText>(R.id.password)
            .text.toString().trim()
       /* firebaseAuth.signInWithEmailAndPassword(emailOrPhone, password)
    .addOnCompleteListener() { task ->
        if (task.isSuccessful) {
            // Sign in success, update UI with the signed-in user's information
            Log.d(TAG, "signInWithEmail:success")
            val user = firebaseAuth.currentUser

        } else {
            // If sign in fails, display a message to the user.
            Log.w(TAG, "signInWithEmail:failure", task.exception)
            Toast.makeText(
                    null,
                "Authentication failed.",
                Toast.LENGTH_SHORT,
            ).show()

        }*/

        if (emailOrPhone.isNotEmpty() && password.isNotEmpty()) {
            firebaseAuth.signInWithEmailAndPassword(emailOrPhone, password)
                .addOnSuccessListener {
                    if (it.user?.isEmailVerified == true) {
                        Toast.makeText(requireContext(), "Login Successfully", Toast.LENGTH_SHORT).show()

                    } else {
                        Toast.makeText(requireContext(), "Please verify your email", Toast.LENGTH_SHORT).show()
                    }
                }.addOnFailureListener {
                    Toast.makeText(requireContext(), "Login Failed: ${it.message}", Toast.LENGTH_SHORT).show()
                }
        } else {
            Toast.makeText(requireContext(), "Please enter email/phone and password", Toast.LENGTH_SHORT).show()
        }
    }
}