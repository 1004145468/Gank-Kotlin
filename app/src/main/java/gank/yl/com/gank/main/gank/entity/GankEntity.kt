package gank.yl.com.gank.main.gank.entity

import gank.yl.com.gank.common.BaseEntity

/**
 * Created by YangLang on 2018/3/2.
 */
class GankEntity : BaseEntity() {

    val results: ArrayList<ResultEntity>? = null

    class ResultEntity {
        val _id: String? = null
        val url: String? = null
        val type: String? = null
        val who: String? = null
    }
}