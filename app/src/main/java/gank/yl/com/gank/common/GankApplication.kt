package gank.yl.com.gank.common

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import gank.yl.com.gank.injection.component.ApplicationComponent
import gank.yl.com.gank.injection.component.DaggerApplicationComponent
import gank.yl.com.gank.injection.module.ApplicationModule
import com.facebook.imagepipeline.core.ImagePipelineConfig



/**
 * Created by YangLang on 2018/3/2.
 */
class GankApplication : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        val config = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true)
                .build()
        Fresco.initialize(this, config)
        applicationComponent = DaggerApplicationComponent.builder()   //初始化Dagger2的全局Component
                .applicationModule(ApplicationModule(this))
                .build()
    }
}