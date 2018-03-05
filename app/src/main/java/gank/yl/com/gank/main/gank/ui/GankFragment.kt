package gank.yl.com.gank.main.gank.ui

import android.support.v7.widget.LinearLayoutManager
import gank.yl.com.gank.R
import gank.yl.com.gank.common.BaseFragment
import gank.yl.com.gank.common.DATA_COUNT
import gank.yl.com.gank.common.GankApplication
import gank.yl.com.gank.common.SpaceItemDecoration
import gank.yl.com.gank.injection.component.DaggerGankComponent
import gank.yl.com.gank.injection.module.GankModule
import gank.yl.com.gank.main.gank.GankContract
import gank.yl.com.gank.main.gank.entity.GankEntity
import gank.yl.com.gank.utils.LoadMoreHelper
import kotlinx.android.synthetic.main.fragment_pic.*
import javax.inject.Inject

/**
 * Created by YangLang on 2018/3/2.
 */
class GankFragment : BaseFragment(), GankContract.GankView {

    private var mPage = 0
    private var isFinishLoadingMore = true
    private lateinit var mGankAdapter: GankAdapter
    @Inject lateinit var mGankPresenter: GankContract.GankPresenter


    override fun getLayoutId(): Int {
        return R.layout.fragment_pic
    }

    override fun init() {
        DaggerGankComponent.builder()
                .gankModule(GankModule(this))
                .applicationComponent(GankApplication.applicationComponent)
                .build()
                .inject(this)
        initViews()
        mGankPresenter.reqGankData(0, DATA_COUNT)
    }

    private fun initViews() {
        val mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mPicRecyclerView.layoutManager = mLayoutManager
        mPicRecyclerView.addItemDecoration(SpaceItemDecoration(2f))
        val mData = ArrayList<GankEntity.ResultEntity>()
        mGankAdapter = GankAdapter(activity)
        mGankAdapter.setData(mData)
        mPicRecyclerView.adapter = mGankAdapter
        mPicSwipeLayout.setOnRefreshListener {
            mGankPresenter.reqGankData(0, DATA_COUNT)
        }
        LoadMoreHelper.init(mPicRecyclerView, object : LoadMoreHelper.LoadMoreConfigLoader() {
            override fun isFinishLoadMore(): Boolean {
                return isFinishLoadingMore
            }

            override fun LoadMoreData() {
                isFinishLoadingMore = false
                mGankPresenter.reqGankData(mPage, DATA_COUNT)
            }
        })
    }

    override fun dealGankData(isFirstPage: Boolean, datas: ArrayList<GankEntity.ResultEntity>) {
        if (mPicSwipeLayout.isRefreshing) {
            mPicSwipeLayout.isRefreshing = false
        }
        if (isFirstPage) {
            mGankAdapter.clearDatas()
            mPage = 0
        } else {
            isFinishLoadingMore = true
        }
        mPage++
        mGankAdapter.addDatas(datas)
    }
}