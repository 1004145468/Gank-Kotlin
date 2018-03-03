package gank.yl.com.gank

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import gank.yl.com.gank.main.gank.ui.GankFragment
import gank.yl.com.gank.main.technology.ui.TechnologyFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mTechnologyFragment: Fragment
    private lateinit var mPicFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        mTechnologyFragment = TechnologyFragment()
        mPicFragment = GankFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.mFrameLayout, mPicFragment)
                .add(R.id.mFrameLayout, mTechnologyFragment)
                .commit()
        mBottomNavigation.setOnNavigationItemSelectedListener {
            changeFragment(it.order)
        }
    }

    private fun changeFragment(index: Int): Boolean {
        if (index == 0) {
            supportFragmentManager.beginTransaction().show(mTechnologyFragment).hide(mPicFragment).commit()
        } else {
            supportFragmentManager.beginTransaction().show(mPicFragment).hide(mTechnologyFragment).commit()
        }
        return true
    }
}
