package com.android.consumerfinancehalan.remote

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteClient {
    private const val BASE_URL = "https://api.halan.io/bff-mobile/vendor-Discovery/public/"
    private val gson = GsonBuilder()
            .setLenient()
            .create()
    private val logging = HttpLoggingInterceptor()
        .apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
            setLevel(HttpLoggingInterceptor.Level.HEADERS)
        }
    private val httpClient = OkHttpClient.Builder()
            .addInterceptor(Interceptor { chain: Interceptor.Chain ->
                chain.proceed(chain.request().newBuilder().build())
            })
            .addInterceptor(logging)
            .build()
    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient)
            .build()
}

