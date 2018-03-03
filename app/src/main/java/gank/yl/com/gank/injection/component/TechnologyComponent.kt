package gank.yl.com.gank.injection.component

import dagger.Component
import gank.yl.com.gank.injection.module.TechnologyModule
import gank.yl.com.gank.injection.scope.PerFragment
import gank.yl.com.gank.main.technology.ui.TechnologyTabView

/**
 * Created by YangLang on 2018/3/3.
 */
@PerFragment
@Component(modules = arrayOf(TechnologyModule::class), dependencies = arrayOf(ApplicationComponent::class))
interface TechnologyComponent {

    fun inject(tabView: TechnologyTabView)
}