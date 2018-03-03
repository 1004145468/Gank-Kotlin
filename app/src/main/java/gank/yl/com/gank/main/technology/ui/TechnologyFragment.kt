package gank.yl.com.gank.main.technology.ui

import android.support.design.widget.TabLayout
import gank.yl.com.gank.R
import gank.yl.com.gank.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_technology.*

/**
 * Created by YangLang on 2018/3/2.
 */
class TechnologyFragment : BaseFragment() {

    private val mTabTitleRes = arrayOf(R.string.platform_android, R.string.platform_ios,
            R.string.platform_foreground, R.string.platform_extension)

    override fun getLayoutId(): Int {
        return R.layout.fragment_technology
    }

    override fun init() {
        mTabLayout.tabMode = TabLayout.MODE_FIXED
        mViewPager.adapter = TechnologyPageAdapter(context, mTabTitleRes)
        mTabLayout.setupWithViewPager(mViewPager)
    }
}