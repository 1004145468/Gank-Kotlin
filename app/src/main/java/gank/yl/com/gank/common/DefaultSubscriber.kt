package gank.yl.com.gank.common

import android.content.Context
import gank.yl.com.gank.R
import gank.yl.com.gank.ext.showToast
import rx.Subscriber

/**
 * Created by YangLang on 2018/3/3.
 */
open class DefaultSubscriber<T>(private val context: Context) : Subscriber<T>() {

    override fun onCompleted() {
    }

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable?) {
        context.showToast(context.getString(R.string.networkerror))
    }
}