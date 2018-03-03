package gank.yl.com.gank.injection.module

import android.content.Context
import dagger.Module
import dagger.Provides
import gank.yl.com.gank.injection.scope.PerFragment
import gank.yl.com.gank.main.gank.GankContract
import gank.yl.com.gank.main.gank.model.GankModel
import gank.yl.com.gank.main.gank.presenter.GankPresenter
import gank.yl.com.gank.manager.Api

/**
 * Created by YangLang on 2018/3/3.
 */
@Module
@PerFragment
class GankModule(private val mGankView: GankContract.GankView) {

    @Provides
    @PerFragment
    fun provideGankView() = mGankView

    @Provides
    @PerFragment
    fun provideGankPresenter(context: Context, gankView: GankContract.GankView, gankModel: GankContract.GankModel): GankContract.GankPresenter {
        return GankPresenter(context, gankView, gankModel)
    }

    @Provides
    @PerFragment
    fun provideGankModel(api: Api): GankContract.GankModel {
        return GankModel(api)
    }
}