package com.apl.android_774ist.service

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class Client {

    companion object{
        private const val API_URL = "https://hirashu.net/api_774inc-Schedule/"
    }
    //Clientを作成
    private val httpBuilder: OkHttpClient.Builder get() {
        //HttpClientのBuilderを作成する
        val httpClient = OkHttpClient.Builder()
        //create http client headerの追加
        httpClient.addInterceptor(Interceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("Accept", "application/json")
                .method(original.method(), original.body())
                .build()

            //proceedメソッドは再びパーミッション許可ダイアログを表示してその結果を返します
            return@Interceptor chain.proceed(request)
        })
            .readTimeout(30, TimeUnit.SECONDS)

        //log
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(loggingInterceptor)

        return  httpClient
    }

    private val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()

    //繋ぎこみ
    fun createService(uri: String): ApiService {
        val client = httpBuilder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(uri)//基本のurl設定
            .addConverterFactory(GsonConverterFactory.create(gson))//Gsonの使用
            .client(client)//カスタマイズしたokhttpのクライアントの設定
            .build()
        return retrofit.create(ApiService::class.java)
    }

    fun createJsonService(): JsonService {
        val client = httpBuilder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))//Gsonの使用
            .client(client)//カスタマイズしたokhttpのクライアントの設定
            .build()
        return retrofit.create(JsonService::class.java)
    }
}