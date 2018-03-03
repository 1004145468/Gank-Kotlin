package gank.yl.com.gank.main.technology.presenter

import android.content.Context
import gank.yl.com.gank.common.DefaultSubscriber
import gank.yl.com.gank.ext.isEmpty
import gank.yl.com.gank.main.technology.TechnologyContract
import gank.yl.com.gank.main.technology.entity.TechnologyEntity
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by YangLang on 2018/3/3.
 */
class TechnologyPresenter(private val mContext: Context,
                          private val technologyView: TechnologyContract.TechnologyView,
                          private val technologyModel: TechnologyContract.TechnologyModel) : TechnologyContract.TechnologyPresenter {

    override fun reqTechnologyDatas(technology: String, count: Int) {
        technologyModel.reqTechnologyDatas(technology, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DefaultSubscriber<TechnologyEntity>(mContext) {

                    override fun onNext(t: TechnologyEntity) {
                        if (t != null && !isEmpty(t.results))
                            technologyView.refreshData(t.results!!)
                    }
                })
    }
}