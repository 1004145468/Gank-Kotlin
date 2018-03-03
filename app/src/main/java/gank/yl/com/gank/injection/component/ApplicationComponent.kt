package gank.yl.com.gank.injection.component

import android.content.Context
import dagger.Component
import gank.yl.com.gank.injection.module.ApplicationModule
import gank.yl.com.gank.manager.Api
import javax.inject.Singleton

/**
 * Created by YangLang on 2018/3/2.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun provideContext():Context

    fun provideApi(): Api
}