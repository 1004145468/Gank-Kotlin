package gank.yl.com.gank.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout

/**
 * Created by YangLang on 2018/3/3.
 */
abstract class BaseTabView : FrameLayout {

    protected var mTabTitle: String

    constructor(tabTitle: String, context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        this.mTabTitle = tabTitle
        LayoutInflater.from(context).inflate(getLayoutId(), this)
        initView()
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

}