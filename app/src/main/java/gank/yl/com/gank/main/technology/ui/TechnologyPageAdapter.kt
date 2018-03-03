package gank.yl.com.gank.main.technology.ui

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import gank.yl.com.gank.common.BaseTabView

/**
 * Created by YangLang on 2018/3/3.
 */
class TechnologyPageAdapter : PagerAdapter {

    private val mContext: Context
    private val mTabTitles:Array<Int>
    private val mTabViews: ArrayList<BaseTabView> = ArrayList()

    constructor(context: Context, mTabTitleRes: Array<Int>) : super() {
        this.mContext = context
        this.mTabTitles = mTabTitleRes
        for (tabRes in mTabTitleRes) {
            val baseTabView = TechnologyTabView(mContext.getString(tabRes), mContext)
            mTabViews.add(baseTabView)
        }
    }


    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return mTabViews.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val currentTabView = mTabViews[position]
        container.addView(currentTabView)
        return currentTabView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any?) {
        container.removeView(mTabViews[position])
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mContext.getString(mTabTitles[position])
    }
}