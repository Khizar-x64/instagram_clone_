package com.example.instagram_clone_

import android.os.Bundle
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(activity_login_page, container, false)
        val fragment=Signup_page()
        val AccountBtn =view.findViewById<Button>(R.id.btn_create_account)
        AccountBtn.setOnClickListener()
        {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_Fragement_Container, fragment)
                .commit()
        }

        val login_btn:Button=view.findViewById(R.id.btn_login)

        val Email_or_phone_num:String= view.findViewById<EditText>(R.id.email_or_phone)
            .text.toString().trim()//email or phone store variable

        val password:String=view.findViewById<EditText>(R.id.password)
            .text.toString().trim()//password store variable

        val  firebaseAuth = FirebaseAuth.getInstance()

        login_btn.setOnClickListener()
        {
            if(Email_or_phone_num.isNotEmpty()&&password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(Email_or_phone_num, password)
                    .addOnSuccessListener {
                        if (it.user?.isEmailVerified == true) {
                            Toast.makeText(
                                requireContext(),
                                "Login Successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(requireContext(), "Invalid Email", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }.addOnFailureListener {

                        Toast.makeText(requireContext(), "Login Failed", Toast.LENGTH_SHORT).show()
                    }

            }
            else {
                Toast.makeText(requireContext(), "Invalid Email", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

}