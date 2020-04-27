package com.dao.textloadingview.utils

import android.content.res.Resources
import android.view.View
import android.util.DisplayMetrics



/**
 *
 * @author daoz
 * @date :2020/4/11 11:14
 */

fun View.dip2Px(dpValue: Float): Float {
    return Math.round(resources.displayMetrics.density * dpValue).toFloat();
}
