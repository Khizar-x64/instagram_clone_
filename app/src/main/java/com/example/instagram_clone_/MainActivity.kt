package com.example.instagram_clone_
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram_clone_.R.id
import com.example.instagram_clone_.R.layout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layout.activity_main)

        val fragment=StarterFragment()
        supportFragmentManager.beginTransaction().
                add(id.main_Fragement_Container,fragment).
                commit()

    }
}

