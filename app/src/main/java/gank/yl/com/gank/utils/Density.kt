package gank.yl.com.gank.utils

import android.content.Context

/**
 * Created by YangLang on 2018/3/2.
 */
fun px2dp(context: Context, pxValue: Float): Int {
    val scale = context.resources.displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()
}

fun dp2px(context: Context, dpvalue: Float): Int {
    val scale = context.resources.displayMetrics.density
    return (dpvalue * scale + 0.5f).toInt()
}

fun getScreenWidth(context: Context) = context.resources.displayMetrics.widthPixels

fun getScreenHeight(context: Context) = context.resources.displayMetrics.heightPixels