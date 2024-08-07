package com.example.instagram_clone_
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram_clone_.R.*
import androidx.fragment.app.Fragment as Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layout.activity_main)
        val startLogo=findViewById<ImageView>(id.start_logo)
        startLogo.setOnClickListener()
        {
            monotoneFragment(Login_Page_Fragement())
        }
    }

    private fun monotoneFragment(fragment: Fragment) {
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()

        fragmentTransaction.replace(id.Fragement_layout,fragment)
        fragmentTransaction.commit()
    }
}

