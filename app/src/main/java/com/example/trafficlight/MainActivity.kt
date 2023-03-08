package com.example.trafficlight

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var b_1: LinearLayout
    lateinit var b_2: LinearLayout
    lateinit var b_3: LinearLayout
    lateinit var but: Button
    var start_stop = false
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b_1 = findViewById(R.id.light_1)
        b_2 = findViewById(R.id.light_2)
        b_3 = findViewById(R.id.light_3)
        but = findViewById(R.id.start_button)
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    fun onClickStart(view: View) {
        if (!start_stop) {
            but.text = "Stop"
            start_stop = true
            Thread {


                    while (start_stop) {
                        counter++
                        when (counter) {
                            1 -> {
                                b_1.setBackgroundColor(R.color.green)
                                b_2.setBackgroundColor(R.color.grey)
                                b_3.setBackgroundColor(R.color.grey)
                                break
                            }
                            2 -> {
                                b_1.setBackgroundColor(R.color.grey)
                                b_2.setBackgroundColor(R.color.yellow)
                                b_3.setBackgroundColor(R.color.grey)
                                break
                            }
                            3 -> {
                                b_1.setBackgroundColor(R.color.grey)
                                b_2.setBackgroundColor(R.color.grey)
                                b_3.setBackgroundColor(R.color.red)
                                counter = 0
                                break
                            }
                        }
                        Thread.sleep(3000)
                    }

            }.start()
        } else {
            but.text = "Start"
            start_stop = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        start_stop = false
    }
}