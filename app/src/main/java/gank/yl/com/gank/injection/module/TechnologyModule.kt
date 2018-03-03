package gank.yl.com.gank.injection.module

import android.content.Context
import dagger.Module
import dagger.Provides
import gank.yl.com.gank.injection.scope.PerFragment
import gank.yl.com.gank.main.technology.TechnologyContract
import gank.yl.com.gank.main.technology.model.TechnologyModel
import gank.yl.com.gank.main.technology.presenter.TechnologyPresenter
import gank.yl.com.gank.manager.Api

/**
 * Created by YangLang on 2018/3/3.
 */
@PerFragment
@Module
class TechnologyModule(private val technologyView: TechnologyContract.TechnologyView) {

    @PerFragment
    @Provides
    fun provideTechnologyView() = technologyView

    @PerFragment
    @Provides
    fun provideTechnologyModel(api: Api): TechnologyContract.TechnologyModel {
        return TechnologyModel(api)
    }

    @PerFragment
    @Provides
    fun provideTechnologyPersenter(context: Context, view: TechnologyContract.TechnologyView, model: TechnologyContract.TechnologyModel): TechnologyPresenter {
        return TechnologyPresenter(context, view, model)
    }
}