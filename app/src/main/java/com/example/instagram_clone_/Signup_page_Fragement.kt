package com.example.instagram_clone_

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Signup_page_Fragement.newInstance] factory method to
 * create an instance of this fragment.
 */
class Signup_page_Fragement : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.
        inflate(R.layout.activity_sign_up_page, container, false)
        val firstname=view.findViewById<EditText>(R.id.et_first_name)
            .text.toString().trim()
        val lastname=view.findViewById<EditText>(R.id.et_lastname)
            .text.toString().trim()
        val Email_or_phone_num:String= view.findViewById<EditText>(R.id.et_mobile_email)
            .text.toString().trim()//email or phone store variable
        val password:String=view.findViewById<EditText>(R.id.et_password)
            .text.toString().trim()//password store variable

        // Inflate the layout for this fragment
        return view
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Signup_page_Fragement.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Signup_page_Fragement().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}