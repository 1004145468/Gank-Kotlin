package gank.yl.com.gank.injection.component

import dagger.Component
import gank.yl.com.gank.injection.module.GankModule
import gank.yl.com.gank.injection.scope.PerFragment
import gank.yl.com.gank.main.gank.ui.GankFragment

/**
 * Created by YangLang on 2018/3/3.
 */
@PerFragment
@Component(modules = arrayOf(GankModule::class), dependencies = arrayOf(ApplicationComponent::class))
interface GankComponent {
    fun inject(gankFragment: GankFragment)
}