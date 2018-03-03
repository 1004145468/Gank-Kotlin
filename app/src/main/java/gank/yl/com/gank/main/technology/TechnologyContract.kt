package gank.yl.com.gank.main.technology

import gank.yl.com.gank.main.technology.entity.TechnologyEntity
import rx.Observable

/**
 * Created by YangLang on 2018/3/3.
 */
interface TechnologyContract {

    interface TechnologyPresenter {
        fun reqTechnologyDatas(technology: String, count: Int)
    }

    interface TechnologyModel {
        fun reqTechnologyDatas(technology: String, count: Int): Observable<TechnologyEntity>
    }

    interface TechnologyView {
        fun refreshData(datas: ArrayList<TechnologyEntity.ResultEntity>)
    }
}