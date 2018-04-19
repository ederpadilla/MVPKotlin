package dev.eder.padilla.mvpkotlin.api

import com.google.gson.GsonBuilder
import dev.eder.padilla.mvpkotlin.BuildConfig.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceGenerator {
    private val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val httpClient = OkHttpClient.Builder()
            .addInterceptor(logging)

    private val gson = GsonBuilder().create()


    private val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())


    fun <S> createService(serviceClass: Class<S>): S {
        return createService(serviceClass, null)
    }


    fun <S> createService(serviceClass: Class<S>, token: String?): S {
        httpClient.connectTimeout(90, TimeUnit.SECONDS)
        httpClient.readTimeout(90, TimeUnit.SECONDS)
        httpClient.writeTimeout(90, TimeUnit.SECONDS)
        val client = httpClient.build()
        val retrofit = builder.client(client).build()
        return retrofit.create(serviceClass)
    }

    fun getService(): LogInClient {
        return createService<LogInClient>(LogInClient::class.java)
    }
}