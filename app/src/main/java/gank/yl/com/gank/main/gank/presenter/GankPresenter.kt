package gank.yl.com.gank.main.gank.presenter

import android.content.Context
import android.util.Log
import gank.yl.com.gank.main.gank.entity.GankEntity
import gank.yl.com.gank.common.DefaultSubscriber
import gank.yl.com.gank.ext.isEmpty
import gank.yl.com.gank.main.gank.GankContract
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by YangLang on 2018/3/3.
 */
class GankPresenter(private val mContext: Context,
                    private val mGankView: GankContract.GankView,
                    private val mGankModel: GankContract.GankModel) : GankContract.GankPresenter {

    override fun reqGankData(page: Int, count: Int) {
        Log.d("Test","page = " + page)
        mGankModel.reqGankData(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DefaultSubscriber<GankEntity>(mContext) {
                    override fun onNext(data: GankEntity) {
                        if (data != null && !isEmpty(data.results)) {
                            mGankView.dealGankData(page == 0, data.results!!)
                        }
                    }
                })
    }
}