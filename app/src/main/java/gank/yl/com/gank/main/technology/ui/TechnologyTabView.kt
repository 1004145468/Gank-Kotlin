package gank.yl.com.gank.main.technology.ui

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import gank.yl.com.gank.R
import gank.yl.com.gank.common.BaseTabView
import gank.yl.com.gank.common.GankApplication
import gank.yl.com.gank.common.SpaceItemDecoration
import gank.yl.com.gank.injection.component.DaggerTechnologyComponent
import gank.yl.com.gank.injection.module.TechnologyModule
import gank.yl.com.gank.main.technology.TechnologyContract
import gank.yl.com.gank.main.technology.entity.TechnologyEntity
import gank.yl.com.gank.main.technology.presenter.TechnologyPresenter
import kotlinx.android.synthetic.main.view_technology.view.*
import javax.inject.Inject

/**
 * Created by YangLang on 2018/3/3.
 */
class TechnologyTabView(TechnologyName: String, context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : BaseTabView(TechnologyName, context, attrs, defStyleAttr), TechnologyContract.TechnologyView {

    private lateinit var mTechnologyAdapter: TechnologyAdapter
    @Inject lateinit var mTechnologyPresenter: TechnologyPresenter

    override fun getLayoutId(): Int {
        return R.layout.view_technology
    }

    override fun initView() {

        DaggerTechnologyComponent.builder()
                .applicationComponent(GankApplication.applicationComponent)
                .technologyModule(TechnologyModule(this))
                .build()
                .inject(this)

        mTechnologyRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mTechnologyRecyclerView.addItemDecoration(SpaceItemDecoration(2f))
        val datas = ArrayList<TechnologyEntity.ResultEntity>()
        mTechnologyAdapter = TechnologyAdapter(context)
        mTechnologyAdapter.setData(datas)
        mTechnologyRecyclerView.adapter = mTechnologyAdapter

        mTechnologyPresenter.reqTechnologyDatas(mTabTitle, 100)
    }

    override fun refreshData(datas: ArrayList<TechnologyEntity.ResultEntity>) {
        mTechnologyAdapter.addDatas(datas)
    }
}