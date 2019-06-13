package br.com.hussan.enjoeitest.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import br.com.hussan.enjoeitest.R
import kotlinx.android.synthetic.main.view_circle_icon_layout.view.*

class CircleIconView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        View.inflate(context, R.layout.view_circle_icon_layout, this)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.CircleIconView, 0, 0
            )

            val icon = resources.getDrawable(typedArray.getResourceId(R.styleable.CircleIconView_icon, 0), null)

            btnCircle.setImageDrawable(icon)
            typedArray.recycle()
        }
    }

    fun setBadgeCount(value: Int) {
        txtBadgeCount.text = "$value"
        txtBadgeCount.visibility = if (value > 0) {
            btnCircle.setColorFilter(
                ContextCompat.getColor(context, R.color.colorPrimary),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}
