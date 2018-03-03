package gank.yl.com.gank.manager

import retrofit2.Retrofit
import gank.yl.com.gank.common.Host
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by YangLang on 2018/3/2.
 */
class ApiFactory private constructor() {

    private val mRetrofit: Retrofit

    init {
        mRetrofit = Retrofit.Builder()
                .baseUrl(Host)
                .client(initOKHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

    }

    private fun initOKHttp(): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(initReqHeaderInterceptor())
                .build()
    }

    private fun initReqHeaderInterceptor(): Interceptor {
        return Interceptor {
            val request = it.request().newBuilder()
                    .addHeader("Accept-Charset", "utf-8")  //设置编码方式
                    .addHeader("Content-Type", "application/json") //设置相应数据格式
                    .build()
            it.proceed(request)
        }
    }

    companion object {
        val INSTANCE: ApiFactory by lazy { ApiFactory() }
    }

    fun <T> createApi(apiFile: Class<T>) = mRetrofit.create(apiFile)
}