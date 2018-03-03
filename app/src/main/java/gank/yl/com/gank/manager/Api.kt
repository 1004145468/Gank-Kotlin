package gank.yl.com.gank.manager

import gank.yl.com.gank.main.gank.entity.GankEntity
import gank.yl.com.gank.main.technology.entity.TechnologyEntity
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by YangLang on 2018/3/2.
 */
interface Api {

    @GET("/api/data/福利/{count}/{page}")
    fun getGankMeiZi(@Path("count") count: Int, @Path("page") page: Int): Observable<GankEntity>

    @GET("/api/data/{technology}/{count}/0")
    fun getTechlonogyKnowledge(@Path("technology") technology: String, @Path("count") count: Int): Observable<TechnologyEntity>

}