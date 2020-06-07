package io.tristanlarsin.toaster

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.FrameLayout.LayoutParams.WRAP_CONTENT
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding

@SuppressLint("InflateParams")
class Toaster(private val context: Context) {

    private val toast: Toast
    private val view: View

    private var height = WRAP_PARENT
    private var width = WRAP_PARENT

    private var length = LENGTH_SHORT
    private var typeFace = DEFAULT_TYPEFACE

    private var textAlignment = ALIGN_START
    @ColorRes
    private var textColor = R.color.white
    private var textSize = 16f
    private var textPadding = 10

    private var cardElevation = 8

    @ColorRes
    private var cardBackgroundColor: Int = R.color.black
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
        textView.text = message
        setParams()
        toast.show()
        resetParams()
    }

    fun show(@StringRes msgResId: Int) {
        textView.setText(msgResId)
        setParams()
        toast.show()
        resetParams()
    }

    fun setDimensions(width: Int = WRAP_PARENT, height: Int = WRAP_PARENT) : Toaster {
        this.width = width
        this.height = height
        return this
    }

    fun setTextAlignment(alignment: Int) : Toaster {
        textAlignment = alignment
        return this
    }

    // Set text size
    fun setTextSize(size: Float): Toaster {
        textSize = size
        return this
    }

    // Set Text Color
    fun setTextColor(color: Int): Toaster {
        textColor = color
        return this
    }

    // Set Text Padding
    fun setTextPadding(padding: Int): Toaster {
        textPadding = padding
        return this
    }

    fun setTypeFace(typeface: Typeface) : Toaster {
        typeFace = typeface
        return this
    }

    // Set background color
    fun setBackgroundColor(@ColorRes color: Int): Toaster {
        cardBackgroundColor = color
        return this
    }

    // Set radius
    fun setRadius(radius: Int): Toaster {
        cardRadius = radius
        return this
    }

    fun setElevation(elevation: Int): Toaster {
        cardElevation = elevation
        return this
    }

    // Align Toast
    fun align(value: Int, horizontalOffset: Int = 0, verticalOffset: Int = 0): Toaster {
        toast.setGravity(value, horizontalOffset, verticalOffset)
        return this
    }

    // Set Toast Duration
    fun setLength(length: Int): Toaster {
        this.length = length
        return this
    }

    // Call before showing
    private fun setParams() {
        textView.setPadding(textPadding)
        textView.textSize = textSize
        textView.typeface = typeFace
        textView.setTextColor(ContextCompat.getColor(context, textColor))
        textView.layoutParams = FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            gravity = textAlignment
        }

        cardView.setCardBackgroundColor(ContextCompat.getColor(context, cardBackgroundColor))
        cardView.radius = cardRadius.toFloat()
        cardView.cardElevation = cardElevation.toFloat()

        val params = RelativeLayout.LayoutParams(width, height)
        root.layoutParams = params
        cardView.layoutParams = params

        toast.duration = length
    }

    // Reset Params
    private fun resetParams() {
        width = WRAP_PARENT
        height = WRAP_PARENT
        length = LENGTH_SHORT
        textAlignment = ALIGN_START
        typeFace = Typeface.DEFAULT
        textColor = R.color.white
        textSize = 16f
        textPadding = 10

        cardElevation = 8
        cardBackgroundColor = R.color.black
        cardRadius = 8
    }

    private val toastView = toast.view
    private val textView = toastView.findViewById<TextView>(R.id.tv_message)
    private val cardView = toastView.findViewById<CardView>(R.id.card_view)

    private val root = toastView.findViewById<RelativeLayout>(R.id.rl_root)

    companion object {
        val DEFAULT_TYPEFACE: Typeface = Typeface.DEFAULT

        // Toast duration
        const val LENGTH_SHORT = Toast.LENGTH_SHORT
        const val LENGTH_LONG = Toast.LENGTH_LONG

        // Layout Params
        const val MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT
        const val WRAP_PARENT = ViewGroup.LayoutParams.WRAP_CONTENT

        // Toast position
        const val ALIGN_TOP = Gravity.TOP
        const val ALIGN_BOTTOM = Gravity.BOTTOM
        const val ALIGN_START = Gravity.START
        const val ALIGN_END = Gravity.END
        const val CENTER = Gravity.CENTER
        const val CENTER_VERTICAL = Gravity.CENTER_VERTICAL
        const val CENTER_HORIZONTAL = Gravity.CENTER_HORIZONTAL
        const val FILL = Gravity.FILL
        const val FILL_HORIZONTAL = Gravity.FILL_HORIZONTAL
        const val FILL_VERTICAL = Gravity.FILL_VERTICAL
    }
}