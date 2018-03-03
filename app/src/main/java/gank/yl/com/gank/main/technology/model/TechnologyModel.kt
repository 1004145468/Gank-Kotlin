package gank.yl.com.gank.main.technology.model

import gank.yl.com.gank.main.technology.TechnologyContract
import gank.yl.com.gank.main.technology.entity.TechnologyEntity
import gank.yl.com.gank.manager.Api
import rx.Observable

/**
 * Created by YangLang on 2018/3/3.
 */
class TechnologyModel(private val api: Api) : TechnologyContract.TechnologyModel {

    override fun reqTechnologyDatas(technology: String, count: Int): Observable<TechnologyEntity> {
        return api.getTechlonogyKnowledge(technology, count)
    }
}