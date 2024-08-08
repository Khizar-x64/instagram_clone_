package com.example.instagram_clone_
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.instagram_clone_.R.id
import com.example.instagram_clone_.R.layout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layout.activity_main)

        val StarterFragment=StarterFragment()
        supportFragmentManager.beginTransaction().
                add(id.main_Fragement_Container,StarterFragment).
                commit()
        /*val startLogo=findViewById<ImageView>(id.start_logo)
        startLogo.setOnClickListener()
        {
           monotoneFragment(Login_Page_Fragement())

        }*/
    }

    /*private fun monotoneFragment(fragment: Fragment) {
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(id.Fragment_layout,fragment)

        fragmentTransaction.commit()
    }*/



}

