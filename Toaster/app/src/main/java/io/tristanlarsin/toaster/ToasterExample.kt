package io.tristanlarsin.toaster

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
                .setTextColor(R.color.colorPrimary)
                .setBackgroundColor(R.color.colorAccent)
                .setTextPadding(40)
                .setRadius(50)
                .setLength(Toaster.LENGTH_SHORT)
                .show("Bottom Toast")
        }

        btn_top.setOnClickListener {
            Toaster(this)
                .setTextSize(20f)
                .align(Toaster.ALIGN_TOP, 0, 200)
                .setTextColor(R.color.white)
                .setElevation(10)
                .setLength(Toaster.LENGTH_LONG)
                .show("Top Toast")
        }
    }
}
