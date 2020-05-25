package io.tristanlarsin.toaster

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding

@SuppressLint("InflateParams")
class Toaster(private val context: Context) {

    private val toast: Toast
    private val view: View

    private var length = LENGTH_SHORT
    private var typeFace = Typeface.DEFAULT
    @ColorRes
    private var textColor = R.color.white
    private var textSize = 16f
    private var textPadding = 10

    private var cardElevation = 8
    @ColorRes
    private var cardBackgroundColor : Int = R.color.black
    private var cardRadius = 8

    private val inflater by lazy {
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    init {
        view = inflater.inflate(R.layout.toast_layout, null)
        val toast = Toast(context)
        toast.duration = LENGTH_SHORT
        toast.view = view
        this.toast = toast
    }

    fun show(message: String) {
        toastView.findViewById<TextView>(R.id.tv_message).text = message
        setParams()
        toast.show()
    }

    // Set text size
    fun setTextSize(size: Float) : Toaster {
        textSize = size
        return this
    }

    // Set Text Color
    fun setTextColor(color: Int) : Toaster {
        textColor = color
        return this
    }

    // Set Text Padding
    fun setTextPadding(padding: Int) : Toaster {
        textPadding = padding
        return this
    }

    // Set background color
    fun setBackgroundColor(@ColorRes color: Int) : Toaster {
        cardBackgroundColor = color
        return this
    }

    // Set radius
    fun setRadius(radius: Int) : Toaster {
        cardRadius = radius
        return this
    }

    fun setElevation(elevation: Int) : Toaster {
        cardElevation = elevation
        return this
    }

    // Align Toast
    fun align(value: Int, horizontalOffset: Int = 0, verticalOffset: Int = 0) : Toaster {
        toast.setGravity(value, horizontalOffset, verticalOffset)
        return this
    }

    // Set Toast Duration
    fun setLength(length: Int) : Toaster {
        this.length = length
        return this
    }

    // Call before showing
    private fun setParams() {
        textView.setPadding(textPadding)
        textView.textSize = textSize
        textView.typeface = typeFace
        textView.setTextColor(ContextCompat.getColor(context, textColor))

        cardView.setCardBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor))
        cardView.radius = cardRadius.toFloat()
        cardView.cardElevation = cardElevation.toFloat()

        toast.duration = length
    }

    private val toastView = toast.view
    private val textView = toastView.findViewById<TextView>(R.id.tv_message)
    private val cardView = toastView.findViewById<CardView>(R.id.card_view)

    companion object {
        // Toast duration
        const val LENGTH_SHORT = Toast.LENGTH_SHORT
        const val LENGTH_LONG = Toast.LENGTH_LONG

        // Toast position
        const val ALIGN_TOP = Gravity.TOP
        const val ALIGN_BOTTOM = Gravity.BOTTOM
        const val ALIGN_START = Gravity.START
        const val ALIGN_END = Gravity.END
        const val CENTER = Gravity.CENTER
    }
}