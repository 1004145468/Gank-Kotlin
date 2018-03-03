package gank.yl.com.gank.main.gank

import gank.yl.com.gank.main.gank.entity.GankEntity
import rx.Observable

/**
 * Created by YangLang on 2018/3/3.
 */
interface GankContract {

    interface GankPresenter {

        fun reqGankData(page: Int, count: Int)
    }

    interface GankModel {

        fun reqGankData(page: Int, count: Int): Observable<GankEntity>
    }

    interface GankView {
        fun dealGankData(isFirstPage: Boolean, datas: ArrayList<GankEntity.ResultEntity>)
    }
}