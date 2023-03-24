package com.example.minhascores

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var sbRed: SeekBar
    private lateinit var sbGreen: SeekBar
    private lateinit var sbBlue: SeekBar
    private lateinit var tvRed: TextView
    private lateinit var tvGreen: TextView
    private lateinit var tvBlue: TextView
    private lateinit var llColor: LinearLayout
    private lateinit var tvColor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.sbRed = findViewById(R.id.sbRed)
        this.sbGreen = findViewById(R.id.sbGreen)
        this.sbBlue = findViewById(R.id.sbBlue)

        this.tvRed = findViewById(R.id.tvRed)
        this.tvGreen = findViewById(R.id.tvGreen)
        this.tvBlue = findViewById(R.id.tvBlue)
        tvColor = findViewById(R.id.tvColor)

        this.llColor = findViewById(R.id.llColor)
        this.llColor.setBackgroundColor(this.createColor())
        this.sbRed.setOnSeekBarChangeListener(OnChangeColor())
        this.sbGreen.setOnSeekBarChangeListener(OnChangeColor())
        this.sbBlue.setOnSeekBarChangeListener(OnChangeColor())
    }

    fun createColor(): Int{
        val red = this@MainActivity.sbRed.progress
        val green = this@MainActivity.sbGreen.progress
        val blue = this@MainActivity.sbBlue.progress

        return Color.rgb(red, green, blue)
    }

    fun invertColor(): Int{
        val red = this@MainActivity.sbRed.progress
        val green = this@MainActivity.sbGreen.progress
        val blue = this@MainActivity.sbBlue.progress
        return Color.rgb(255 - red, 255 - green, 255 - blue)
    }

    private fun changeResultColor() {
        val red = this.sbRed.progress
        val green = this.sbGreen.progress
        val blue = this.sbBlue.progress
        val color = Color.rgb(red, green, blue)

        this.llColor.setBackgroundColor(color)
        this.tvColor.setTextColor(color)
        this.tvColor.text = this.hexColor(this.createColor())
    }

    fun hexColor(color: Int): String {
        return Integer.toHexString(color)
    }

    inner class OnChangeColor: OnSeekBarChangeListener{
        override fun onProgressChanged(p0: SeekBar?, progress: Int, progress2: Boolean) {
            val red = this@MainActivity.sbRed.progress
            val green = this@MainActivity.sbGreen.progress
            val blue = this@MainActivity.sbBlue.progress

            this@MainActivity.tvRed.text = red.toString()
            this@MainActivity.tvGreen.text = green.toString()
            this@MainActivity.tvBlue.text = blue.toString()
            this@MainActivity.tvColor.text = this@MainActivity.hexColor(this@MainActivity.createColor())
            this@MainActivity.tvColor.setTextColor(this@MainActivity.invertColor())
            this@MainActivity.llColor.setBackgroundColor(this@MainActivity.createColor())

        }



        override fun onStartTrackingTouch(p0: SeekBar?) {

        }

        override fun onStopTrackingTouch(p0: SeekBar?) {

        }

    }
}