package io.tristanlarsin.toaster

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class ToasterExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_bottom.setOnClickListener {
            Toaster(this)
                .setTextSize(12f)
                .setDimensions(Toaster.MATCH_PARENT, 200)
                .setTextColor(R.color.black)
                .setBackgroundColor(R.color.white)
                .setTypeFace(Typeface.DEFAULT_BOLD)
                .setTextPadding(40)
                .setRadius(50)
                .setLength(Toaster.LENGTH_SHORT)
                .show(R.string.bottom_toast)
        }

        btn_top.setOnClickListener {
            Toaster(this)
                .setTextSize(20f)
                .align(Toaster.ALIGN_TOP, 0, 200)
                .setTextAlignment(Toaster.CENTER_HORIZONTAL)
                .setDimensions(Toaster.MATCH_PARENT)
                .setTextColor(R.color.white)
                .setElevation(10)
                .setLength(Toaster.LENGTH_LONG)
                .show("Top Toast")
        }
    }
}
