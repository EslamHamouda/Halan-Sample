package com.android.consumerfinancehalan.di

import com.android.consumerfinancehalan.data.service.ApiService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://api.halan.io/bff-mobile/vendor-Discovery/public/"
    @Provides
    @Singleton
    @Named("RetrofitObject")
    fun provideRetrofit(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(Interceptor { chain: Interceptor.Chain ->
            chain.proceed(
                chain.request().newBuilder()
                    .build()
            )
        })
        httpClient.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()
    }

    @Provides
    fun retrofitServices(
        @Named("RetrofitObject")
        retrofit: Retrofit
    ): ApiService =
        retrofit.create(ApiService::class.java)
}