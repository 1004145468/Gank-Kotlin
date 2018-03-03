package gank.yl.com.gank.injection.module

import android.content.Context
import dagger.Module
import dagger.Provides
import gank.yl.com.gank.manager.Api
import gank.yl.com.gank.manager.ApiFactory
import javax.inject.Singleton

/**
 * Created by YangLang on 2018/3/2.
 */
@Singleton
@Module
class ApplicationModule constructor(private val context: Context) {

    @Singleton
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    fun provideApi() = ApiFactory.INSTANCE.createApi(Api::class.java)
}