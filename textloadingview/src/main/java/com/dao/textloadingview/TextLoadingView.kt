package com.dao.textloadingview

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.dao.textloadingview.utils.dip2Px

/**
 *
 * @author daoz
 * @date :2020/4/24 17:04
 */
class TextLoadingView : FrameLayout {
    private val textView = LoadingBgView(context)
    private val loadingView = LoadingView(context)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val custom = context?.obtainStyledAttributes(attrs, R.styleable.TextLoadingView, defStyleAttr, 0)
        // 文字
        val text = custom?.getText(R.styleable.TextLoadingView_loadingText)
        // 文字大小
        val textSize = custom?.getDimension(R.styleable.TextLoadingView_loadingTextSize, 45f)
        // 文字背景颜色
        val textBgColor = custom?.getString(R.styleable.TextLoadingView_loadingTextBgColor)
        // 线条文字移动颜色
        val textTopColor = custom?.getString(R.styleable.TextLoadingView_loadingTextTopColor)
        // 动画时间
        val animationTime = custom?.getInteger(R.styleable.TextLoadingView_loadingTextAnimationTime, 1500)
        // 移动线条宽度
        val lineWidth = custom?.getDimension(R.styleable.TextLoadingView_loadingTextLineWidth, dip2Px(15f))
        // 移动线条偏移距离
        val offsetDistance = custom?.getDimension(R.styleable.TextLoadingView_loadingTextOffsetDistance, dip2Px(25f))
        // 是否循环 默认为true
        val isInfinite = custom?.getBoolean(R.styleable.TextLoadingView_loadingTextIsInfinite, true)
        // 是否自动开始 默认为true
        val isStartAnimation = custom?.getBoolean(R.styleable.TextLoadingView_loadingTextIsStartAnimation, true)
        textView.text = text.toString()
        loadingView.setLoadingText(text.toString())
        if (textSize != null) {
            textView.setLoadingBgTextSize(textSize)
            loadingView.setLoadingTextSize(textSize)
        }
        textView.setLoadingBgTextColor(textBgColor.toString())
        loadingView.setLoadingTextColor(textTopColor.toString())
        if (animationTime != null) {
            loadingView.setLoadingAnimationTime(animationTime)
        }
        if (lineWidth != null) {
            loadingView.setLineWidth(lineWidth)
        }
        if (offsetDistance != null) {
            loadingView.setOffsetDistance(offsetDistance)
        }
        if (isInfinite != null) {
            loadingView.setIsInfinite(isInfinite)
        }
        if (isStartAnimation != null) {
            loadingView.setIsStartAnimation(isStartAnimation)
        }
    }

    init {
        addView(textView)
        addView(loadingView)
    }

    /**
     * 开始动画
     */
    fun startAnimation() {
        loadingView.startAnimation()
    }

    /**
     * 停止动画
     */
    fun stopAnimation() {
        loadingView.stopAnimation()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        measureChildren(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(loadingView.measuredWidth, loadingView.measuredHeight)
    }

}
