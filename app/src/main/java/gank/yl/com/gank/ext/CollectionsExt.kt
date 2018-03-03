package gank.yl.com.gank.ext

/**
 * Created by YangLang on 2018/3/3.
 */
fun isEmpty(datas: Collection<Any>?): Boolean {
    return datas == null || datas.isEmpty()
}