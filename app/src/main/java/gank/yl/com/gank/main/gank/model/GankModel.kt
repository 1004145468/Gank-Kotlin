package gank.yl.com.gank.main.gank.model

import gank.yl.com.gank.main.gank.entity.GankEntity
import gank.yl.com.gank.main.gank.GankContract
import gank.yl.com.gank.manager.Api
import rx.Observable

/**
 * Created by YangLang on 2018/3/3.
 */
class GankModel(private val mApi: Api) : GankContract.GankModel {

    override fun reqGankData(page: Int, count: Int): Observable<GankEntity> {
        return mApi.getGankMeiZi(count, page)
    }
}