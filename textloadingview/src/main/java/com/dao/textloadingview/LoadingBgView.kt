package com.dao.textloadingview

import android.content.Context
import android.graphics.*
import android.renderscript.Double2
import android.support.v4.content.res.TypedArrayUtils.getText
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import com.dao.textloadingview.utils.dip2Px
import org.w3c.dom.Text

/**
 *
 * @author daoz
 * @date :2020/4/24 17:50
 */

class LoadingBgView : View {
    private val textPaint = TextPaint()
    private val bounds = Rect()
    var text = "文字动画"
    var textSize = 45f
    var textColor = "#D1D1D1"

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        textPaint.color = Color.parseColor(textColor)
        textPaint.isAntiAlias = true
        textPaint.textSize = dip2Px(textSize)
        textPaint.typeface = Typeface.createFromAsset(context.assets, "fonts/select-title-black.ttf");
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        textPaint.getTextBounds(text, 0, text.length, bounds)
        canvas?.drawText(text, dip2Px(0f), (bounds.bottom - bounds.top).toFloat(), textPaint)
    }


    fun setLoadingBgTextSize(textSize: Float) {
        this.textSize = textSize
        textPaint.textSize = textSize
        invalidate()
    }

    fun setLoadingBgTextColor(textColor: String) {
        this.textColor = textColor
        textPaint.color = Color.parseColor(textColor)
        invalidate()
    }
}