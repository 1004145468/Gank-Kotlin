package gank.yl.com.gank.injection.scope

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by YangLang on 2018/3/3.
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class PerFragment