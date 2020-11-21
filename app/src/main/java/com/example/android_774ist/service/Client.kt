package com.example.android_774ist.service

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class Client {
    //Clientを作成
    val httpBuilder: OkHttpClient.Builder get() {
        //HttpClientのBuilderを作成する
        val httpClient = OkHttpClient.Builder()
        //create http client headerの追加
        httpClient.addInterceptor(Interceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("Accept", "application/json")
                .method(original.method(),original.body())
                .build()

            //proceedメソッドは再びパーミッション許可ダイアログを表示してその結果を返します
            return@Interceptor chain.proceed(request)
        })
            .readTimeout(30,TimeUnit.SECONDS)

        //log
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(loggingInterceptor)

        return  httpClient
    }
}