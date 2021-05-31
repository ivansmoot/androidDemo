package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.mainButton.setOnClickListener {
            Toast.makeText(this, "hello?", Toast.LENGTH_SHORT).show()
        }

        viewBinding.mainButton.run {
            setOnTouchListener { _, event ->
                when(event.action) {
                    MotionEvent.ACTION_DOWN ->
                        animate().scaleX(0.8f).scaleY(0.8f).setDuration(300).start()
                    MotionEvent.ACTION_UP -> {
                        animate().scaleX(1f).scaleY(1f).setDuration(300).start()
                        performClick()
                    }
                }
                return@setOnTouchListener false
            }
        }
    }

}

